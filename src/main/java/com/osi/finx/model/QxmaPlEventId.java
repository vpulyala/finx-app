package com.osi.finx.model;
// Generated 08 16, 18 6:39:07 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QxmaPlEventId generated by hbm2java
 */
@Embeddable
public class QxmaPlEventId implements java.io.Serializable {

	private long plEventId;
	private String payloadId;

	public QxmaPlEventId() {
	}

	public QxmaPlEventId(long plEventId, String payloadId) {
		this.plEventId = plEventId;
		this.payloadId = payloadId;
	}

	@Column(name = "pl_event_id", nullable = false)
	public long getPlEventId() {
		return this.plEventId;
	}

	public void setPlEventId(long plEventId) {
		this.plEventId = plEventId;
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
		if (!(other instanceof QxmaPlEventId))
			return false;
		QxmaPlEventId castOther = (QxmaPlEventId) other;

		return (this.getPlEventId() == castOther.getPlEventId())
				&& ((this.getPayloadId() == castOther.getPayloadId()) || (this.getPayloadId() != null
						&& castOther.getPayloadId() != null && this.getPayloadId().equals(castOther.getPayloadId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getPlEventId();
		result = 37 * result + (getPayloadId() == null ? 0 : this.getPayloadId().hashCode());
		return result;
	}

}
