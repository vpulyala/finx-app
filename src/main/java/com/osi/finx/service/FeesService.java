package com.osi.finx.service;

import java.util.List;

import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaDropoffRates;

public interface FeesService {
    
    /**
     * Save fees details
     */
	public QxmaDropoffRates createOrUpdateFees(QxmaDropoffRates fees) throws OsiTransactionException;
	
	/**
     * Delete fees details
     */
	public void deleteFees(Integer dorId) throws OsiFinderException;
	
	/**
     * Get fees details
     */
	public List<QxmaDropoffRates> getAllFees() throws OsiFinderException;
   	
}