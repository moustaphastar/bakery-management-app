package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "VehicleDriverCustomer", schema = "dbo", catalog = "onlineaccounting")
public class DriverCustomer implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    @Column(name = "CustomerId", nullable = false, updatable = false, insertable = false)
    private UUID customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DriverId", nullable = false)
    private Driver driver;

    @Column(name = "DriverId", nullable = false, updatable = false, insertable = false)
    private int vehicleDriverId;

    @Column(name = "ValidFrom", nullable = false, length = 19)
    private OffsetDateTime validFrom;

    @Column(name = "ValidTo", length = 19)
    private OffsetDateTime validTo;

    @Column(name = "Active", nullable = false)
    private boolean active;

    public DriverCustomer() {
    }

}
