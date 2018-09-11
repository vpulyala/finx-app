package com.osi.finx.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osi.finx.constants.OsiConstants.GENERIC_ERROR_CODES;
import com.osi.finx.dao.AccountDAO;
import com.osi.finx.dao.OsiGenericDAO;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaAccount;
import com.osi.finx.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
	
	@Autowired  
    private OsiGenericDAO osiGenericDAO;
	
	@Autowired  
	private AccountDAO accountDAO;

	@Override
	@Transactional
	public QxmaAccount createUpdateAccount(QxmaAccount acct) throws OsiTransactionException{
		
		LOGGER.debug("AccountServiceImpl :: createAccount :: START");
		try {
			osiGenericDAO.saveOrUpdate(acct);
		} catch (OsiTransactionException e) {
			LOGGER.error("AccountServiceImpl :: createAccount :: ERROR ", e);
			throw new OsiTransactionException("ERR_0005", GENERIC_ERROR_CODES.ERR_0005);
		}
		LOGGER.debug("AccountServiceImpl :: createAccount :: END");
		return acct;
	}


	@Override
	@Transactional
	public void deleteAccount(String code) throws OsiFinderException{
		LOGGER.debug("AccountServiceImpl :: deleteAccount :: START");
		try {
			accountDAO.deleteAccount(code);
		} catch (Exception e) {
			LOGGER.error("AccountServiceImpl :: deleteAccount :: ERROR ", e);
			throw new OsiFinderException("ERR_0005", GENERIC_ERROR_CODES.ERR_0009);
		}
		LOGGER.debug("AccountServiceImpl :: deleteAccount :: END");
	}
    
	
	@Override
	public List<QxmaAccount> searchAllAccount() throws OsiFinderException {
			
		LOGGER.debug("AccountServiceImpl :: searchAllAccount :: START");
		List<QxmaAccount> acctList = null;
		try {
			acctList = osiGenericDAO.findAll(QxmaAccount.class);
		} 
		catch (Exception e) {
			LOGGER.error("AccountServiceImpl :: searchAllAccount :: ERROR ", e);
			throw new OsiFinderException("ERR_0006", GENERIC_ERROR_CODES.ERR_0006);
		}
		LOGGER.debug("AccountServiceImpl :: searchAllAccount :: END");
		return acctList;
	}
}
