package com.osi.finx.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.osi.finx.exception.FinXTransactionException;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.model.QxmaFtCharges;
import com.osi.finx.model.QxmaFtRemittance;
import com.osi.finx.model.RemittanceView;


public interface RemittanceService {
	
	Page<QxmaFtRemittance> findRemittances(Pageable pageable);
	
	QxmaFtCharges findConsumerOrderIdByReferenceId(String referenceId) throws OsiFinderException;
	
	QxmaFtRemittance findRemittanceByOrderId(Long orderId) throws OsiFinderException;
	
	List<QxmaFtRemittance> findRemittancesByOrderId(Long orderId) throws OsiFinderException;
	
	void createRemittanceTransaction(QxmaFtRemittance remittance) throws OsiFinderException, FinXTransactionException;
	
	List<RemittanceView> findByPaymentProcessor(String processor, Pageable page);
	
	List<RemittanceView> findByClient(String client, Pageable page);
	
	List<RemittanceView> findByMatchStatus(String matchStatus, Pageable page);
	
	List<RemittanceView> findByOrderStatus(String orderStatus, Pageable page);
	
	String findRemittanceBankReference(String bankReferenceId);
}
