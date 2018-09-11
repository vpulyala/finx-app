package com.osi.finx.dao;

import com.osi.finx.model.QxmaUser;

public interface FinXLoginDAO {

	public QxmaUser login(String username, String password);
	public int changePassword(String userId, String newPassword);
	
}
