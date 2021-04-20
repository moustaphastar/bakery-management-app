package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ProductAttribute", schema = "public", catalog = "bakery")
public class ProductAttribute implements java.io.Serializable {

	private int id;
	private Product product;
	private ProductProperty productProperty;
	private Date insertedAt;
	private boolean active;

	public ProductAttribute() {
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
	@JoinColumn(name = "ProductId", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductPropertyId", nullable = false)
	public ProductProperty getProductProperty() {
		return this.productProperty;
	}

	public void setProductProperty(ProductProperty productProperty) {
		this.productProperty = productProperty;
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

}
