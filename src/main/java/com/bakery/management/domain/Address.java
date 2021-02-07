package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Address", schema = "dbo", catalog = "onlineaccounting")
public class Address implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "DistrictId", nullable = false)
    private District district;

    @Column(name = "DistrictId", updatable = false, insertable = false)
    private int districtId;

    @Column(name = "AddressLine1", nullable = false)
    private String addressLine1;

    @Column(name = "AddressLine2", nullable = false)
    private String addressLine2;

    @Column(name = "SpatialLocation")
    private byte[] spatialLocation;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Set<MerchantAddress> merchantAddresses = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Set<CustomerAddress> customerAddresses = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
    private Set<EmployeeAddress> employeeAddresses = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "billToAddressId")
    private Set<Order> salesForBillToAddressId = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipToAddressId")
    private Set<Order> salesForShipToAddressId = new HashSet<>(0);

    public Address() {
    }

}
