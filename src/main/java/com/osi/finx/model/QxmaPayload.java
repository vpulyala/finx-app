package com.osi.finx.model;
// Generated 08 14, 18 5:23:14 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * QxmaPayload generated by hbm2java
 */
@Entity
@Table(name = "qxma_payload", catalog = "finx_db")
public class QxmaPayload implements java.io.Serializable {

	private String payloadId;
	private String type;
	private Character consignor;
	private String currency;
	private Character fees;
	private Double grandTotal;
	private String ipAddress;
	private Character metadata;
	private Character parcel;
	private Long parentId;
	private Character payment;
	private String referenceId;
	private String service;
	private String shipment;
	private String status;
	private Date statusUpdatedAt;
	private Character tat;
	private Byte isDisallowed;
	private Set<QxmaPlConsignee> qxmaPlConsignees = new HashSet<QxmaPlConsignee>(0);
	private Set<QxmaPlItem> qxmaPlItems = new HashSet<QxmaPlItem>(0);
	private Set<QxmaPlEvent> qxmaPlEvents = new HashSet<QxmaPlEvent>(0);
	private Set<QxmaPlBreakdown> qxmaPlBreakdowns = new HashSet<QxmaPlBreakdown>(0);
	private Set<QxmaPlAddress> qxmaPlAddresses = new HashSet<QxmaPlAddress>(0);

	public QxmaPayload() {
	}

	public QxmaPayload(String payloadId) {
		this.payloadId = payloadId;
	}

	public QxmaPayload(String payloadId, String type, Character consignor, String currency, Character fees,
			Double grandTotal, String ipAddress, Character metadata, Character parcel, Long parentId, Character payment,
			String referenceId, String service, String shipment, String status, Date statusUpdatedAt, Character tat,
			Byte isDisallowed, Set<QxmaPlConsignee> qxmaPlConsignees, Set<QxmaPlItem> qxmaPlItems,
			Set<QxmaPlEvent> qxmaPlEvents, Set<QxmaPlBreakdown> qxmaPlBreakdowns, Set<QxmaPlAddress> qxmaPlAddresses) {
		this.payloadId = payloadId;
		this.type = type;
		this.consignor = consignor;
		this.currency = currency;
		this.fees = fees;
		this.grandTotal = grandTotal;
		this.ipAddress = ipAddress;
		this.metadata = metadata;
		this.parcel = parcel;
		this.parentId = parentId;
		this.payment = payment;
		this.referenceId = referenceId;
		this.service = service;
		this.shipment = shipment;
		this.status = status;
		this.statusUpdatedAt = statusUpdatedAt;
		this.tat = tat;
		this.isDisallowed = isDisallowed;
		this.qxmaPlConsignees = qxmaPlConsignees;
		this.qxmaPlItems = qxmaPlItems;
		this.qxmaPlEvents = qxmaPlEvents;
		this.qxmaPlBreakdowns = qxmaPlBreakdowns;
		this.qxmaPlAddresses = qxmaPlAddresses;
	}

	@Id

	@Column(name = "payload_id", unique = true, nullable = false, length = 15)
	public String getPayloadId() {
		return this.payloadId;
	}

	public void setPayloadId(String payloadId) {
		this.payloadId = payloadId;
	}

	@Column(name = "type", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "consignor", length = 0)
	public Character getConsignor() {
		return this.consignor;
	}

	public void setConsignor(Character consignor) {
		this.consignor = consignor;
	}

	@Column(name = "currency", length = 3)
	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "fees", length = 0)
	public Character getFees() {
		return this.fees;
	}

	public void setFees(Character fees) {
		this.fees = fees;
	}

	@Column(name = "grand_total", precision = 22, scale = 0)
	public Double getGrandTotal() {
		return this.grandTotal;
	}

	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}

	@Column(name = "ip_address", length = 15)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name = "metadata", length = 0)
	public Character getMetadata() {
		return this.metadata;
	}

	public void setMetadata(Character metadata) {
		this.metadata = metadata;
	}

	@Column(name = "parcel", length = 0)
	public Character getParcel() {
		return this.parcel;
	}

	public void setParcel(Character parcel) {
		this.parcel = parcel;
	}

	@Column(name = "parent_id")
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "payment", length = 0)
	public Character getPayment() {
		return this.payment;
	}

	public void setPayment(Character payment) {
		this.payment = payment;
	}

	@Column(name = "reference_id", length = 50)
	public String getReferenceId() {
		return this.referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	@Column(name = "service", length = 50)
	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Column(name = "shipment", length = 50)
	public String getShipment() {
		return this.shipment;
	}

	public void setShipment(String shipment) {
		this.shipment = shipment;
	}

	@Column(name = "status", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "status_updated_at", length = 19)
	public Date getStatusUpdatedAt() {
		return this.statusUpdatedAt;
	}

	public void setStatusUpdatedAt(Date statusUpdatedAt) {
		this.statusUpdatedAt = statusUpdatedAt;
	}

	@Column(name = "tat", length = 0)
	public Character getTat() {
		return this.tat;
	}

	public void setTat(Character tat) {
		this.tat = tat;
	}

	@Column(name = "is_disallowed")
	public Byte getIsDisallowed() {
		return this.isDisallowed;
	}

	public void setIsDisallowed(Byte isDisallowed) {
		this.isDisallowed = isDisallowed;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaPayload")
	public Set<QxmaPlConsignee> getQxmaPlConsignees() {
		return this.qxmaPlConsignees;
	}

	public void setQxmaPlConsignees(Set<QxmaPlConsignee> qxmaPlConsignees) {
		this.qxmaPlConsignees = qxmaPlConsignees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaPayload")
	public Set<QxmaPlItem> getQxmaPlItems() {
		return this.qxmaPlItems;
	}

	public void setQxmaPlItems(Set<QxmaPlItem> qxmaPlItems) {
		this.qxmaPlItems = qxmaPlItems;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaPayload")
	public Set<QxmaPlEvent> getQxmaPlEvents() {
		return this.qxmaPlEvents;
	}

	public void setQxmaPlEvents(Set<QxmaPlEvent> qxmaPlEvents) {
		this.qxmaPlEvents = qxmaPlEvents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaPayload")
	public Set<QxmaPlBreakdown> getQxmaPlBreakdowns() {
		return this.qxmaPlBreakdowns;
	}

	public void setQxmaPlBreakdowns(Set<QxmaPlBreakdown> qxmaPlBreakdowns) {
		this.qxmaPlBreakdowns = qxmaPlBreakdowns;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaPayload")
	public Set<QxmaPlAddress> getQxmaPlAddresses() {
		return this.qxmaPlAddresses;
	}

	public void setQxmaPlAddresses(Set<QxmaPlAddress> qxmaPlAddresses) {
		this.qxmaPlAddresses = qxmaPlAddresses;
	}

}