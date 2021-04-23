package com.bakery.management.domain;

import com.bakery.management.enums.ShipmentStatus;
import com.bakery.management.enums.converters.ShipmentStatusConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
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
@EqualsAndHashCode
@Entity
@Table(name = "Shipment", schema = "public")
public class Shipment implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link ShipmentRoute} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentRouteId")
    private ShipmentRoute shipmentRoute;

    /***
     * Parent {@link Driver} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CarrierId", nullable = false)
    private Driver driver;

    /***
     * Date of shipment.
     */
    @Column(name = "Date", nullable = false, length = 10)
    private LocalDate date;

    /***
     * Starting time of shipment.
     */
    @Column(name = "TimeStart", length = 8)
    private LocalTime timeStart;

    /***
     * Ending time of shipment.
     */
    @Column(name = "TimeEnd", length = 8)
    private LocalDate timeEnd;

    /***
     * Odometer starting number.
     */
    @Column(name = "OdometerStart")
    private int odometerStart;

    /***
     * Odometer ending number.
     */
    @Column(name = "OdometerEnd")
    private int odometerEnd;

    /***
     * State of shipment from {@link ShipmentStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = ShipmentStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private ShipmentStatus status;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(name = "InsertDate", nullable = false)
    private OffsetDateTime insertedDate;

    /***
     * Application user id who committed the insert.
     * Corresponds to an authorized employee id.
     */
    @Column(name = "InsertedBy", nullable = false)
    private UUID insertedBy;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false)
    private OffsetDateTime lastUpdate;

    /***
     * Application user id who committed the last update.
     * Corresponds to an authorized employee id.
     */
    @Column(name = "LastUpdatedBy", nullable = false)
    private UUID lastUpdatedBy;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link ShipmentLoad} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment")
    private Set<ShipmentLoad> shipmentLoads = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Shipment() {
    }

}
