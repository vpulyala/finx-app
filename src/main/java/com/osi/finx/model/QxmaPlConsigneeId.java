package com.osi.finx.model;
// Generated 08 14, 18 5:23:14 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QxmaPlConsigneeId generated by hbm2java
 */
@Embeddable
public class QxmaPlConsigneeId implements java.io.Serializable {

	private long consigneeId;
	private String payloadId;

	public QxmaPlConsigneeId() {
	}

	public QxmaPlConsigneeId(long consigneeId, String payloadId) {
		this.consigneeId = consigneeId;
		this.payloadId = payloadId;
	}

	@Column(name = "consignee_id", nullable = false)
	public long getConsigneeId() {
		return this.consigneeId;
	}

	public void setConsigneeId(long consigneeId) {
		this.consigneeId = consigneeId;
	}

	@Column(name = "payload_id", nullable = false, length = 15)
	public String getPayloadId() {
		return this.payloadId;
	}

	public void setPayloadId(String payloadId) {
		this.payloadId = payloadId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof QxmaPlConsigneeId))
			return false;
		QxmaPlConsigneeId castOther = (QxmaPlConsigneeId) other;

		return (this.getConsigneeId() == castOther.getConsigneeId())
				&& ((this.getPayloadId() == castOther.getPayloadId()) || (this.getPayloadId() != null
						&& castOther.getPayloadId() != null && this.getPayloadId().equals(castOther.getPayloadId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getConsigneeId();
		result = 37 * result + (getPayloadId() == null ? 0 : this.getPayloadId().hashCode());
		return result;
	}

}
