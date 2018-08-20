package com.osi.finx.model;
// Generated 08 14, 18 5:23:14 PM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * QxmaPlBreakdown generated by hbm2java
 */
@Entity
@Table(name = "qxma_pl_breakdown", catalog = "finx_db")
public class QxmaPlBreakdown implements java.io.Serializable {

	private QxmaPlBreakdownId id;
	private QxmaPayload qxmaPayload;
	private BigDecimal subTotal;
	private BigDecimal shipping;
	private BigDecimal tax;
	private BigDecimal fee;
	private BigDecimal insurance;
	private BigDecimal discount;

	public QxmaPlBreakdown() {
	}

	public QxmaPlBreakdown(QxmaPlBreakdownId id, QxmaPayload qxmaPayload) {
		this.id = id;
		this.qxmaPayload = qxmaPayload;
	}

	public QxmaPlBreakdown(QxmaPlBreakdownId id, QxmaPayload qxmaPayload, BigDecimal subTotal, BigDecimal shipping,
			BigDecimal tax, BigDecimal fee, BigDecimal insurance, BigDecimal discount) {
		this.id = id;
		this.qxmaPayload = qxmaPayload;
		this.subTotal = subTotal;
		this.shipping = shipping;
		this.tax = tax;
		this.fee = fee;
		this.insurance = insurance;
		this.discount = discount;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "bdId", column = @Column(name = "bd_id", nullable = false)),
			@AttributeOverride(name = "payloadId", column = @Column(name = "payload_id", nullable = false, length = 15)) })
	public QxmaPlBreakdownId getId() {
		return this.id;
	}

	public void setId(QxmaPlBreakdownId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payload_id", nullable = false, insertable = false, updatable = false)
	public QxmaPayload getQxmaPayload() {
		return this.qxmaPayload;
	}

	public void setQxmaPayload(QxmaPayload qxmaPayload) {
		this.qxmaPayload = qxmaPayload;
	}

	@Column(name = "sub_total")
	public BigDecimal getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	@Column(name = "shipping")
	public BigDecimal getShipping() {
		return this.shipping;
	}

	public void setShipping(BigDecimal shipping) {
		this.shipping = shipping;
	}

	@Column(name = "tax")
	public BigDecimal getTax() {
		return this.tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	@Column(name = "fee")
	public BigDecimal getFee() {
		return this.fee;
	}

	public void setFee(BigDecimal fee) {
		this.fee = fee;
	}

	@Column(name = "insurance")
	public BigDecimal getInsurance() {
		return this.insurance;
	}

	public void setInsurance(BigDecimal insurance) {
		this.insurance = insurance;
	}

	@Column(name = "discount")
	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

}