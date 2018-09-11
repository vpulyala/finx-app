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
import com.osi.finx.model.QxmaAccount;
import com.osi.finx.service.AccountService;
import com.osi.finx.utils.SuccessResponse;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccountController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(path = "/createAccount")
	public ResponseEntity<SuccessResponse> createAccount(@RequestBody QxmaAccount acct) {
		LOGGER.debug("AccountController :: createAccount :: START");
		SuccessResponse successResponse = null;
		try {
			accountService.createUpdateAccount(acct);
			successResponse = new SuccessResponse();
			successResponse.setHttpStatus(HttpStatus.OK.value());
			successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
		} catch (OsiTransactionException e) {
			LOGGER.error("AccountController :: createAccount :: ERROR ", e);
			new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
		}

		LOGGER.debug("AccountController :: createAccount :: END");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping(path = "/updateAccount")
	public ResponseEntity<SuccessResponse> updateAccount(@RequestBody QxmaAccount acct) {
		LOGGER.debug("AccountController :: updateAccount :: START");
		SuccessResponse successResponse = null;
		try {
			accountService.createUpdateAccount(acct);
			successResponse = new SuccessResponse();
			successResponse.setHttpStatus(HttpStatus.OK.value());
			successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
		} catch (OsiTransactionException e) {
			LOGGER.error("AccountController :: updateAccount :: ERROR ", e);
			new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);

		}

		LOGGER.debug("AccountController :: updateAccount :: END");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping(path = "/deleteAccount/{code}")
	public ResponseEntity<SuccessResponse> deleteAccount(@PathVariable("code") String code) {
		LOGGER.debug("AccountController :: deleteAccount :: START");
		SuccessResponse successResponse = null;
		try {
			accountService.deleteAccount(code);
			successResponse = new SuccessResponse();
			successResponse.setHttpStatus(HttpStatus.OK.value());
			successResponse.setMessage(OsiConstants.GENERIC_SUCCESS_CODES.OK_0001);
		} catch (OsiFinderException e) {
			LOGGER.error("AccountController :: deleteAccount :: ERROR ", e);
			new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NO_CONTENT);
		}

		LOGGER.debug("AccountController :: deleteAccount :: END");
		return new ResponseEntity<SuccessResponse>(successResponse, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/searchAllAccount")
	public ResponseEntity<List<QxmaAccount>> searchAllAccount() {
		LOGGER.debug("AccountController :: searchAllAccount :: START");
		List<QxmaAccount> acctList = null;
		try {
			acctList = accountService.searchAllAccount();
		} catch (OsiFinderException e) {
			LOGGER.error("AccountController :: searchAllAccount :: ERROR ", e);
			return new ResponseEntity(e.getHTTPResponse().getJSONStringResponse(), HttpStatus.NOT_FOUND);
		}

		LOGGER.debug("AccountController :: searchAllAccount :: END");
		return new ResponseEntity<List<QxmaAccount>>(acctList, HttpStatus.OK);
	}

}
