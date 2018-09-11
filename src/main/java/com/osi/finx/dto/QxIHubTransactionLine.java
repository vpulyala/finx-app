package com.osi.finx.dto;

import java.io.Serializable;

public class QxIHubTransactionLine implements Serializable {
	
	private String lineTypeCode;
	private String lineTypeDescription;
	private Double netAmount;
	private Double vatAmount;
	private Double grossAmount;
	
	public QxIHubTransactionLine() {
		super();
	}

	public String getLineTypeCode() {
		return lineTypeCode;
	}

	public void setLineTypeCode(String lineTypeCode) {
		this.lineTypeCode = lineTypeCode;
	}

	public String getLineTypeDescription() {
		return lineTypeDescription;
	}

	public void setLineTypeDescription(String lineTypeDescription) {
		this.lineTypeDescription = lineTypeDescription;
	}

	public Double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public Double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

}
