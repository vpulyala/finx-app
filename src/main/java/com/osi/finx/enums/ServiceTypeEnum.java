package com.osi.finx.enums;

public enum ServiceTypeEnum {
	
	LOGISTICS(10, "LOGISTICS"),
	PAYMENT(20, "PAYMENT"),
	BOTH(30, "BOTH");
	
	private int code;
	private String name;
	
	ServiceTypeEnum(int code, String name) {
		this.code = code;
		this.name= name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
