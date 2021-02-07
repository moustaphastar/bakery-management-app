package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ShipmentRouteIndex", schema = "dbo", catalog = "onlineaccounting")
public class ShipmentRouteIndex implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LocationId", nullable = false)
    private CustomerAddress customerAddress;

    @Column(name = "LocationId", nullable = false, updatable = false, insertable = false)
    private int customerAddressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentRouteId", nullable = false)
    private ShipmentRoute shipmentRoute;

    @Column(name = "ShipmentRouteId", nullable = false, updatable = false, insertable = false)
    private int shipmentRouteId;

    @Column(name = "IndexInRoute", nullable = false)
    private short indexInRoute;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    public ShipmentRouteIndex() {
    }

}
