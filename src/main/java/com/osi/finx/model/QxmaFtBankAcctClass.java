package com.osi.finx.model;
// Generated 08 14, 18 5:23:14 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * QxmaFtBankAcctClass generated by hbm2java
 */
@Entity
@Table(name = "qxma_ft_bank_acct_class", catalog = "finx_db")
public class QxmaFtBankAcctClass implements java.io.Serializable {

	private int baId;
	private String code;
	private String description;
	private Set<QxmaFtBank> qxmaFtBanks = new HashSet<QxmaFtBank>(0);

	public QxmaFtBankAcctClass() {
	}

	public QxmaFtBankAcctClass(int baId) {
		this.baId = baId;
	}

	public QxmaFtBankAcctClass(int baId, String code, String description, Set<QxmaFtBank> qxmaFtBanks) {
		this.baId = baId;
		this.code = code;
		this.description = description;
		this.qxmaFtBanks = qxmaFtBanks;
	}

	@Id

	@Column(name = "ba_id", unique = true, nullable = false)
	public int getBaId() {
		return this.baId;
	}

	public void setBaId(int baId) {
		this.baId = baId;
	}

	@Column(name = "code", length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaFtBankAcctClass")
	public Set<QxmaFtBank> getQxmaFtBanks() {
		return this.qxmaFtBanks;
	}

	public void setQxmaFtBanks(Set<QxmaFtBank> qxmaFtBanks) {
		this.qxmaFtBanks = qxmaFtBanks;
	}

}