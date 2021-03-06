package com.osi.finx.model;
// Generated 08 16, 18 6:39:07 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QxmaAddressType generated by hbm2java
 */
@Entity
@Table(name = "qxma_account", catalog = "finx_db")
public class QxmaAccount implements java.io.Serializable {

	private String code;
	private String name;

	public QxmaAccount() {
	}

	public QxmaAccount(String code, String name) {
		this.code = code;
		this.name = name;
	}

	@Id
	@Column(name = "code", unique = true, nullable = false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
