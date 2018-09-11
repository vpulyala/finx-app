package com.osi.finx.exception;

public class FinXTransactionException extends Exception {

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
	
	public FinXTransactionException() {
		super();
	}
	
	public FinXTransactionException(String errorCode, String systemMessage) {
		super("ERROR: " + systemMessage);
		this.errorCode = errorCode;
		this.systemMessage = systemMessage;
	}
	
	public FinXTransactionException(String errorCode, Throwable throwable) {
		super(errorCode, throwable);
	}
	
	public FinXTransactionException(String errorCode, String systemMessage, Throwable throwable) {
		super();
		this.errorCode = errorCode;
		this.systemMessage = systemMessage;
		this.throwable = throwable;
	}
	
	public FinXTransactionException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}

	public FinXTransactionException(Throwable throwable) {
		super(throwable);
		this.throwable = throwable;
	}
}
