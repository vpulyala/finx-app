package com.osi.finx.exception;

public class OsiFinderException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorCode;
	private String systemMessage;
	private Throwable throwable;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getSystemMessage() {
		return systemMessage;
	}

	public void setSystemMessage(String systemMessage) {
		this.systemMessage = systemMessage;
	}

	public Throwable getThrowable() {
		return throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}

	public OsiFinderException(String errorCode, String systemMessage) {
		super("ERROR: " + systemMessage);
		this.errorCode = errorCode;
		this.systemMessage = systemMessage;
	}
	
	public OsiFinderException(String errorCode) {
		super();
		this.errorCode = errorCode;
	}	

	public OsiFinderException(String errorCode, String systemMessage, Throwable throwable) {
		super();
		this.errorCode = errorCode;
		this.systemMessage = systemMessage;
		this.throwable = throwable;
	}
	
	public OsiErrorResponse getHTTPResponse(){
		OsiErrorResponse httpResponse = new OsiErrorResponse();
		httpResponse.setErrorCode(errorCode);
		httpResponse.setErrorMessage(systemMessage);
		httpResponse.setHttpStatus(500);
		return httpResponse;
	}

}
