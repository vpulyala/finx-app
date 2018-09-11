package com.osi.finx.model;
// Generated 09 7, 18 3:23:59 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * QxmaProductLineType generated by hbm2java
 */
@Entity
@Table(name = "qxma_product_line_type", catalog = "finx_db")
public class QxmaProductLineType implements java.io.Serializable {

	private Integer pltId;
	private QxmaLineType qxmaLineType;
	private QxmaProduct qxmaProduct;
	private Set<QxmaFtProductEvent> qxmaFtProductEvents = new HashSet<QxmaFtProductEvent>(0);
	private Set<QxmaOmsProductEvent> qxmaOmsProductEvents = new HashSet<QxmaOmsProductEvent>(0);

	public QxmaProductLineType() {
	}

	public QxmaProductLineType(QxmaLineType qxmaLineType, QxmaProduct qxmaProduct) {
		this.qxmaLineType = qxmaLineType;
		this.qxmaProduct = qxmaProduct;
	}

	public QxmaProductLineType(QxmaLineType qxmaLineType, QxmaProduct qxmaProduct,
			Set<QxmaFtProductEvent> qxmaFtProductEvents, Set<QxmaOmsProductEvent> qxmaOmsProductEvents) {
		this.qxmaLineType = qxmaLineType;
		this.qxmaProduct = qxmaProduct;
		this.qxmaFtProductEvents = qxmaFtProductEvents;
		this.qxmaOmsProductEvents = qxmaOmsProductEvents;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "plt_id", unique = true, nullable = false)
	public Integer getPltId() {
		return this.pltId;
	}

	public void setPltId(Integer pltId) {
		this.pltId = pltId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "line_type_code", nullable = false)
	public QxmaLineType getQxmaLineType() {
		return this.qxmaLineType;
	}

	public void setQxmaLineType(QxmaLineType qxmaLineType) {
		this.qxmaLineType = qxmaLineType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_code", nullable = false)
	public QxmaProduct getQxmaProduct() {
		return this.qxmaProduct;
	}

	public void setQxmaProduct(QxmaProduct qxmaProduct) {
		this.qxmaProduct = qxmaProduct;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaProductLineType")
	public Set<QxmaFtProductEvent> getQxmaFtProductEvents() {
		return this.qxmaFtProductEvents;
	}

	public void setQxmaFtProductEvents(Set<QxmaFtProductEvent> qxmaFtProductEvents) {
		this.qxmaFtProductEvents = qxmaFtProductEvents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "qxmaProductLineType")
	public Set<QxmaOmsProductEvent> getQxmaOmsProductEvents() {
		return this.qxmaOmsProductEvents;
	}

	public void setQxmaOmsProductEvents(Set<QxmaOmsProductEvent> qxmaOmsProductEvents) {
		this.qxmaOmsProductEvents = qxmaOmsProductEvents;
	}

}
