package com.bakery.management.domain;

import com.bakery.management.enums.ShipmentStatus;
import com.bakery.management.enums.converters.ShipmentStatusConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Shipment", schema = "dbo", catalog = "onlineaccounting")
public class Shipment implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentRouteId")
    private ShipmentRoute shipmentRoute;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CarrierId", nullable = false)
    private Driver driver;

    @Column(name = "Date", nullable = false, length = 10)
    private LocalDate date;

    @Column(name = "TimeStart", length = 8)
    private LocalTime timeStart;

    @Column(name = "TimeEnd", length = 8)
    private LocalDate timeEnd;

    @Column(name = "OdometerStart")
    private int odometerStart;

    @Column(name = "OdometerEnd")
    private int odometerEnd;

    @Convert(converter = ShipmentStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private ShipmentStatus status;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment")
    private Set<ShipmentLoad> shipmentLoads = new HashSet<>(0);

    public Shipment() {
    }

}
