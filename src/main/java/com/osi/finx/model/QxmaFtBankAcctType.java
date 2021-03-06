package com.osi.finx.model;
// Generated 08 16, 18 6:39:07 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * QxmaFtBankAcctType generated by hbm2java
 */
@Entity
@Table(name = "qxma_ft_bank_acct_type", catalog = "finx_db")
public class QxmaFtBankAcctType implements java.io.Serializable {

	private int baType;
	private String code;
	private String description;
	private Set<QxmaFtBank> qxmaFtBanks = new HashSet<QxmaFtBank>(0);

	public QxmaFtBankAcctType() {
	}

	public QxmaFtBankAcctType(int baType) {
		this.baType = baType;
	}

	public QxmaFtBankAcctType(int baType, String code, String description, Set<QxmaFtBank> qxmaFtBanks) {
		this.baType = baType;
		this.code = code;
		this.description = description;
		this.qxmaFtBanks = qxmaFtBanks;
	}

	@Id

	@Column(name = "ba_type", unique = true, nullable = false)
	public int getBaType() {
		return this.baType;
	}

	public void setBaType(int baType) {
		this.baType = baType;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaFtBankAcctType")
	public Set<QxmaFtBank> getQxmaFtBanks() {
		return this.qxmaFtBanks;
	}

	public void setQxmaFtBanks(Set<QxmaFtBank> qxmaFtBanks) {
		this.qxmaFtBanks = qxmaFtBanks;
	}

}
