package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MerchantType", schema = "public")
public class MerchantType implements java.io.Serializable {

	private int id;
	private String name;
	private Date insertedAt;
	private boolean active;
	private Set<ProductCategory> productCategories = new HashSet<>(0);
	private Set<Merchant> merchants = new HashSet<>(0);
	private Set<ProductProperty> productProperties = new HashSet<>(0);

	public MerchantType() {
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "InsertedAt", nullable = false, length = 19)
	public Date getInsertedAt() {
		return this.insertedAt;
	}

	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchantType")
	public Set<ProductCategory> getProductCategories() {
		return this.productCategories;
	}

	public void setProductCategories(Set<ProductCategory> productCategories) {
		this.productCategories = productCategories;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchantType")
	public Set<Merchant> getMerchants() {
		return this.merchants;
	}

	public void setMerchants(Set<Merchant> merchants) {
		this.merchants = merchants;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchantType")
	public Set<ProductProperty> getProductProperties() {
		return this.productProperties;
	}

	public void setProductProperties(Set<ProductProperty> productProperties) {
		this.productProperties = productProperties;
	}

}
