package com.osi.finx.enums;

public enum ServiceProviderEnum {
	
	THIRD_PARTY_LOGISTICS(10, "3PL"),
	QUADX(20, "QUADX");
	
	private int providerCode;
	private String name;
	
	ServiceProviderEnum(int providerCode, String name) {
		this.providerCode = providerCode;
		this.name = name;
	}

	public int getProviderCode() {
		return providerCode;
	}

	public String getName() {
		return name;
	}
}
