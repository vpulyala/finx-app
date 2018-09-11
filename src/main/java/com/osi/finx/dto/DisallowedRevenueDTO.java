package com.osi.finx.dto;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DisallowedRevenueDTO implements Serializable {

	private String payloadId;
	private String trackingNo;
	private String item;
	private String paymentMethod;
	private Date date;
	private Double shippingFee;
	private Double insurance;
	private Double trxFee;
	private Double returnFee;
	private Double total;
	private int isDisallowed;
	
	public String getPayloadId() {
		return payloadId;
	}
	public void setPayloadId(String payloadId) {
		this.payloadId = payloadId;
	}
	public String getTrackingNo() {
		return trackingNo;
	}
	public void setTrackingNo(String trackingNo) {
		this.trackingNo = trackingNo;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getShippingFee() {
		return shippingFee;
	}
	public void setShippingFee(Double shippingFee) {
		this.shippingFee = shippingFee;
	}
	public Double getInsurance() {
		return insurance;
	}
	public void setInsurance(Double insurance) {
		this.insurance = insurance;
	}
	public Double getTrxFee() {
		return trxFee;
	}
	public void setTrxFee(Double trxFee) {
		this.trxFee = trxFee;
	}
	public Double getReturnFee() {
		return returnFee;
	}
	public void setReturnFee(Double returnFee) {
		this.returnFee = returnFee;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public int getIsDisallowed() {
		return isDisallowed;
	}
	public void setIsDisallowed(int isDisallowed) {
		this.isDisallowed = isDisallowed;
	}
	
}
