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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
public class ProductProperty implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link MerchantCategory} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchantCategoryId", nullable = false)
    private MerchantCategory merchantCategory;

    /***
     * Foreign key to parent {@link MerchantCategory} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private int merchantCategoryId;

    /***
     * Name of product property.
     */
    // todo: what is an attribute? what is a property?
    @Column(nullable = false)
    private String name;

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
     * State of existence in persistence.
     */
    @Column(nullable = false)
    private boolean active;

    /***
     * Set of child {@link ProductAttribute} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productProperty")
    private Set<ProductAttribute> productAttributes = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public ProductProperty() {
    }

}
