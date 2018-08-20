package com.osi.finx.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface QxDisallowedRevenueDAO {
   
	/**
     * Used to get the DisallowedRevenue Information
     * 
     */
	public List<Object[]> viewDisallowedRevenueDetails(String status,String startDate,String endDate);
    

}