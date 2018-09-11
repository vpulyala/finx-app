package com.osi.finx.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osi.finx.dto.UserLoginDTO;
import com.osi.finx.service.FinXLoginService;


@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FinXLoginController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FinXLoginController.class);
	
	@Autowired
	private FinXLoginService finxLoginService;
	
	 @PostMapping(path = "/account/login")
	 public UserLoginDTO searchTransaction(@Valid @RequestBody UserLoginDTO userDto ){
		 LOGGER.debug("FinXLoginController :: login :: START");
		 try {
			 userDto = finxLoginService.login(userDto);
		 } catch(Exception rte){
			 //return rte.getHTTPResponse().getJSONStringResponse();
		 }

		 LOGGER.debug("FinXLoginController :: login :: END");
		 return userDto;
	 }	
	 
	 @PostMapping(path = "/account/changePassword/{userId}/{newPassword}")
	 public ResponseEntity<Integer> changePassword(@PathVariable String userId,
			 @PathVariable String newPassword){
		 int result = 0;
		 
		 try{
			 result = finxLoginService.changePassword(userId, newPassword);
			 if(result == 0){
				 throw new Exception();
			 }
		 }catch(Exception e){
			 return new ResponseEntity<Integer>(result,  HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
		 return new ResponseEntity<Integer>(result,  HttpStatus.OK);
	 }

}
