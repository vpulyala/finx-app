package com.osi.finx.enums;

public enum TransactionTypeEnum {
	REVENUE(10, "REVENUE"),
	NON_REVENUE(20, "NON REVENUE"),
	DISALLOWED_REVENUE(30, "DISALLOWED REVENUE"),
	CLAIMS(40, "CLAIMS"),
	REVENUE_RETURN(50, "REVENUE - RETURN"),
	NON_REVENUE_RETURN(60, "NON REVENUE - RETURN"),
	DEFERRED_REVENUE(70, "DEFERRED REVENUE"),
	DISPUTE(80, "DISPUTE");
	
	private int code;
	private String name;
	
	TransactionTypeEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
