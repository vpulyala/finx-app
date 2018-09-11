package com.osi.finx.enums;

public enum CustomerTypeEnum {
	
	MERCHANT(10, "MERCHANT"),
	CUSTOMER(20, "CUSTOMER"),
	SHIPPER(30, "SHIPPER"),
	AGENCY(40, "AGENCY"),
	THIRD_PARTY_LOGISTICS(50, "3PL"),
	OWN_HUB(60, "OWN HUB"),
	RIDER_PARTNER(70, "RIDER PARTNER");
	
	private int code;
	private String name;
	
	CustomerTypeEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
