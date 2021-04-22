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
import javax.persistence.Table;
import java.time.OffsetDateTime;

/***
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ShipmentRouteIndex", schema = "public")
public class ShipmentRouteIndex implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link CustomerAddress} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LocationId", nullable = false)
    private CustomerAddress customerAddress;

    /***
     * Foreign key to parent {@link CustomerAddress} entity Id.
     */
    @Column(name = "LocationId", nullable = false, updatable = false,
            insertable = false)
    // todo: Should relate to Address or CustomerAddress?
    private int customerAddressId;

    /***
     * Parent {@link ShipmentRoute} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentRouteId", nullable = false)
    private ShipmentRoute shipmentRoute;

    /***
     * Foreign key to parent {@link ShipmentRoute} entity Id.
     */
    @Column(name = "ShipmentRouteId", nullable = false, updatable = false,
            insertable = false)
    private int shipmentRouteId;

    /***
     * Stop order of the target address in shipment route.
     */
    @Column(name = "IndexInRoute", nullable = false)
    private short indexInRoute;

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
     * Class constructor.
     */
    public ShipmentRouteIndex() {
    }

}
