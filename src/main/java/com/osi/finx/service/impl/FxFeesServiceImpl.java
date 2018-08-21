package com.osi.finx.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import com.osi.exception.OsiTransactionException;
import com.osi.finx.dao.OsiGenericDAO;
import com.osi.finx.model.QxmaDropoffRates;
import com.osi.finx.service.FxFeesService;


public class FxFeesServiceImpl implements FxFeesService {
	private static final Logger LOGGER = LoggerFactory.getLogger(FxFeesServiceImpl.class);  
    
	@Autowired  
    private OsiGenericDAO osiGenericDAO;
	
    /**
     * 
     */
    public FxFeesServiceImpl() {
        super();    
    }


    @SuppressWarnings("unchecked")
	@Override
	@Transactional
	public QxmaDropoffRates saveOrUpdate(QxmaDropoffRates fees) {
		
		LOGGER.debug("FxFeesServiceImpl :: saveOrUpdate :: START");
		try {
			osiGenericDAO.saveOrUpdate(fees);
		} catch (DataAccessException | OsiTransactionException e) {
			LOGGER.error("FxFeesServiceImpl :: saveOrUpdate :: ERROR ", e);

		}
		LOGGER.debug("FxFeesServiceImpl :: saveOrUpdate :: END");
		return fees;
	}


	@Override
	public QxmaDropoffRates delete(QxmaDropoffRates fees) {
		// TODO Auto-generated method stub
		return null;
	}
    
	
	@SuppressWarnings("unchecked")
	@Override
	public List<QxmaDropoffRates> getAllFees() {
			
			LOGGER.debug("FxFeesServiceImpl :: viewDisallowedRevenueDetails :: START");
			List<QxmaDropoffRates> feesList = null;
			try {
				feesList = osiGenericDAO.findAll(QxmaDropoffRates.class);
			} catch (DataAccessException e) {
				LOGGER.error("FxFeesServiceImpl :: viewDisallowedRevenueDetails :: ERROR ", e);

			}
			LOGGER.debug("FxFeesServiceImpl :: viewDisallowedRevenueDetails :: END");
			return feesList;
		}
}