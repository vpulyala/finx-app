package com.osi.finx.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.osi.finx.dto.DisallowedRevenueDTO;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;

@Component
public interface DisallowedRevenueDAO {
   
	/**
     * Used to get the Disallowed Revenue Information
     * 
     */
	public List<Object[]> viewDisallowedRevenueDetails(String status,String startDate,String endDate) throws OsiFinderException;
    
	/**
     * Used to update the Disallowed Revenue status
     * 
     */
	public void saveAllowedOrDisallowedRevenue(List<DisallowedRevenueDTO> disallowedRevDTOList) throws OsiTransactionException;
	
	
	/**
     * Used to generate Allowed Revenue group id
     * 
     */
	public void generateAllowedRevGroup(List<DisallowedRevenueDTO> allowedRevDTOList) throws OsiTransactionException;
	

}