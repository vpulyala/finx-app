package com.osi.finx.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osi.finx.constants.OsiConstants.GENERIC_ERROR_CODES;
import com.osi.finx.dao.OsiGenericDAO;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaPaymentMethod;
import com.osi.finx.service.PaymentMethodService;


public class PaymentMethodServiceImpl implements PaymentMethodService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentMethodServiceImpl.class);  
    
	@Autowired  
    private OsiGenericDAO osiGenericDAO;
	
    /**
     * 
     */
    public PaymentMethodServiceImpl() {
        super();    
    }

	@Override
	@Transactional
	public QxmaPaymentMethod createOrUpdatePaymentMethod(QxmaPaymentMethod paymentMethod) throws OsiTransactionException{
		
		LOGGER.debug("PaymentMethodServiceImpl :: createOrUpdatePaymentMethod :: START");
		try {
			osiGenericDAO.saveOrUpdate(paymentMethod);
		} catch (OsiTransactionException e) {
			LOGGER.error("PaymentMethodServiceImpl :: createOrUpdatePaymentMethod :: ERROR ", e);
			throw new OsiTransactionException("ERR_0005", GENERIC_ERROR_CODES.ERR_0005);
		}
		LOGGER.debug("PaymentMethodServiceImpl :: createOrUpdatePaymentMethod :: END");
		return paymentMethod;
	}


	@Override
	@Transactional
	public void deletePaymentMethod(Integer pmId) throws OsiFinderException{
		LOGGER.debug("PaymentMethodServiceImpl :: deletePaymentMethod :: START");
		try {
			osiGenericDAO.deleteById(pmId, QxmaPaymentMethod.class);
		} catch (Exception e) {
			LOGGER.error("PaymentMethodServiceImpl :: deletePaymentMethod :: ERROR ", e);
			throw new OsiFinderException("ERR_0005", GENERIC_ERROR_CODES.ERR_0005);
		}
		LOGGER.debug("PaymentMethodServiceImpl :: deletePaymentMethod :: END");
	}
    
	
	@Override
	public List<QxmaPaymentMethod> getAllPaymentMethods() throws OsiFinderException {
			
			LOGGER.debug("PaymentMethodServiceImpl :: getAllPaymentMethods :: START");
			List<QxmaPaymentMethod> paymentMethodList = null;
			try {
				paymentMethodList = osiGenericDAO.findAll(QxmaPaymentMethod.class);
			} 
			catch (Exception e) {
				LOGGER.error("PaymentMethodServiceImpl :: getAllPaymentMethods :: ERROR ", e);
				throw new OsiFinderException("ERR_0006", GENERIC_ERROR_CODES.ERR_0006);
			}
			LOGGER.debug("PaymentMethodServiceImpl :: getAllPaymentMethods :: END");
			return paymentMethodList;
		}
}