package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

/***
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ProductCategory", schema = "public")
public class ProductCategory implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link MerchantType} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantTypeId")
    private MerchantType merchantType;

    /***
     * Name of category.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link Product} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productCategory")
    private Set<Product> products = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public ProductCategory() {
    }

}
