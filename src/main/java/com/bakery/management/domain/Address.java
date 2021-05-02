package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
 * Domain model class to hold address data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"merchantAddresses",
        "customerAddresses", "employeeAddresses",
        "salesForBillToAddressId", "salesForShipToAddressId"})
@Entity
@Table(schema = "public")
public class Address implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link District} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "districtId", nullable = false)
    private District district;

    /***
     * Foreign key to parent {@link District} entity Id.
     */
    @Column(updatable = false, insertable = false)
    private int districtId;

    /***
     * Line to hold street level information.
     */
    @Column(nullable = false)
    private String addressLine1;

    /***
     * Line to hold building and door numbers.
     */
    @Column(nullable = false)
    private String addressLine2;

    /***
     * Latitude and Longitude.
     */
    // todo: Convert to PostGIS compatible data type.
    @Column(name = "SpatialLocation")
    private byte[] spatialLocation;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
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
     * Set of child {@link MerchantAddress} with one to many relation.
     */
    // todo: Relation type is not consistent.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Set<MerchantAddress> merchantAddresses = new HashSet<>(0);

    /***
     * Set of child {@link CustomerAddress} with one to many relation.
     */
    // todo: Relation type is not consistent.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Set<CustomerAddress> customerAddresses = new HashSet<>(0);

    /***
     * Set of child {@link EmployeeAddress} with one to many relation.
     */
    // todo: Relation type is not consistent.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Set<EmployeeAddress> employeeAddresses = new HashSet<>(0);

    /***
     * Set of child {@link Order} with one to many relation,
     * references as billing address.
     */
    // todo: {@link AddressType#BILLING} produces checkstyle error.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "billToAddressId")
    private Set<Order> salesForBillToAddressId = new HashSet<>(0);

    /***
     * Set of child {@link Order} with one to many relation,
     * references as shipping address.
     */
    // todo: {@link AddressType#SHIPPING} produces checkstyle error.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipToAddressId")
    private Set<Order> salesForShipToAddressId = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Address() {
    }

}
