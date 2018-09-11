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
import com.osi.finx.service.FeesService;
import com.osi.finx.utils.SuccessResponse;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FeesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FeesController.class);

	 
	 @Autowired
	 FeesService feesService;
	 
	 /**
	  * This exposed service is for create fees 
	  * 
	  */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(path = "/createFees")
	 public ResponseEntity<SuccessResponse> createFees(@RequestBody QxmaDropoffRates fees){
		 LOGGER.debug("FeesController :: createFees :: START");
		 SuccessResponse successResponse = null;
		 	try {
				feesService.createOrUpdateFees(fees);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
		  catch (OsiTransactionException e) {
			 LOGGER.error("FeesController :: createFees :: ERROR ", e);
			 new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
		 }

		 LOGGER.debug("FeesController :: createFees :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	 
	 /**
	  * This exposed service is for update fees 
	  * 
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(path = "/updateFees")
	 public ResponseEntity<SuccessResponse> updateFees(@RequestBody QxmaDropoffRates fees){
		 LOGGER.debug("FeesController :: updateFees :: START");
		 SuccessResponse successResponse = null;
		 	try {
				feesService.createOrUpdateFees(fees);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
		  catch (OsiTransactionException e) {
			 LOGGER.error("FeesController :: updateFees :: ERROR ", e);
			 new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
	
		 }

		 LOGGER.debug("FeesController :: updateFees :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	 
	 /**
	  * This exposed service is for Delete fees 
	  * 
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(path = "/deleteFees/{fId}")
	 public ResponseEntity<SuccessResponse> deleteFees(@PathVariable("fId") Integer fId){
		 LOGGER.debug("FeesController :: deleteFees :: START");
		 SuccessResponse successResponse = null;
		 	try {
				feesService.deleteFees(fId);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
		  catch (OsiFinderException e) {
			 LOGGER.error("FeesController :: deleteFees :: ERROR ", e);
			 new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
		 }

		 LOGGER.debug("FeesController :: deleteFees :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	 	
	 /**
	  * This exposed service is to get all fees details 
	  * 
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/getAllFees")
	 public ResponseEntity<List<QxmaDropoffRates>> getAllFees(){
		 LOGGER.debug("FeesController :: getAllFees :: START");
		 List<QxmaDropoffRates> dropoffFees = null;
		 	try {
		 		dropoffFees = feesService.getAllFees();
			} 
		 	 catch (OsiFinderException e) {
				 LOGGER.error("FeesController :: getAllFees :: ERROR ", e);
	 	 		 return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_FOUND);
			 }

		 LOGGER.debug("FeesController :: getAllFees :: END");
		 return new ResponseEntity<List<QxmaDropoffRates>>(dropoffFees, HttpStatus.OK);
	 }
}