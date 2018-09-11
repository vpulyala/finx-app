package com.osi.finx.model;
// Generated 08 16, 18 6:39:07 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QxmaPlAddressId generated by hbm2java
 */
@Embeddable
public class QxmaPlAddressId implements java.io.Serializable {

	private long daId;
	private String payloadId;
	private int adrTypeId;

	public QxmaPlAddressId() {
	}

	public QxmaPlAddressId(long daId, String payloadId, int adrTypeId) {
		this.daId = daId;
		this.payloadId = payloadId;
		this.adrTypeId = adrTypeId;
	}

	@Column(name = "da_id", nullable = false)
	public long getDaId() {
		return this.daId;
	}

	public void setDaId(long daId) {
		this.daId = daId;
	}

	@Column(name = "payload_id", nullable = false, length = 15)
	public String getPayloadId() {
		return this.payloadId;
	}

	public void setPayloadId(String payloadId) {
		this.payloadId = payloadId;
	}

	@Column(name = "adr_type_id", nullable = false)
	public int getAdrTypeId() {
		return this.adrTypeId;
	}

	public void setAdrTypeId(int adrTypeId) {
		this.adrTypeId = adrTypeId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof QxmaPlAddressId))
			return false;
		QxmaPlAddressId castOther = (QxmaPlAddressId) other;

		return (this.getDaId() == castOther.getDaId())
				&& ((this.getPayloadId() == castOther.getPayloadId()) || (this.getPayloadId() != null
						&& castOther.getPayloadId() != null && this.getPayloadId().equals(castOther.getPayloadId())))
				&& (this.getAdrTypeId() == castOther.getAdrTypeId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getDaId();
		result = 37 * result + (getPayloadId() == null ? 0 : this.getPayloadId().hashCode());
		result = 37 * result + this.getAdrTypeId();
		return result;
	}

}
