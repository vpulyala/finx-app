package com.osi.finx.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osi.finx.constants.OsiConstants.GENERIC_ERROR_CODES;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.dao.OsiGenericDAO;
import com.osi.finx.model.QxmaDropoffRates;
import com.osi.finx.service.FeesService;


public class FeesServiceImpl implements FeesService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FeesServiceImpl.class);  
    
	@Autowired  
    private OsiGenericDAO osiGenericDAO;
	
    /**
     * 
     */
    public FeesServiceImpl() {
        super();    
    }

	@Override
	@Transactional
	public QxmaDropoffRates createOrUpdateFees(QxmaDropoffRates fees) throws OsiTransactionException{
		
		LOGGER.debug("FeesServiceImpl :: createOrUpdateFees :: START");
		try {
			osiGenericDAO.saveOrUpdate(fees);
		} catch (OsiTransactionException e) {
			LOGGER.error("FeesServiceImpl :: createOrUpdateFees :: ERROR ", e);
			throw new OsiTransactionException("ERR_0005", GENERIC_ERROR_CODES.ERR_0005);
		}
		LOGGER.debug("FeesServiceImpl :: createOrUpdateFees :: END");
		return fees;
	}


	@Override
	@Transactional
	public void deleteFees(Integer dorId) throws OsiFinderException{
		LOGGER.debug("FeesServiceImpl :: deleteFees :: START");
		try {
			osiGenericDAO.deleteById(dorId, QxmaDropoffRates.class);
		} catch (Exception e) {
			LOGGER.error("FeesServiceImpl :: deleteFees :: ERROR ", e);
			throw new OsiFinderException("ERR_0005", GENERIC_ERROR_CODES.ERR_0005);
		}
		LOGGER.debug("FeesServiceImpl :: deleteFees :: END");
	}
    
	
	@Override
	public List<QxmaDropoffRates> getAllFees() throws OsiFinderException {
			
			LOGGER.debug("FeesServiceImpl :: getAllFees :: START");
			List<QxmaDropoffRates> feesList = null;
			try {
				feesList = osiGenericDAO.findAll(QxmaDropoffRates.class);
			} 
			catch (Exception e) {
				LOGGER.error("FeesServiceImpl :: getAllFees :: ERROR ", e);
				throw new OsiFinderException("ERR_0006", GENERIC_ERROR_CODES.ERR_0006);
			}
			LOGGER.debug("FeesServiceImpl :: getAllFees :: END");
			return feesList;
		}
}