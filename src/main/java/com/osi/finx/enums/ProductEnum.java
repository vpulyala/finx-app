package com.osi.finx.enums;

public enum ProductEnum {
	
	CHECK_ME_OUT(101, "CHECKMEOUT"),
	XPOST(102, "XPOST"),
	SHOPEE(103, "SHOPEE"),
	SHIPPING_CART(201, "SHIPPING CART");
	
	private int productCode;
	private String productName;
	
	ProductEnum(int productCode, String productName) {
		this.productCode = productCode;
		this.productName = productName;
	}

	public int getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}
}
