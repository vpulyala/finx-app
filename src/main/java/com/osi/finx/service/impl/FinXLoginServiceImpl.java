package com.osi.finx.service.impl;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osi.finx.dao.FinXLoginDAO;
import com.osi.finx.dto.UserLoginDTO;
import com.osi.finx.model.QxmaUser;
import com.osi.finx.service.FinXLoginService;

@Service
public class FinXLoginServiceImpl implements FinXLoginService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FinXLoginServiceImpl.class);
	
	@Autowired
	FinXLoginDAO finXLoginDao;

	@Override
	public UserLoginDTO login(UserLoginDTO userDto) {
		LOGGER.debug("FinXLoginServiceImpl :: login :: START");
		
		try{
			
			String username = userDto.getUsername();
			String password = Base64.getEncoder().encodeToString(userDto.getPassword().getBytes("utf-8"));
			QxmaUser user = finXLoginDao.login(username, password);
			
			userDto.setRoleId(user.getQuadxRole().getRoleId());
			userDto.setRoleName(user.getQuadxRole().getRoleName());
			userDto.setFirstName(user.getFirstName());
			userDto.setLastName(user.getLastName());
			userDto.setIsFirstLogin(user.getIsFirstLogin());
			userDto.setUserId(user.getUserId().toString());
			
			if(user == null){
				throw new Exception();
			}
			
		}catch(Exception e){
			LOGGER.error("FinXLoginServiceImpl :: login :: ERROR ", e);
			return null;
		}

		LOGGER.debug("FinXLoginServiceImpl :: login :: END");
		return userDto;
	}

	@Override
	public int changePassword(String userId, String newPassword) {
		LOGGER.debug("FinXLoginServiceImpl :: changePassword :: START");
		int result = 0;
		
		try{
			String password = Base64.getEncoder().encodeToString(newPassword.getBytes("utf-8"));
			result = finXLoginDao.changePassword(userId, password);
		}catch(Exception e){
			result = 0;
			LOGGER.error("FinXLoginServiceImpl :: changePassword :: ERROR ", e);
		}

		LOGGER.debug("FinXLoginServiceImpl :: changePassword :: END");
		return result;
	}

}
