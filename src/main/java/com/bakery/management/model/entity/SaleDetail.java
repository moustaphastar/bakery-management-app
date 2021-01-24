package com.bakery.management.model.entity;
// Generated 19 Ara 2020 06:35:03 by Hibernate Tools 5.2.12.Final

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SaleDetail generated by hbm2java
 */
@Entity
@Table(name = "SaleDetail", schema = "dbo", catalog = "onlineaccounting")
public class SaleDetail implements java.io.Serializable {

	private int id;
	private Product product;
	private Sale sale;
	private String carrierTrackingNumber;
	private int quantity;
	private BigDecimal unitPrice;
	private BigDecimal lineTotal;
	private BigDecimal taxAmount;
	private BigDecimal totalDue;
	private char shippingDayPart;
	private Date lastUpdate;
	private char status;
	private boolean active;
	private Set<ShipmentLoad> shipmentLoads = new HashSet<>(0);

	public SaleDetail() {
	}

	public SaleDetail(int id, Product product, Sale sale, int quantity, BigDecimal unitPrice, BigDecimal lineTotal,
			BigDecimal taxAmount, BigDecimal totalDue, char shippingDayPart, Date lastUpdate, char status,
			boolean active) {
		this.id = id;
		this.product = product;
		this.sale = sale;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.lineTotal = lineTotal;
		this.taxAmount = taxAmount;
		this.totalDue = totalDue;
		this.shippingDayPart = shippingDayPart;
		this.lastUpdate = lastUpdate;
		this.status = status;
		this.active = active;
	}

	public SaleDetail(int id, Product product, Sale sale, String carrierTrackingNumber, int quantity,
			BigDecimal unitPrice, BigDecimal lineTotal, BigDecimal taxAmount, BigDecimal totalDue, char shippingDayPart,
			Date lastUpdate, char status, boolean active, Set<ShipmentLoad> shipmentLoads) {
		this.id = id;
		this.product = product;
		this.sale = sale;
		this.carrierTrackingNumber = carrierTrackingNumber;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.lineTotal = lineTotal;
		this.taxAmount = taxAmount;
		this.totalDue = totalDue;
		this.shippingDayPart = shippingDayPart;
		this.lastUpdate = lastUpdate;
		this.status = status;
		this.active = active;
		this.shipmentLoads = shipmentLoads;
	}

	@Id

	@Column(name = "Id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductId", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SaleId", nullable = false)
	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	@Column(name = "CarrierTrackingNumber")
	public String getCarrierTrackingNumber() {
		return this.carrierTrackingNumber;
	}

	public void setCarrierTrackingNumber(String carrierTrackingNumber) {
		this.carrierTrackingNumber = carrierTrackingNumber;
	}

	@Column(name = "Quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "UnitPrice", nullable = false, precision = 9)
	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "LineTotal", nullable = false, precision = 9)
	public BigDecimal getLineTotal() {
		return this.lineTotal;
	}

	public void setLineTotal(BigDecimal lineTotal) {
		this.lineTotal = lineTotal;
	}

	@Column(name = "TaxAmount", nullable = false, precision = 9)
	public BigDecimal getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	@Column(name = "TotalDue", nullable = false, precision = 9)
	public BigDecimal getTotalDue() {
		return this.totalDue;
	}

	public void setTotalDue(BigDecimal totalDue) {
		this.totalDue = totalDue;
	}

	@Column(name = "ShippingDayPart", nullable = false, length = 1)
	public char getShippingDayPart() {
		return this.shippingDayPart;
	}

	public void setShippingDayPart(char shippingDayPart) {
		this.shippingDayPart = shippingDayPart;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdate", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "Status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "saleDetail")
	public Set<ShipmentLoad> getShipmentLoads() {
		return this.shipmentLoads;
	}

	public void setShipmentLoads(Set<ShipmentLoad> shipmentLoads) {
		this.shipmentLoads = shipmentLoads;
	}

}