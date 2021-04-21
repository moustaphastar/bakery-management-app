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

/***
 * Domain model class to hold address data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Address", schema = "public")
public class Address implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link District} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DistrictId", nullable = false)
    private District district;

    /***
     * Foreign key to parent {@link District} entity Id.
     */
    @Column(name = "DistrictId", updatable = false, insertable = false)
    private int districtId;

    /***
     * Line to hold street level information.
     */
    @Column(name = "AddressLine1", nullable = false)
    private String addressLine1;

    /***
     * Line to hold building and door numbers.
     */
    @Column(name = "AddressLine2", nullable = false)
    private String addressLine2;

    /***
     * Latitude and Longitude.
     */
    @Column(name = "SpatialLocation")
    private byte[] spatialLocation;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false)
    private OffsetDateTime lastUpdate;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
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
