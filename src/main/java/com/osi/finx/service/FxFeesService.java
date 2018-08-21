package com.osi.finx.service;

import java.util.List;

import com.osi.finx.model.QxmaDropoffRates;

public interface FxFeesService {
    
    /**
     * Save fees details
     */
	public QxmaDropoffRates saveOrUpdate(QxmaDropoffRates fees);
	
	/**
     * Delete fees details
     */
	public QxmaDropoffRates delete(QxmaDropoffRates fees);
	
	/**
     * Get fees details
     */
	public List<QxmaDropoffRates> getAllFees();
   	
}