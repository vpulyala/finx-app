package com.osi.finx.service;

import java.util.List;

import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaProduct;

public interface ProductService {
    
    /**
     * Save product details
     */
	public QxmaProduct createOrUpdateProduct(QxmaProduct product) throws OsiTransactionException;
	
	/**
     * Delete product details
     */
	public void deleteProduct(Integer dorId) throws OsiFinderException;
	
	/**
     * Get product details
     */
	public List<QxmaProduct> getAllProducts() throws OsiFinderException;
   	
}