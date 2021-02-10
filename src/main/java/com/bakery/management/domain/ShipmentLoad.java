package com.bakery.management.domain;

import com.bakery.management.enums.ShipmentLoadStatus;
import com.bakery.management.enums.converters.ShipmentLoadStatusConverter;
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
@Table(name = "ShipmentLoad", schema = "dbo", catalog = "onlineaccounting")
public class ShipmentLoad implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link OrderItem} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SaleDetailId", nullable = false)
    // todo: OrderItem's Id field will be changed to UUID.
    private OrderItem orderItem;

    /***
     * Foreign key to parent {@link OrderItem} entity Id.
     */
    @Column(name = "SaleDetailId", nullable = false, updatable = false,
            insertable = false)
    private int orderItemId;

    /***
     * Parent {@link Shipment} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentId", nullable = false)
    private Shipment shipment;

    /***
     * Foreign key to parent {@link Shipment} entity Id.
     */
    @Column(name = "ShipmentId", nullable = false, updatable = false,
            insertable = false)
    // todo: Shipment's Id field will be changed to UUID.
    private int shipmentId;

    /***
     * Date and time with offset the order item dropped to target address.
     */
    @Column(name = "DeliveryDate", length = 19)
    private OffsetDateTime deliveryDate;

    /***
     * Quantity that is not accepted by target.
     */
    @Column(name = "ReturnedQuantity", nullable = false)
    private int returnedQuantity;

    /***
     * State of load (order item) from {@link ShipmentLoadStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = ShipmentLoadStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private ShipmentLoadStatus status;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private int active;

    /***
     * Set of child {@link DispatchNote} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipmentLoad")
    private Set<DispatchNote> dispatchNotes = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public ShipmentLoad() {
    }

}
