package com.osi.finx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.finx.constants.OsiConstants;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaDropoffRates;
import com.osi.finx.model.QxmaPaymentMethod;
import com.osi.finx.service.PaymentMethodService;
import com.osi.finx.utils.SuccessResponse;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentMethodController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentMethodController.class);

	 
	 @Autowired
	 PaymentMethodService paymentMethodService;
	 
	 /**
	  * This exposed service is for create Payment Method 
	  * 
	  */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(path = "/createPaymentMethod")
	 public ResponseEntity<SuccessResponse> createPaymentMethod(@RequestBody QxmaPaymentMethod paymentMethod){
		 LOGGER.debug("PaymentMethodController :: createPaymentMethod :: START");
		 SuccessResponse successResponse = null;
		 	try {
				paymentMethodService.createOrUpdatePaymentMethod(paymentMethod);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
		  catch (OsiTransactionException e) {
			 LOGGER.error("PaymentMethodController :: createPaymentMethod :: ERROR ", e);
			 new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
		 }

		 LOGGER.debug("PaymentMethodController :: createPaymentMethod :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	 
	 /**
	  * This exposed service is for update Payment Method 
	  * 
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(path = "/updatePaymentMethod")
	 public ResponseEntity<SuccessResponse> updatePaymentMethod(@RequestBody QxmaPaymentMethod paymentMethod){
		 LOGGER.debug("PaymentMethodController :: updatePaymentMethod :: START");
		 SuccessResponse successResponse = null;
		 	try {
				paymentMethodService.createOrUpdatePaymentMethod(paymentMethod);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
		  catch (OsiTransactionException e) {
			 LOGGER.error("PaymentMethodController :: updatePaymentMethod :: ERROR ", e);
			 new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
	
		 }

		 LOGGER.debug("PaymentMethodController :: updatePaymentMethod :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	 
	 /**
	  * This exposed service is for delete Payment Method 
	  * 
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(path = "/deletePaymentMethod/{dorId}")
	 public ResponseEntity<SuccessResponse> deletePaymentMethod(@PathVariable("pmId") Integer pmId){
		 LOGGER.debug("PaymentMethodController :: updatePaymentMethod :: START");
		 SuccessResponse successResponse = null;
		 	try {
				paymentMethodService.deletePaymentMethod(pmId);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
		  catch (OsiFinderException e) {
			 LOGGER.error("PaymentMethodController :: updatePaymentMethod :: ERROR ", e);
			 new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
		 }

		 LOGGER.debug("PaymentMethodController :: updatePaymentMethod :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	 	
	 /**
	  * This exposed service is to get all Payment Method details 
	  * 
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/getAllPaymentMethods")
	 public ResponseEntity<List<QxmaPaymentMethod>> getAllPaymentMethods(){
		 LOGGER.debug("PaymentMethodController :: getAllPaymentMethods :: START");
		 List<QxmaPaymentMethod> paymentMethods = null;
		 	try {
		 		paymentMethods = paymentMethodService.getAllPaymentMethods();
			} 
		 	 catch (OsiFinderException e) {
				 LOGGER.error("PaymentMethodController :: getAllPaymentMethods :: ERROR ", e);
	 	 		 return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_FOUND);
			 }

		 LOGGER.debug("PaymentMethodController :: getAllPaymentMethods :: END");
		 return new ResponseEntity<List<QxmaPaymentMethod>>(paymentMethods, HttpStatus.OK);
	 }
}