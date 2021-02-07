package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Product", schema = "dbo", catalog = "onlineaccounting")
public class Product implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    @Column(name = "MerchantId", nullable = false, updatable = false, insertable = false)
    private int merchantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductCategoryId", nullable = false)
    private ProductCategory productCategory;

    @Column(name = "ProductCategoryId", nullable = false, updatable = false, insertable = false)
    private int productCategoryId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Weight", nullable = false)
    private int weight;

    @Column(name = "StandartCost", nullable = false, precision = 9)
    private BigDecimal standardCost;

    @Column(name = "ListPrice", nullable = false, precision = 9)
    private BigDecimal listPrice;

    @Column(name = "TaxRate", nullable = false, precision = 9)
    private BigDecimal taxRate;

    @Column(name = "OnSale", nullable = false)
    private boolean onSale;

    @Column(name = "ImageUrl", nullable = false)
    private String imageUrl;

    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "DiscontinuedOn", length = 19)
    private OffsetDateTime discontinuedOn;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductAttribute> productAttributes = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<CustomerDiscount> customerDiscounts = new HashSet<>(0);

    public Product() {
    }

}
