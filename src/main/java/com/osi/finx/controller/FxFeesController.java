package com.osi.finx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.osi.finx.model.QxmaDropoffRates;
import com.osi.finx.service.FxFeesService;
import com.osi.finx.service.dto.FxDisallowedRevenueDTO;

@RestController
public class FxFeesController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FxDisallowedRevenueController.class);

	 
	 @Autowired
	 FxFeesService feesService;
	 
	 /**
	  * This exposed service is for create fees 
	  * 
	  */
	 @PostMapping(path = "/createFees")
	 public ResponseEntity<QxmaDropoffRates> createFees(@RequestBody QxmaDropoffRates fees){
		 LOGGER.debug("FxFeesController :: createFees :: START");
		 ResponseEntity<QxmaDropoffRates> response = null;
		 	try {
				feesService.saveOrUpdate(fees);
				response = new ResponseEntity<QxmaDropoffRates>(fees, HttpStatus.OK);
			} 
		  catch (Exception e) {
			 LOGGER.error("FxFeesController :: createFees :: ERROR ", e);
		 }

		 LOGGER.debug("FxFeesController :: createFees :: END");
		 return response;
	 }
	 
	 /**
	  * This exposed service is for update fees 
	  * 
	  */
	 @PostMapping(path = "/updateFees")
	 public ResponseEntity<QxmaDropoffRates> updateFees(@RequestBody QxmaDropoffRates fees){
		 LOGGER.debug("FxFeesController :: updateFees :: START");
		 ResponseEntity<QxmaDropoffRates> response = null;
		 	try {
				feesService.saveOrUpdate(fees);
				response = new ResponseEntity<QxmaDropoffRates>(fees, HttpStatus.OK);
			} 
		  catch (Exception e) {
			 LOGGER.error("FxFeesController :: updateFees :: ERROR ", e);
		 }

		 LOGGER.debug("FxFeesController :: updateFees :: END");
		 return response;
	 }
	 
	 /**
	  * This exposed service is for Delete fees 
	  * 
	  */
	 @PostMapping(path = "/deleteFees")
	 public ResponseEntity<QxmaDropoffRates> deleteFees(@RequestBody QxmaDropoffRates fees){
		 LOGGER.debug("FxFeesController :: updateFees :: START");
		 ResponseEntity<QxmaDropoffRates> response = null;
		 	try {
				feesService.delete(fees);
				response = new ResponseEntity<QxmaDropoffRates>(fees, HttpStatus.OK);
			} 
		  catch (Exception e) {
			 LOGGER.error("FxFeesController :: updateFees :: ERROR ", e);
		 }

		 LOGGER.debug("FxFeesController :: updateFees :: END");
		 return response;
	 }
	 	
	 /**
	  * This exposed service is to get all fees details 
	  * 
	  */
	 @GetMapping(path = "/getAllFees")
	 public ResponseEntity<List<QxmaDropoffRates>> getAllFees(){
		 LOGGER.debug("FxFeesController :: getAllFees :: START");
		 List<QxmaDropoffRates> dropoffFees = null;
		 	try {
		 		dropoffFees = feesService.getAllFees();
			} 
		  catch (Exception e) {
			 LOGGER.error("FxFeesController :: getAllFees :: ERROR ", e);
		 }

		 LOGGER.debug("FxFeesController :: getAllFees :: END");
		 return new ResponseEntity<List<QxmaDropoffRates>>(dropoffFees, HttpStatus.OK);
	 }
}