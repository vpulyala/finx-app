package com.osi.finx.model;
// Generated 09 7, 18 3:23:59 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * QxmaFtEventStatus generated by hbm2java
 */
@Entity
@Table(name = "qxma_ft_event_status", catalog = "finx_db")
public class QxmaFtEventStatus implements java.io.Serializable {

	private String code;
	private String name;
	private Set<QxmaFtProductEvent> qxmaFtProductEvents = new HashSet<QxmaFtProductEvent>(0);

	public QxmaFtEventStatus() {
	}

	public QxmaFtEventStatus(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public QxmaFtEventStatus(String code, String name, Set<QxmaFtProductEvent> qxmaFtProductEvents) {
		this.code = code;
		this.name = name;
		this.qxmaFtProductEvents = qxmaFtProductEvents;
	}

	@Id

	@Column(name = "code", unique = true, nullable = false, length = 30)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaFtEventStatus")
	public Set<QxmaFtProductEvent> getQxmaFtProductEvents() {
		return this.qxmaFtProductEvents;
	}

	public void setQxmaFtProductEvents(Set<QxmaFtProductEvent> qxmaFtProductEvents) {
		this.qxmaFtProductEvents = qxmaFtProductEvents;
	}

}
