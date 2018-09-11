package com.osi.finx.enums;

public enum AccountEnum {
	
	REVOLVING_FUND_CS_03("111003", "Revolving Fund-CS"),
	UNDEPOSITED_COLLECTION("111004", "Undeposited Collection"),
	REVOLVING_FUND_CS_05("111005", "Revolving Fund-SC"),
	CASH_CLEARING_ACCOUNT("113900", "Cash Clearing Account"),
	ACCOUNT_RECEIVABLE("117101", "Accounts Receivable"),
	CLAIMS_RECEIVABLE("117104", "Claims Receivable"),
	MERCHANT_RECEIVABLE("117105", "Merchant Receivable"),
	ASIAPAY_270784950("117107", "Asiapay - 270784950"),
	ASIAPAY_272362648("117108", "Asiapay - 272362648"),
	ADYEN("117109", "Adyen"),
	COD_LBC("117110", "COD-LBC"),
	DRAGONPAY("117111", "Dragonpay"),
	PAYPAL_PH("117115", "Paypal - PH USD-9TBJDBFUL879Q"),
	PAYPAL_SG("117116", "Paypal - SG USD-Z3ZDVQKASALA"),
	UNBILLED_RECEIVABLE("117900", "Unbilled Receivable"),
	INPUT_TAX("119007", "Input Tax"),
	CREDITABLE_WTAX("119008", "Creditable Wtax"),
	DEFERRED_INPUT_TAX("119010","Deferred Input Tax"),
	TRANSACTION_FEE_SHIPPING("400001", "Transaction Fee - Shipping"),
	TRANSACTION_FEE_INSURANCE("400002","Transaction Fee - Insurance"),
	TRANSACTION_FEE_COLLECTION_FEE("400003", "Transaction Fee - Collection Fee"),
	SHIPPING_CART_SHIPPING("400004", "Shipping Cart - Shipping"),
	SHIPPING_CART_INSURANCE("400005", "Shipping Cart - Insurance"),
	SHIPPING_CART_STORAGE("400006", "Shipping Cart - Storage"),
	SALES_REFUND("400007", "Sales Refund"),
	SALES_DISCOUNT("400008", "Sales Discount"),
	TRANSACTION_FEE_DROP_OFF_FEE("400009", "Transaction Fee - Drop off Fee"),
	TRANSACTION_FEE_RETURN_FEE("400010", "Transaction Fee - Return Fee"),
	SHIPPING_CART_SHIPPING_SEA("400011", "Shipping Cart - Shipping-Sea"),
	BANK_FEE("511001", "Bank Fee"),
	SHIPPING_COST_DROP_OFF("511010", "Shipping Cost - Drop Off"),
	COS_CLAIMS("511060", "COS – Claims"),
	COS_CLAIMS_CLEARING_COST("511901", "COS - Claims Clearing Account"),
	COS_DISPUTE_LOSSES("515569", "COS - Dispute Losses"),
	MERCHANT_PAYABLE("211005", "Merchant Payable"),
	MERCHANT_PAYABLE_CLEARING("211900",	"Merchant Payable Clearing"),
	CUSTOMER_DEPOSIT_RF("213003", "Customer Deposit - RF"),
	CUSTOMER_DEPOSIT_CMO("213016", "Customer Deposit - CMO"),
	VAT_PAYABLE("213011", "VAT Payable"),
	OUTPUT_VAT("213012", "Output VAT"),
	DEFERRED_REVENUE("213014", "Deferred Revenue"),
	DONATION_PAYABLE("213017", "Donation Payable"),
	CLAIMS_PAYABLE("211004", "Claims Payable");

	
	private final String account;
	private final String description;
	
	AccountEnum(String account, String description) {
		this.account = account;
		this.description = description;
	}

	public String getAccount() {
		return account;
	}

	public String getDescription() {
		return description;
	}
	
}
