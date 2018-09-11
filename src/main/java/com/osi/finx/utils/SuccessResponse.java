package com.osi.finx.utils;


public class SuccessResponse {

	/**
	 * 
	 */
	
	private int httpStatus;
	private String message;
	
	public SuccessResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
}
