package com.osi.finx.model;
// Generated 08 14, 18 5:23:14 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * QxmaFtPartyType generated by hbm2java
 */
@Entity
@Table(name = "qxma_ft_party_type", catalog = "finx_db")
public class QxmaFtPartyType implements java.io.Serializable {

	private Long ptId;
	private String partyType;
	private Set<QxmaFtParties> qxmaFtPartieses = new HashSet<QxmaFtParties>(0);

	public QxmaFtPartyType() {
	}

	public QxmaFtPartyType(String partyType, Set<QxmaFtParties> qxmaFtPartieses) {
		this.partyType = partyType;
		this.qxmaFtPartieses = qxmaFtPartieses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "pt_id", unique = true, nullable = false)
	public Long getPtId() {
		return this.ptId;
	}

	public void setPtId(Long ptId) {
		this.ptId = ptId;
	}

	@Column(name = "party_type", length = 50)
	public String getPartyType() {
		return this.partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaFtPartyType")
	public Set<QxmaFtParties> getQxmaFtPartieses() {
		return this.qxmaFtPartieses;
	}

	public void setQxmaFtPartieses(Set<QxmaFtParties> qxmaFtPartieses) {
		this.qxmaFtPartieses = qxmaFtPartieses;
	}

}