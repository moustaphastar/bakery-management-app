package com.cayirozu.db.entity;
// Generated 19 Ara 2020 06:35:03 by Hibernate Tools 5.2.12.Final

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ProductProperty generated by hbm2java
 */
@Entity
@Table(name = "ProductProperty", schema = "dbo", catalog = "onlineaccounting")
public class ProductProperty implements java.io.Serializable {

	private int id;
	private MerchantType merchantType;
	private Serializable name;
	private Date lastUpdate;
	private boolean active;
	private Set<ProductAttribute> productAttributes = new HashSet<>(0);

	public ProductProperty() {
	}

	public ProductProperty(int id, MerchantType merchantType, Serializable name, Date lastUpdate, boolean active) {
		this.id = id;
		this.merchantType = merchantType;
		this.name = name;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public ProductProperty(int id, MerchantType merchantType, Serializable name, Date lastUpdate, boolean active,
			Set<ProductAttribute> productAttributes) {
		this.id = id;
		this.merchantType = merchantType;
		this.name = name;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.productAttributes = productAttributes;
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
	@JoinColumn(name = "MerchantTypeId", nullable = false)
	public MerchantType getMerchantType() {
		return this.merchantType;
	}

	public void setMerchantType(MerchantType merchantType) {
		this.merchantType = merchantType;
	}

	@Column(name = "Name", nullable = false)
	public Serializable getName() {
		return this.name;
	}

	public void setName(Serializable name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdate", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productProperty")
	public Set<ProductAttribute> getProductAttributes() {
		return this.productAttributes;
	}

	public void setProductAttributes(Set<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}

}
