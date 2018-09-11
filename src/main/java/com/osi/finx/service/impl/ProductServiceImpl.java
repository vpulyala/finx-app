package com.osi.finx.service.impl;


import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.osi.finx.constants.OsiConstants.GENERIC_ERROR_CODES;
import com.osi.finx.dao.OsiGenericDAO;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaProduct;
import com.osi.finx.service.ProductService;


public class ProductServiceImpl implements ProductService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);  
    
	@Autowired  
    private OsiGenericDAO osiGenericDAO;
	
    /**
     * 
     */
    public ProductServiceImpl() {
        super();    
    }

	@Override
	@Transactional
	public QxmaProduct createOrUpdateProduct(QxmaProduct product) throws OsiTransactionException{
		
		LOGGER.debug("ProductServiceImpl :: createOrUpdateProduct :: START");
		try {
			osiGenericDAO.saveOrUpdate(product);
		} catch (OsiTransactionException e) {
			LOGGER.error("ProductServiceImpl :: createOrUpdateProduct :: ERROR ", e);
			throw new OsiTransactionException("ERR_0005", GENERIC_ERROR_CODES.ERR_0005);
		}
		LOGGER.debug("ProductServiceImpl :: createOrUpdateProduct :: END");
		return product;
	}


	@Override
	@Transactional
	public void deleteProduct(Integer pId) throws OsiFinderException{
		LOGGER.debug("ProductServiceImpl :: deleteProduct :: START");
		try {
			osiGenericDAO.deleteById(pId, QxmaProduct.class);
		} catch (Exception e) {
			LOGGER.error("ProductServiceImpl :: deleteProduct :: ERROR ", e);
			throw new OsiFinderException("ERR_0005", GENERIC_ERROR_CODES.ERR_0005);
		}
		LOGGER.debug("ProductServiceImpl :: deleteProduct :: END");
	}
    
	
	@Override
	public List<QxmaProduct> getAllProducts() throws OsiFinderException {
			
			LOGGER.debug("ProductServiceImpl :: getAllProducts :: START");
			List<QxmaProduct> productList = null;
			try {
				productList = osiGenericDAO.findAll(QxmaProduct.class);
			} 
			catch (Exception e) {
				LOGGER.error("ProductServiceImpl :: getAllProducts :: ERROR ", e);
				throw new OsiFinderException("ERR_0006", GENERIC_ERROR_CODES.ERR_0006);
			}
			LOGGER.debug("ProductServiceImpl :: getAllProducts :: END");
			return productList;
		}
}