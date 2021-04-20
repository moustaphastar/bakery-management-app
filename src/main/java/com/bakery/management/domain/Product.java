package com.bakery.management.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Product", schema = "dbo", catalog = "bakery")
public class Product implements java.io.Serializable {

    private String id;
    private Merchant merchant;
    private ProductCategory productCategory;
    private String name;
    private String description;
    private int weight;
    private BigDecimal standardCost;
    private BigDecimal listPrice;
    private BigDecimal taxRate;
    private boolean onSale;
    private String imageUrl;
    private Date insertedAt;
    private Date lastUpdate;
    private Date discontinuedOn;
    private boolean active;
    private Set<ProductAttribute> productAttributes = new HashSet<>(0);
    private Set<SaleDetail> saleDetails = new HashSet<>(0);
	private Set<CustomerDiscount> customerDiscounts = new HashSet<>(0);

	public Product() {
	}

    public Product(String id, Merchant merchant, ProductCategory productCategory, String name, int weight,
                   BigDecimal standardCost, BigDecimal listPrice, BigDecimal taxRate, boolean onSale, String imageUrl,
                   Date insertedAt, Date lastUpdate, boolean active) {
        this.id = id;
        this.merchant = merchant;
        this.productCategory = productCategory;
        this.name = name;
        this.weight = weight;
        this.standardCost = standardCost;
        this.listPrice = listPrice;
        this.taxRate = taxRate;
        this.onSale = onSale;
        this.imageUrl = imageUrl;
        this.insertedAt = insertedAt;
        this.lastUpdate = lastUpdate;
        this.active = active;
    }

    public Product(String id, Merchant merchant, ProductCategory productCategory, String name,
                   String description, int weight, BigDecimal standardCost, BigDecimal listPrice, BigDecimal taxRate,
                   boolean onSale, String imageUrl, Date insertedAt, Date lastUpdate, Date discontinuedOn,
                   boolean active, Set<ProductAttribute> productAttributes, Set<SaleDetail> saleDetails, Set<CustomerDiscount> customerDiscounts) {
        this.id = id;
        this.merchant = merchant;
        this.productCategory = productCategory;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.standardCost = standardCost;
        this.listPrice = listPrice;
        this.taxRate = taxRate;
        this.onSale = onSale;
        this.imageUrl = imageUrl;
        this.insertedAt = insertedAt;
        this.lastUpdate = lastUpdate;
        this.discontinuedOn = discontinuedOn;
        this.active = active;
        this.productAttributes = productAttributes;
        this.saleDetails = saleDetails;
		this.customerDiscounts = customerDiscounts;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MerchantId", nullable = false)
	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductCategoryId", nullable = false)
	public ProductCategory getProductCategory() {
		return this.productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Weight", nullable = false)
	public int getWeight() {
		return this.weight;
	}

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Column(name = "StandartCost", nullable = false, precision = 9)
    public BigDecimal getStandardCost() {
        return this.standardCost;
    }

    public void setStandardCost(BigDecimal standardCost) {
        this.standardCost = standardCost;
    }

    @Column(name = "ListPrice", nullable = false, precision = 9)
    public BigDecimal getListPrice() {
        return this.listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

	@Column(name = "TaxRate", nullable = false, precision = 9)
	public BigDecimal getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	@Column(name = "OnSale", nullable = false)
	public boolean isOnSale() {
		return this.onSale;
	}

	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}

	@Column(name = "ImageUrl", nullable = false)
	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "InsertedAt", nullable = false, length = 19)
	public Date getInsertedAt() {
		return this.insertedAt;
	}

	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdate", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DiscontinuedOn", length = 19)
	public Date getDiscontinuedOn() {
		return this.discontinuedOn;
	}

	public void setDiscontinuedOn(Date discontinuedOn) {
		this.discontinuedOn = discontinuedOn;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<ProductAttribute> getProductAttributes() {
		return this.productAttributes;
	}

	public void setProductAttributes(Set<ProductAttribute> productAttributes) {
		this.productAttributes = productAttributes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<SaleDetail> getSaleDetails() {
		return this.saleDetails;
	}

	public void setSaleDetails(Set<SaleDetail> saleDetails) {
		this.saleDetails = saleDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public Set<CustomerDiscount> getCustomerDiscounts() {
		return this.customerDiscounts;
	}

	public void setCustomerDiscounts(Set<CustomerDiscount> customerDiscounts) {
		this.customerDiscounts = customerDiscounts;
	}

}
