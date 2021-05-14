package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/***
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(schema = "public")
public class Product implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false, length = 36)
    private UUID id;

    /***
     * Parent {@link Merchant} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchantId", nullable = false)
    private Merchant merchant;

    /***
     * Foreign key to parent {@link Merchant} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private UUID merchantId;

    /***
     * Parent {@link ProductCategory} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productCategoryId", nullable = false)
    private ProductCategory productCategory;

    /***
     * Foreign key to parent {@link ProductCategory} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private int productCategoryId;

    /***
     * Name of product.
     */
    @Column(nullable = false)
    private String name;

    /***
     * Description of product.
     */
    @Column(nullable = false)
    private String description;

    /***
     * Weight of product.
     */
    @Column(nullable = false)
    private int weight;

    /***
     * Standard cost of product.
     */
    @Column(nullable = false, precision = 9)
    private BigDecimal standardCost;

    /***
     * Listing price of product.
     */
    @Column(nullable = false, precision = 9)
    private BigDecimal listPrice;

    /***
     * Tax rate that is applied to product.
     */
    // todo: Percentage? State tax? City tax? Federal tax?
    @Column(nullable = false, precision = 9)
    private BigDecimal taxRate;

    /***
     * State of product availability for sale.
     */
    @Column(nullable = false)
    private boolean onSale;

    /***
     * Url address to fetch product image.
     */
    @Column(nullable = false)
    private String imageUrl;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
    @Generated(value = GenerationTime.INSERT)
    private OffsetDateTime insertedDate;

    /***
     * Application user id who committed the insert.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID insertedBy;

    /***
     * Date and time of last update with an offset.
     */
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    /***
     * Application user id who committed the last update.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID lastUpdatedBy;

    /***
     * Date after when the product is not produced any more.
     */
    @Column(length = 19)
    private OffsetDateTime discontinuedOn;

    /***
     * State of existence in persistence.
     */
    @Column(nullable = false)
    private boolean active;

    /***
     * Set of child {@link ProductAttribute} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<ProductAttribute> productAttributes = new HashSet<>(0);

    /***
     * Set of child {@link OrderItem} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet<>(0);

    /***
     * Set of child {@link CustomerDiscount} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private Set<CustomerDiscount> customerDiscounts = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Product() {
    }

}
