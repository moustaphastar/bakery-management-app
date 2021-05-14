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
@EqualsAndHashCode(exclude = {"addresses"})
@Entity
@Table(schema = "public")
public class District implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link City} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cityId", nullable = false)
    private City city;

    /***
     * Foreign key to parent {@link City} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private int cityId;

    /***
     * Name of district.
     */
    @Column(nullable = false)
    private String name;

    /***
     * Name of sub district, township.
     */
    @Column(nullable = false)
    private String subDistrictName;

    /***
     * Name of neighborhood or village.
     */
    @Column(nullable = false)
    private String neighborhoodName;

    /***
     * Postal code.
     */
    @Column(nullable = false)
    private String postalCode;

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
     * Set of child {@link Address} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
    private Set<Address> addresses = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public District() {
    }

}
