package com.osi.finx.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.osi.finx.dto.DisallowedRevenueDTO;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;


public interface DisallowedRevenueService {
    
    /**
     * Getting the All Disallowed Revenue information
     */
	public List<DisallowedRevenueDTO> viewDisallowedRevenueDetails(String allowed,String endDate) throws OsiFinderException;
	
	/**
     * Updates the Disallowed Revenue status
     */	
	public void saveAllowedRevenue(List<DisallowedRevenueDTO> disallowedRevDTOList) throws OsiFinderException, OsiTransactionException;
	
	/**
     * Uploads the Disallowed Revenue transactions
     */
	public void processDisallowedRevenue(MultipartFile inputStream) throws OsiTransactionException;

	/**
     * Generates the Allowed Revenue Group
     */	
	public void generateAllowedRevGroup(List<DisallowedRevenueDTO> allowedRevDTOList) throws OsiFinderException, OsiTransactionException;

	
   	
}