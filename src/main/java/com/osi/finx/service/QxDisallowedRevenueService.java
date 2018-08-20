package com.osi.finx.service;

import java.util.List;

import com.osi.finx.service.dto.QxDisallowedRevenueDTO;


public interface QxDisallowedRevenueService {
    
    /**
     * Getting the All OsiRgsTransactions information
     * @return
     */
	public List<QxDisallowedRevenueDTO> viewDisallowedRevenueDetails(String allowed,String endDate);
   	
}