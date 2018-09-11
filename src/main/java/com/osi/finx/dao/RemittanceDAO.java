package com.osi.finx.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.model.QxmaFtCharges;
import com.osi.finx.model.QxmaFtRemittance;
import com.osi.finx.model.RemittanceView;


public interface RemittanceDAO {
	
	QxmaFtCharges findChargesByReferenceId(String referernceId) throws OsiFinderException;
	
	QxmaFtRemittance findRemittanceByOrderId(Long orderId) throws OsiFinderException;
	
	List<QxmaFtRemittance> findRemittancesByOrderId(Long orderId) throws OsiFinderException;

	QxmaFtCharges findChargesByOrderId(Long orderId) throws OsiFinderException;
	
	List<RemittanceView> findByOrderStatus(String orderStatus, Pageable page);
	
	List<RemittanceView> findByMatchStatus(String matchStatus, Pageable page);
	
	List<RemittanceView> findByClient(String client, Pageable page);
	
	List<RemittanceView> findByPaymentProcessor(String paymentProcessor, Pageable page);
	
	String findRemittanceBankReference(String bankReferenceId);
	
}
