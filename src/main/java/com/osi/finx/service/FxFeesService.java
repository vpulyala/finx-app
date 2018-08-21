package com.osi.finx.service;

import com.osi.finx.model.QxmaDropoffRates;


public interface FxFeesService {
    
    /**
     * Save fees details
     */
	public QxmaDropoffRates saveOrUpdate(QxmaDropoffRates fees);
	public QxmaDropoffRates delete(QxmaDropoffRates fees);
   	
}