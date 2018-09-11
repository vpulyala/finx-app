package com.osi.finx.model;
// Generated 08 16, 18 6:39:07 PM by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * QxmaDropoffRates generated by hbm2java
 */
@Entity
@Table(name = "qxma_dropoff_rates", catalog = "finx_db")
public class QxmaDropoffRates implements java.io.Serializable {

	private Integer dorId;
	private String code;
	private String description;
	private BigDecimal rates;

	public QxmaDropoffRates() {
	}

	public QxmaDropoffRates(String code, String description, BigDecimal rates) {
		this.code = code;
		this.description = description;
		this.rates = rates;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "dor_id", unique = true, nullable = false)
	public Integer getDorId() {
		return this.dorId;
	}

	public void setDorId(Integer dorId) {
		this.dorId = dorId;
	}

	@Column(name = "code", length = 30)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "rates")
	public BigDecimal getRates() {
		return this.rates;
	}

	public void setRates(BigDecimal rates) {
		this.rates = rates;
	}

}
