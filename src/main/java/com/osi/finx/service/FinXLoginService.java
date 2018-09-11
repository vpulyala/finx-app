package com.osi.finx.service;

import com.osi.finx.dto.UserLoginDTO;

public interface FinXLoginService {

	public UserLoginDTO login(UserLoginDTO userDto);
	public int changePassword(String userId, String newPassword);
	
}
