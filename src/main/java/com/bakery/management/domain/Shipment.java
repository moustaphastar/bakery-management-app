package com.bakery.management.domain;

import com.bakery.management.enums.ShipmentStatus;
import com.bakery.management.enums.converters.ShipmentStatusConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;
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
@Table(schema = "public")
public class Shipment implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Driver} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId", nullable = false)
    private Driver driver;

    /***
     * Foreign key to parent {@link Driver} entity Id.
     */
    @Column(nullable = false, updatable = false, insertable = false)
    private int driverId;

    /***
     * Starting date and time of shipment.
     */
    @Column(length = 8)
    private OffsetDateTime timeOfStart;

    /***
     * Ending date and time of shipment.
     */
    @Column(length = 8)
    private OffsetDateTime timeOfEnd;

    /***
     * Odometer starting number.
     */
    @Column(nullable = false)
    private int odometerStart;

    /***
     * Odometer ending number.
     */
    @Column(nullable = true)
    private int odometerEnd;

    /***
     * State of shipment from {@link ShipmentStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = ShipmentStatusConverter.class)
    @Column(nullable = false, length = 1)
    private ShipmentStatus status;

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
     * State of existence in persistence.
     */
    @Column(nullable = false)
    private boolean active;

    /***
     * Class constructor.
     */
    public Shipment() {
    }

}
