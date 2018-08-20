package com.osi.finx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osi.finx.service.QxDisallowedRevenueService;
import com.osi.finx.service.dto.QxDisallowedRevenueDTO;

@RestController
public class QxDisallowedRevenueController {
	private static final Logger LOGGER = LoggerFactory.getLogger(QxDisallowedRevenueController.class);

	 
	 @Autowired
	 QxDisallowedRevenueService disallowedRevenueService;
	 
	 /**
	  * This exposed service is for viewing/searching Disallowed Revenue transactions 
	  * 
	  */
	 @GetMapping(path = "/viewDisallowedRevenue")
	 public ResponseEntity<List<QxDisallowedRevenueDTO>> viewDisallowedRevenueDetails(@RequestParam("allowed") String allowed, @RequestParam("endDate") String endDate){
		 LOGGER.debug("QxDisallowedRevenueController :: viewDisallowedRevenueDetails :: START");
		 List<QxDisallowedRevenueDTO> rmRequests = null;
			try {
				rmRequests = disallowedRevenueService.viewDisallowedRevenueDetails(allowed,endDate);
			} 
		  catch (Exception e) {
			 LOGGER.error("QxDisallowedRevenueController :: viewDisallowedRevenueDetails :: ERROR ", e);
		 }

		 LOGGER.debug("QxDisallowedRevenueController :: viewDisallowedRevenueDetails :: END");
		 return new ResponseEntity<List<QxDisallowedRevenueDTO>>(rmRequests, HttpStatus.OK);
	 }
	 		 
}