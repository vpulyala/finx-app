package com.osi.finx.service;

import java.util.List;

import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaAccount;

public interface AccountService {

	public QxmaAccount createUpdateAccount(QxmaAccount acct) throws OsiTransactionException;
	
	public void deleteAccount(String code) throws OsiFinderException;
	
	public List<QxmaAccount> searchAllAccount() throws OsiFinderException;
	
}
