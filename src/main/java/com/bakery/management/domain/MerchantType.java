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
@Table(name = "MerchantType", schema = "public")
public class MerchantType implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Merchant type definition.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /***
     * Date and time of first persisting with an offset.
     */
    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link ProductCategory} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchantType")
    private Set<ProductCategory> productCategories = new HashSet<>(0);

    /***
     * Set of child {@link Merchant} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchantType")
    private Set<Merchant> merchants = new HashSet<>(0);

    /***
     * Set of child {@link ProductProperty} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchantType")
    private Set<ProductProperty> productProperties = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public MerchantType() {
    }

}
