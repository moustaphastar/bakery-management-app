package com.bakery.management.domain;

import com.bakery.management.enums.ShipmentLoadStatus;
import com.bakery.management.enums.converters.ShipmentLoadStatusConverter;
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
@Table(name = "ShipmentLoad", schema = "dbo", catalog = "onlineaccounting")
public class ShipmentLoad implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SaleDetailId", nullable = false)
    // TODO: OrderItem's Id field will be changed to UUID.
    private OrderItem orderItem;

    @Column(name = "SaleDetailId", nullable = false, updatable = false, insertable = false)
    private int orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentId", nullable = false)
    private Shipment shipment;

    @Column(name = "ShipmentId", nullable = false, updatable = false, insertable = false)
    // TODO: Shipment's Id field will be changed to UUID.
    private int shipmentId;

    @Column(name = "DeliveryDate", length = 19)
    private OffsetDateTime deliveryDate;

    @Column(name = "ReturnedQuantity", nullable = false)
    private int returnedQuantity;

    @Convert(converter = ShipmentLoadStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private ShipmentLoadStatus status;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private int active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipmentLoad")
    private Set<DispatchNote> dispatchNotes = new HashSet<>(0);

    public ShipmentLoad() {
    }

}
