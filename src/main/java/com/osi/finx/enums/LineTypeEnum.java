package com.osi.finx.enums;

public enum LineTypeEnum {
	INSURANCE_FEE("10","Insurance Fee"),
	SHIPPING_FEE("20","Shipping Fee"),
	SHIPPING_FEE_LAND("21", "Shipping Fee - Land"),
	SHIPPING_FEE_AIR("22", "Shipping Fee - Air"),
	SHIPPING_FEE_SEA("22", "Shipping Fee - Sea"),
	RETURN_SHIPPING_FEE("30","Return Shipping Fee"),
	TRANSACTION_FEE("40", "Transaction Fee"),
	DROP_OFF_FEE("45","Drop Off Fee"),
	WITHHOLDRING_TAX("50","Withholding Tax"),
	SALES_REFUND("60","Sales Refund"),
	SALES_DISCOUNT("70", "Sales Discount"),
	CLAIM_AMOUNT("80","Claim Amount"),
	SHIPPING_COST("85","Shipping Cost"),
	BANK_FEE("86","Bank Fee"),
	DISPUTE_LOSSES("87","Dispute Losses"),
	SALE_AMOUNT("90","Sale Amount"),
	VAT_AMOUNT("100","Vat Amount"),
	DEFERRED_VAT_AMOUNT("101","Deferred Vat Amount"),
	NET_AMOUNT("110","Net Amount"),
	VAT_EXEMPT_AMOUNT("120","Vat Exempt Amount"),
	ZERO_RATED_AMOUNT("130","Zero Rated Amount"),
	GMV("140","GMV"),
	ITEM_COST("150","Item Cost"),
	PAYMENT_ONLY("160","Payment only");

	private String lineTypeCode;
	private String description;
	
	LineTypeEnum(String code, String description) {
		this.lineTypeCode = code;
		this.description = description;
	}

	public String getLineTypeCode() {
		return lineTypeCode;
	}

	public String getDescription() {
		return description;
	}

}
