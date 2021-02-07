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
@Table(name = "ShipmentRoute", schema = "dbo", catalog = "onlineaccounting")
public class ShipmentRoute implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VehicleDriverId")
    private Driver driver;

    @Column(name = "VehicleDriverId", nullable = false, updatable = false, insertable = false)
    private int vehicleDriverId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipmentRoute")
    private Set<Shipment> shipments = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipmentRoute")
    private Set<ShipmentRouteIndex> shipmentRouteIndexes = new HashSet<>(0);

    public ShipmentRoute() {
    }

}
