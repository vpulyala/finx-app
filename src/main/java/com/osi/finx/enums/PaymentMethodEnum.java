package com.osi.finx.enums;

public enum PaymentMethodEnum {
	CASH("10", "CASH"),
	CREDIT_OR_DEBIT_CARD("20", "CREDITCARD/DEBITCARD"),
	DRAGONPAY("30", "DRAGONPAY"),
	PREPAYMENT("40", "PREPAYMENT"),
	REVOLVING_FUND("50", "REVOLVING FUND"),
	NON_CASH("60", "NON CASH"),
	PAYPAL("70", "PAYPAL");
	
	private String code;
	private String methodName;
	
	PaymentMethodEnum(String code, String name) {
		this.code = code;
		this.methodName= name;
	}

	public String getCode() {
		return code;
	}

	public String getMethodName() {
		return methodName;
	}
}
