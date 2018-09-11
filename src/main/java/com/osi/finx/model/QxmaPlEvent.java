package com.osi.finx.model;
// Generated 08 16, 18 6:39:07 PM by Hibernate Tools 5.2.3.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * QxmaPlEvent generated by hbm2java
 */
@Entity
@Table(name = "qxma_pl_event", catalog = "finx_db")
public class QxmaPlEvent implements java.io.Serializable {

	private QxmaPlEventId id;
	private QxmaPayload qxmaPayload;
	private String status;
	private String remarks;
	private String createdBy;
	private Date createdAt;
	private Date statusUpdatedAt;

	public QxmaPlEvent() {
	}

	public QxmaPlEvent(QxmaPlEventId id, QxmaPayload qxmaPayload) {
		this.id = id;
		this.qxmaPayload = qxmaPayload;
	}

	public QxmaPlEvent(QxmaPlEventId id, QxmaPayload qxmaPayload, String status, String remarks, String createdBy,
			Date createdAt, Date statusUpdatedAt) {
		this.id = id;
		this.qxmaPayload = qxmaPayload;
		this.status = status;
		this.remarks = remarks;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.statusUpdatedAt = statusUpdatedAt;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "plEventId", column = @Column(name = "pl_event_id", nullable = false)),
			@AttributeOverride(name = "payloadId", column = @Column(name = "payload_id", nullable = false, length = 15)) })
	public QxmaPlEventId getId() {
		return this.id;
	}

	public void setId(QxmaPlEventId id) {
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

	@Column(name = "status", length = 50)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "remarks", length = 254)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "created_by", length = 50)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "status_updated_at", length = 19)
	public Date getStatusUpdatedAt() {
		return this.statusUpdatedAt;
	}

	public void setStatusUpdatedAt(Date statusUpdatedAt) {
		this.statusUpdatedAt = statusUpdatedAt;
	}

}
