package com.osi.exception;

public class FinXException extends Exception {

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
	
	public FinXException() {
		super();
	}
	
	public FinXException(String errorCode, String systemMessage) {
		super("ERROR: " + systemMessage);
		this.errorCode = errorCode;
		this.systemMessage = systemMessage;
	}
	
	public FinXException(String errorCode, Throwable throwable) {
		super(errorCode, throwable);
	}
	
	public FinXException(String errorCode, String systemMessage, Throwable throwable) {
		super();
		this.errorCode = errorCode;
		this.systemMessage = systemMessage;
		this.throwable = throwable;
	}
	
	public FinXException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	public FinXException(Throwable throwable) {
		super(throwable);
		this.throwable = throwable;
	}
}
