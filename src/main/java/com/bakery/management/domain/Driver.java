package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "VehicleDriver", schema = "dbo", catalog = "onlineaccounting")
public class Driver implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeId", nullable = false)
    private Employee employee;

    @Column(name = "EmployeeId", nullable = false, updatable = false, insertable = false)
    private UUID employeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VehicleId", nullable = false)
    private Vehicle vehicle;

    @Column(name = "VehicleId", nullable = false, updatable = false, insertable = false)
    private int vehicleId;

    @Column(name = "ValidFrom", nullable = false, length = 19)
    private OffsetDateTime validFrom;

    @Column(name = "ValidTo", length = 19)
    private OffsetDateTime validTo;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private Set<DriverCustomer> driverCustomers = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private Set<ShipmentRoute> shipmentRoutes = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private Set<Shipment> shipments = new HashSet<>(0);

    public Driver() {
    }

}
