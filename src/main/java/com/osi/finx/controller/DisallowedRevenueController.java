package com.osi.finx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.osi.finx.constants.OsiConstants;
import com.osi.finx.dto.DisallowedRevenueDTO;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.service.DisallowedRevenueService;
import com.osi.finx.utils.SuccessResponse;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DisallowedRevenueController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DisallowedRevenueController.class);

	 
	 @Autowired
	 DisallowedRevenueService disallowedRevenueService;
	 
	 /**
	  * This exposed service is for viewing/searching Disallowed Revenue transactions 
	  * 
	  */
     @SuppressWarnings({ "unchecked", "rawtypes" })
	 @GetMapping(path = "/viewDisallowedRevenue")
	 public ResponseEntity<List<DisallowedRevenueDTO>> viewDisallowedRevenueDetails(@RequestParam("allowed") String allowed, @RequestParam("endDate") String endDate){
		 LOGGER.debug("DisallowedRevenueController :: viewDisallowedRevenueDetails :: START");
		 List<DisallowedRevenueDTO> disallowedRevenues = null;
			try {
				disallowedRevenues = disallowedRevenueService.viewDisallowedRevenueDetails(allowed,endDate);
			} 
		  catch (OsiFinderException e) {
			 LOGGER.error("DisallowedRevenueController :: viewDisallowedRevenueDetails :: ERROR ", e);
 	 		 return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_FOUND);
		 }

		 LOGGER.debug("DisallowedRevenueController :: viewDisallowedRevenueDetails :: END");
		 return new ResponseEntity<List<DisallowedRevenueDTO>>(disallowedRevenues, HttpStatus.OK);
	 }
	 
	 /**
	  * This exposed service is to Save Disallowed Revenue transactions
	  * 
	  */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/saveAllowedRevenue")
	 public ResponseEntity<SuccessResponse> saveAllowedRevenue(@RequestBody List<DisallowedRevenueDTO> allowedRevenueDTOList){
		 LOGGER.debug("DisallowedRevenueController :: saveAllowedRevenue :: START");
		 SuccessResponse successResponse = null;
			try {
				
				disallowedRevenueService.saveAllowedRevenue(allowedRevenueDTOList);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
			catch (OsiFinderException e) {
				 LOGGER.error("DisallowedRevenueController :: saveAllowedRevenue :: ERROR ", e);
	 	 		 return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_FOUND);
			 }
		  catch (OsiTransactionException e) {
			 LOGGER.error("DisallowedRevenueController :: saveAllowedRevenue :: ERROR ", e);
 	 		 return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_MODIFIED);
		 }

		 LOGGER.debug("DisallowedRevenueController :: saveAllowedRevenue :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	
	 /**
	  * This exposed service is to Upload Disallowed Revenue transactions from Excel file
	  * 
	  */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/uploadDisallowedRevenue")
		public ResponseEntity<SuccessResponse> uploadDisallowedRevenue(@RequestParam("file") MultipartFile file) {
		    LOGGER.debug("DisallowedRevenueController :: uploadDisallowedRevenue :: START");
		    SuccessResponse successResponse = null;
			try {
				//File convFile= DisallowedTransUtil.convert(file.get);
				disallowedRevenueService.processDisallowedRevenue(file);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage("File uploaded successfully.");
				
			} catch (OsiTransactionException e) {
				 LOGGER.error("DisallowedRevenueController :: uploadDisallowedRevenue :: ERROR ", e);
	 	 		 return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_MODIFIED);
			 }
			LOGGER.debug("DisallowedRevenueController :: uploadDisallowedRevenue :: END");
			return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
		}
	 
	 /**
	  * This exposed service is to Generate Group Id for Allowed Revenue transactions
	  * 
	  */
	 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping(path = "/generateAllowedRevGroup")
	 public ResponseEntity<SuccessResponse> generateAllowedRevenueGroup(@RequestBody List<DisallowedRevenueDTO> allowedRevenueDTOList){
		 LOGGER.debug("DisallowedRevenueController :: generateAllowedRevenueGroup :: START");
		 SuccessResponse successResponse = null;
			try {
				
				disallowedRevenueService.generateAllowedRevGroup(allowedRevenueDTOList);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
			catch (OsiFinderException e) {
				 LOGGER.error("DisallowedRevenueController :: generateAllowedRevenueGroup :: ERROR ", e);
	 	 		 return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_FOUND);
			 }
		  catch (OsiTransactionException e) {
			 LOGGER.error("DisallowedRevenueController :: generateAllowedRevenueGroup :: ERROR ", e);
 	 		 return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_MODIFIED);
		 }

		 LOGGER.debug("DisallowedRevenueController :: generateAllowedRevenueGroup :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
}