package com.osi.finx.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QxIHubTransaction implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ftTrxId;
	private String orgCode;
	private String leCode;
	private String locationCode;
	/**
	 * Maps to TransactionTypeEnum
	 */
	private String trxType;
	/**
	 * Maps to AccountEnum
	 */
	private String acctType;
	
	private String providerCode;
	/**
	 * Maps to ServiceTypeEnum
	 */
	private String serviceType;
	/**
	 * Maps to ProductEnum
	 */
	private String productCode;
	/**
	 * 
	 */
	private String customer;
	private String customerTypeCode;
	private String customerEmail;
	/**
	 * Maps to Payload.delivery_address
	 */
	private String buyer;
	/**
	 * Get from Payload.trackingNumber or
	 * Remittance.referenceId or
	 * Charge.referenceId
	 * 
	 */
	private String trackingNo;
	/**
	 * Get from Payload.currency
	 */
	private String currencyCode;
	private String claimType;
	private List<QxIHubTransactionLine> qxIHubTransactionLines = new ArrayList<QxIHubTransactionLine>();
	
	public QxIHubTransaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFtTrxId() {
		return ftTrxId;
	}
	public void setFtTrxId(String ftTrxId) {
		this.ftTrxId = ftTrxId;
	}
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getLeCode() {
		return leCode;
	}
	public void setLeCode(String leCode) {
		this.leCode = leCode;
	}
	public String getTrxType() {
		return trxType;
	}
	public void setTrxType(String trxType) {
		this.trxType = trxType;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public String getAcctType() {
		return acctType;
	}
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	public String getProviderCode() {
		return providerCode;
	}
	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomerTypeCode() {
		return customerTypeCode;
	}
	public void setCustomerTypeCode(String customerTypeCode) {
		this.customerTypeCode = customerTypeCode;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public List<QxIHubTransactionLine> getQxIHubTransactionLines() {
		return qxIHubTransactionLines;
	}
	public void setQxIHubTransactionLines(List<QxIHubTransactionLine> qxIHubTransactionLines) {
		this.qxIHubTransactionLines = qxIHubTransactionLines;
	}}
