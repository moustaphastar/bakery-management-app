package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ProductProperty", schema = "public", catalog = "bakery")
public class ProductProperty implements java.io.Serializable {

	private int id;
	private MerchantType merchantType;
	private String name;
	private Date lastUpdate;
	private boolean active;
	private Set<ProductAttribute> productAttributes = new HashSet<>(0);

	public ProductProperty() {
	}

	public ProductProperty(int id, MerchantType merchantType, String name, Date lastUpdate, boolean active) {
		this.id = id;
		this.merchantType = merchantType;
		this.name = name;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public ProductProperty(int id, MerchantType merchantType, String name, Date lastUpdate, boolean active,
			Set<ProductAttribute> productAttributes) {
		this.id = id;
		this.merchantType = merchantType;
		this.name = name;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.productAttributes = productAttributes;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MerchantTypeId", nullable = false)
	public MerchantType getMerchantType() {
		return this.merchantType;
	}

	public void setMerchantType(MerchantType merchantType) {
		this.merchantType = merchantType;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
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
