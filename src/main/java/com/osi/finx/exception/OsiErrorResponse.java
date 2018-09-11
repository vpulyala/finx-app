package com.osi.finx.exception;

public class OsiErrorResponse {

	private int httpStatus;
	private String errorMessage;
	private String errorCode;
	private String developerMessage;
	
	
	public OsiErrorResponse() {
		super();
	}
	public int getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getDeveloperMessage() {
		return developerMessage;
	}
	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}
	
	public String getJSONStringResponse(){
		StringBuilder osiErrorResponse = new StringBuilder();
		osiErrorResponse.append("{");
		osiErrorResponse.append("\"httpStatus:\":\""+httpStatus+"\",");
		osiErrorResponse.append("\"errorCode:\":\""+errorCode+"\",");
		osiErrorResponse.append("\"errorMessage:\":\""+errorMessage+"\"");
		osiErrorResponse.append("}");
		return osiErrorResponse.toString();
	}
	
}
