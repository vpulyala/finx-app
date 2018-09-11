package com.osi.finx.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.osi.finx.constants.OsiConstants.GENERIC_ERROR_CODES;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.dao.RemittanceDAO;
import com.osi.finx.model.QxmaFtCharges;
import com.osi.finx.model.QxmaFtRemittance;
import com.osi.finx.model.RemittanceView;

@Repository
public class RemittanceDAOImpl implements RemittanceDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RemittanceDAOImpl.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public QxmaFtCharges findChargesByReferenceId(String referenceId) throws OsiFinderException {
		LOGGER.debug("RemittanceDAOImpl :: findChargesByReferenceId :: START");
		LOGGER.debug("RemittanceDAOImpl :: findChargesByReferenceId :: Reference Id = " + referenceId);
		
		String JPQL = "select qfc from QxmaFtCharges qfc where qfc.referenceId = :refID";
		QxmaFtCharges qfc = (QxmaFtCharges) em.createQuery(JPQL)
											.setParameter("refID", referenceId)
											.getSingleResult();
		if (qfc == null) {
			throw new OsiFinderException("ERR_0006", GENERIC_ERROR_CODES.ERR_0006);
		}
		LOGGER.debug("RemittanceDAOImpl :: findChargesByReferenceId :: END");
		return qfc;
	}

	@Override
	public QxmaFtRemittance findRemittanceByOrderId(Long orderId) throws OsiFinderException {
		LOGGER.debug("RemittanceDAOImpl :: findRemittanceByOrderId :: START");
		LOGGER.debug("RemittanceDAOImpl :: findRemittanceByOrderId :: Order Id = " + orderId);

		String JPQL = "select qfr from QxmaFtRemittance qfr where qfr.orderId = :orderId";
		String JPQ_COUNT = "select count(qfr.orderId) from QxmaFtRemittance qfr where qfr.orderId = :orderId";
		QxmaFtRemittance qfr = null;
		
		Long count = (Long) em.createQuery(JPQ_COUNT)
				.setParameter("orderId", orderId)
				.getSingleResult();
		if (count != 0) {
			qfr =  (QxmaFtRemittance) em.createQuery(JPQL)
												.setParameter("orderId", orderId)
												.getSingleResult();
		}
		LOGGER.debug("RemittanceDAOImpl :: findRemittanceByOrderId :: END");
		return qfr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QxmaFtRemittance> findRemittancesByOrderId(Long orderId) throws OsiFinderException {
		LOGGER.debug("RemittanceDAOImpl :: findRemittanceByOrderId :: START");
		LOGGER.debug("RemittanceDAOImpl :: findRemittanceByOrderId :: Order Id = " + orderId);
		
		List<QxmaFtRemittance> list = null;
		String JPQL = "select qfr from QxmaFtRemittance qfr where  qfr.orderId = :orderId";
		list = (List<QxmaFtRemittance>) em.createQuery(JPQL)
														.setParameter("orderId", orderId)
														.getResultList();
		LOGGER.debug("RemittanceDAOImpl :: findRemittanceByOrderId :: END");
		return list;
	}

	@Override
	public QxmaFtCharges findChargesByOrderId(Long orderId) throws OsiFinderException {
		LOGGER.debug("RemittanceDAOImpl :: findChargesByOrderId :: START");
		LOGGER.debug("RemittanceDAOImpl :: findChargesByOrderId :: orderId = " + orderId);
		
		String JPQL = "select qfc from QxmaFtCharges qfc where qfc.orderId = :orderId";
		QxmaFtCharges qfc = (QxmaFtCharges) em.createQuery(JPQL)
																		.setParameter("orderId", orderId)
																		.getSingleResult();
		if (qfc == null) {
			throw new OsiFinderException("ERR_0006", GENERIC_ERROR_CODES.ERR_0006);
		}
		LOGGER.debug("RemittanceDAOImpl :: findChargesByOrderId :: END");
		return qfc;
	}

	@Override
	public List<RemittanceView> findByOrderStatus(String orderStatus, Pageable page) {
		String JPQL = "select m from RemittanceView m where m.id.orderStatus = :status";
		@SuppressWarnings("unchecked")
		List<RemittanceView> list = em.createQuery(JPQL)
				.setParameter("status", orderStatus)
				.setFirstResult(page.getPageNumber() - 1)
				.setMaxResults(page.getPageSize())
				.getResultList();
		return list;
	}

	@Override
	public List<RemittanceView> findByMatchStatus(String matchStatus, Pageable page) {
		String JPQL = "select rv from RemittanceView rv where rv.id.matchStatus = :status";
		@SuppressWarnings("unchecked")
		List<RemittanceView> list = em.createQuery(JPQL)
				.setParameter("status", matchStatus)
				.setFirstResult(page.getPageNumber() - 1)
				.setMaxResults(page.getPageSize())
				.getResultList();
		return list;
	}

	@Override
	public List<RemittanceView> findByClient(String client, Pageable page) {
		String JPQL = "select rv from RemittanceView rv where m.id.client = :client";
		@SuppressWarnings("unchecked")
		List<RemittanceView> list = em.createQuery(JPQL)
				.setParameter("client", client)
				.setFirstResult(page.getPageNumber() - 1)
				.setMaxResults(page.getPageSize())
				.getResultList();
		return list;
	}

	@Override
	public List<RemittanceView> findByPaymentProcessor(String paymentProcessor, Pageable page) {
		String JPQL = "select rv from RemittanceView rv where m.id.paymentProcessor = :paymentProcessor";
		@SuppressWarnings("unchecked")
		List<RemittanceView> list = em.createQuery(JPQL)
				.setParameter("paymentProcessor", paymentProcessor)
				.setFirstResult(page.getPageNumber() - 1)
				.setMaxResults(page.getPageSize())
				.getResultList();
		return list;
	}

	@Override
	public String findRemittanceBankReference(String bankReferenceId) {
		String JPQL = "select count(qfr.bankRef) from QxmaFtRemittance qfr where qfr.bankRef = :bankReferenceNo";
		Long count = (Long) em.createQuery(JPQL)
												  .setParameter("bankReferenceNo", bankReferenceId)
												  .getSingleResult();
		
		//Bank Reference already exist in the Remittance Table
		//This should not be inserted.
		if (count.longValue() != 0) {
			return bankReferenceId;
		}
		return null;
	}

}
