package com.osi.finx.service;

import java.util.List;

import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaPaymentMethod;

public interface PaymentMethodService {
    
    /**
     * Save payment method details
     */
	public QxmaPaymentMethod createOrUpdatePaymentMethod(QxmaPaymentMethod paymentMethod) throws OsiTransactionException;
	
	/**
     * Delete payment method details
     */
	public void deletePaymentMethod(Integer dorId) throws OsiFinderException;
	
	/**
     * Get payment method details
     */
	public List<QxmaPaymentMethod> getAllPaymentMethods() throws OsiFinderException;
   	
}