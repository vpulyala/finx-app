package com.osi.finx.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.osi.finx.exception.FinXTransactionException;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.dao.OsiGenericDAO;
import com.osi.finx.dao.RemittanceDAO;
import com.osi.finx.model.QxmaFtChargeStatus;
import com.osi.finx.model.QxmaFtCharges;
import com.osi.finx.model.QxmaFtMatchStatus;
import com.osi.finx.model.QxmaFtRemittance;
import com.osi.finx.model.RemittanceView;
import com.osi.finx.repository.RemittanceRepository;
import com.osi.finx.service.RemittanceService;

@Service
public class RemittanceServiceImpl implements RemittanceService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RemittanceServiceImpl.class);
	
	@Autowired
	private RemittanceDAO remittanceDAO;
	@Autowired
	private RemittanceRepository remittanceRepository;
	@Autowired
	private OsiGenericDAO osiDAO;
	
	@Override
	public QxmaFtCharges findConsumerOrderIdByReferenceId(String referenceId) throws OsiFinderException {
		LOGGER.debug("RemittanceServiceImpl :: findConsumerOrderIdByReferenceId :: START");
		LOGGER.debug("RemittanceServiceImpl :: findConsumerOrderIdByReferenceId :: referenceId = " + referenceId);
		
		QxmaFtCharges temp = remittanceDAO.findChargesByReferenceId(referenceId);
		QxmaFtCharges qfc = osiDAO.copyEntity(temp);
		
		LOGGER.debug("RemittanceServiceImpl :: findConsumerOrderIdByReferenceId :: END");
		return qfc;
	}

	@Override
	public QxmaFtRemittance findRemittanceByOrderId(Long orderId) throws OsiFinderException {
		LOGGER.debug("RemittanceServiceImpl :: findRemittanceByOrderId :: START");
		LOGGER.debug("RemittanceServiceImpl :: findRemittanceByOrderId :: orderId = " + orderId);
		
		QxmaFtRemittance entity = remittanceDAO.findRemittanceByOrderId(orderId);
		QxmaFtRemittance qfr = null;
		if (entity != null) {
			qfr = osiDAO.copyEntity(entity);
		}
		
		LOGGER.debug("RemittanceServiceImpl :: findRemittanceByOrderId :: END");
		return qfr;
	}

	@Override
	public List<QxmaFtRemittance> findRemittancesByOrderId(Long orderId) throws OsiFinderException {
		LOGGER.debug("RemittanceServiceImpl :: findRemittancesByOrderId :: START");
		LOGGER.debug("RemittanceServiceImpl :: findRemittancesByOrderId :: orderId = " + orderId);
		
		List<QxmaFtRemittance> list = remittanceDAO.findRemittancesByOrderId(orderId);

		LOGGER.debug("RemittanceServiceImpl :: findRemittancesByOrderId :: END");
		return list;
	}

	
	@Override
	@Transactional
	public void createRemittanceTransaction(QxmaFtRemittance remittance) throws OsiFinderException, FinXTransactionException {
		LOGGER.debug("RemittanceServiceImpl :: createRemittanceTransaction :: START");
		try {
			QxmaFtCharges charges = findConsumerOrderIdByReferenceId(remittance.getReferenceId());
			remittance.setOrderId(charges.getOrderId());
			
			double tenderedAmount = charges.getTenderedAmount().doubleValue();
			tenderedAmount += remittance.getAmountDeposited().doubleValue(); 
			
			double totalChange = charges.getTotalAmount().doubleValue() - tenderedAmount;
			
			QxmaFtMatchStatus matchStatus = new QxmaFtMatchStatus();
			
			// update the charge table - charge_status = remitted, compare charges.total_amount against remittance.amount_deposited. if
			// if charges.total_amount > remittance.amount_deposited = charge.match_status = under_remit
			//if charges.total_amount < remittance.amount_deposited = charge.match_status = over_remit
			//if charges.total_amount == remittance.amount_deposited = charge.match_status = match
			if (charges.getTotalAmount().doubleValue() > tenderedAmount) {
				matchStatus.setMsId(new Long(3));
			} else if (charges.getTotalAmount().doubleValue() < tenderedAmount) {
				matchStatus.setMsId(new Long(2));
			} else {
				matchStatus.setMsId(new Long(1));
			}
			
			QxmaFtChargeStatus chargeStatus = new QxmaFtChargeStatus();
			chargeStatus.setCsId(new Long(3));  //3 - REMITTED, 2 - PAID, 1 - PENDING
			
			charges.setTenderedAmount(new BigDecimal(tenderedAmount));
			charges.setChangeAmount(new BigDecimal(totalChange));
			
			charges.setQxmaFtMatchStatus(matchStatus);
			charges.setQxmaFtChargeStatus(chargeStatus);
			
			QxmaFtCharges qfc = osiDAO.findOne(charges.getOrderId(), QxmaFtCharges.class);
			qfc.setQxmaFtMatchStatus(charges.getQxmaFtMatchStatus());
			qfc.setQxmaFtChargeStatus(charges.getQxmaFtChargeStatus());
			qfc.setTenderedAmount(charges.getTenderedAmount());
			qfc.setChangeAmount(charges.getChangeAmount());
			
			osiDAO.saveOrUpdate(qfc);
			osiDAO.saveOrUpdate(remittance);
			
		} catch (OsiFinderException e) {
			LOGGER.error("RemittanceServiceImpl :: createRemittanceTransaction :: ERROR :: ", e);
			throw e;
		} catch (OsiTransactionException e) {
			LOGGER.error("RemittanceServiceImpl :: createRemittanceTransaction :: ERROR :: ", e);
			LOGGER.debug("RemittanceServiceImpl :: createRemittanceTransaction :: END");
			throw new FinXTransactionException(e);
//		} catch (FinXTransactionException e) {
//			LOGGER.error("RemittanceServiceImpl :: createRemittanceTransaction :: ERROR :: ", e);
//			LOGGER.debug("RemittanceServiceImpl :: createRemittanceTransaction :: END");
//			throw e;
		}
		
		LOGGER.debug("RemittanceServiceImpl :: createRemittanceTransaction :: END");
	}

	@Override
	@Cacheable("remittanceCache")
	public Page<QxmaFtRemittance> findRemittances(Pageable pageable) {
		return this.remittanceRepository.findAll(pageable);
	}

	@Override
	public List<RemittanceView> findByPaymentProcessor(String paymentProcessor, Pageable page) {
		LOGGER.debug("RemittanceServiceImpl :: findByPaymentProcessor :: START");
		return remittanceDAO.findByPaymentProcessor(paymentProcessor, page);
	}

	@Override
	public List<RemittanceView> findByClient(String client, Pageable page) {
		return remittanceDAO.findByClient(client, page);
	}

	@Override
	public List<RemittanceView> findByMatchStatus(String matchStatus, Pageable page) {
		return remittanceDAO.findByMatchStatus(matchStatus, page);
	}

	@Override
	public List<RemittanceView> findByOrderStatus(String orderStatus, Pageable page) {
		return remittanceDAO.findByOrderStatus(orderStatus, page);
	}

	@Override
	public String findRemittanceBankReference(String bankReferenceId) {
		return remittanceDAO.findRemittanceBankReference(bankReferenceId);
	}

}
