package com.osi.finx.service;

import java.util.List;

import com.osi.finx.service.dto.FxDisallowedRevenueDTO;


public interface FxDisallowedRevenueService {
    
    /**
     * Getting the All Disallowed Revenue information
     */
	public List<FxDisallowedRevenueDTO> viewDisallowedRevenueDetails(String allowed,String endDate);
   	
}