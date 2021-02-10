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
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ShipmentRoute", schema = "dbo", catalog = "onlineaccounting")
public class ShipmentRoute implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Driver} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VehicleDriverId")
    private Driver driver;

    /***
     * Foreign key to parent {@link Driver} entity Id.
     */
    @Column(name = "VehicleDriverId", nullable = false, updatable = false,
            insertable = false)
    private int vehicleDriverId;

    /***
     * Name of route.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /***
     * Date and time of first persisting with an offset.
     */
    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link Shipment} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipmentRoute")
    private Set<Shipment> shipments = new HashSet<>(0);

    /***
     * Set of child {@link ShipmentRouteIndex} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipmentRoute")
    private Set<ShipmentRouteIndex> shipmentRouteIndexes = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public ShipmentRoute() {
    }

}
