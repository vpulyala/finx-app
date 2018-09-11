package com.osi.finx.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.finx.constants.OsiConstants;
import com.osi.finx.exception.OsiFinderException;
import com.osi.finx.exception.OsiTransactionException;
import com.osi.finx.model.QxmaProduct;
import com.osi.finx.service.ProductService;
import com.osi.finx.utils.SuccessResponse;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	 
	 @Autowired
	 ProductService productService;
	 
	 /**
	  * This exposed service is for create Product 
	  * 
	  */
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(path = "/createProduct")
	 public ResponseEntity<SuccessResponse> createProduct(@RequestBody QxmaProduct product){
		 LOGGER.debug("ProductController :: createProduct :: START");
		 SuccessResponse successResponse = null;
		 	try {
				productService.createOrUpdateProduct(product);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
		  catch (OsiTransactionException e) {
			 LOGGER.error("ProductController :: createProduct :: ERROR ", e);
			 new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
		 }

		 LOGGER.debug("ProductController :: createProduct :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	 
	 /**
	  * This exposed service is for update Product 
	  * 
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(path = "/updateProduct")
	 public ResponseEntity<SuccessResponse> updateProduct(@RequestBody QxmaProduct product){
		 LOGGER.debug("ProductController :: updateProduct :: START");
		 SuccessResponse successResponse = null;
		 	try {
				productService.createOrUpdateProduct(product);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
		  catch (OsiTransactionException e) {
			 LOGGER.error("ProductController :: updateProduct :: ERROR ", e);
			 new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
	
		 }

		 LOGGER.debug("ProductController :: updateProduct :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	 
	 /**
	  * This exposed service is for delete Product 
	  * 
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(path = "/deleteProduct/{pId}")
	 public ResponseEntity<SuccessResponse> deleteProduct(@PathVariable("pId") Integer pId){
		 LOGGER.debug("ProductController :: updateProduct :: START");
		 SuccessResponse successResponse = null;
		 	try {
				productService.deleteProduct(pId);
				successResponse = new SuccessResponse();
				successResponse.setHttpStatus(HttpStatus.OK.value());
				successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
			} 
		  catch (OsiFinderException e) {
			 LOGGER.error("ProductController :: updateProduct :: ERROR ", e);
			 new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
		 }

		 LOGGER.debug("ProductController :: updateProduct :: END");
		 return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	 }
	 	
	 /**
	  * This exposed service is to get all Product details 
	  * 
	  */
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/getAllProducts")
	 public ResponseEntity<List<QxmaProduct>> getAllProducts(){
		 LOGGER.debug("ProductController :: getAllProducts :: START");
		 List<QxmaProduct> product = null;
		 	try {
		 		product = productService.getAllProducts();
			} 
		 	 catch (OsiFinderException e) {
				 LOGGER.error("ProductController :: getAllProducts :: ERROR ", e);
	 	 		 return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_FOUND);
			 }

		 LOGGER.debug("ProductController :: getAllProducts :: END");
		 return new ResponseEntity<List<QxmaProduct>>(product, HttpStatus.OK);
	 }
}