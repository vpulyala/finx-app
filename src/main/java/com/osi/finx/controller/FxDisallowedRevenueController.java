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

import com.osi.finx.service.FxDisallowedRevenueService;
import com.osi.finx.service.dto.FxDisallowedRevenueDTO;

@RestController
public class FxDisallowedRevenueController {
	private static final Logger LOGGER = LoggerFactory.getLogger(FxDisallowedRevenueController.class);

	 
	 @Autowired
	 FxDisallowedRevenueService disallowedRevenueService;
	 
	 /**
	  * This exposed service is for viewing/searching Disallowed Revenue transactions 
	  * 
	  */
	 @GetMapping(path = "/viewDisallowedRevenue")
	 public ResponseEntity<List<FxDisallowedRevenueDTO>> viewDisallowedRevenueDetails(@RequestParam("allowed") String allowed, @RequestParam("endDate") String endDate){
		 LOGGER.debug("FxDisallowedRevenueController :: viewDisallowedRevenueDetails :: START");
		 List<FxDisallowedRevenueDTO> disallowedRevenues = null;
			try {
				disallowedRevenues = disallowedRevenueService.viewDisallowedRevenueDetails(allowed,endDate);
			} 
		  catch (Exception e) {
			 LOGGER.error("FxDisallowedRevenueController :: viewDisallowedRevenueDetails :: ERROR ", e);
		 }

		 LOGGER.debug("FxDisallowedRevenueController :: viewDisallowedRevenueDetails :: END");
		 return new ResponseEntity<List<FxDisallowedRevenueDTO>>(disallowedRevenues, HttpStatus.OK);
	 }
	 		 
}