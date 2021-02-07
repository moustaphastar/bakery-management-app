package com.bakery.management.domain;

import com.bakery.management.enums.OrderItemStatus;
import com.bakery.management.enums.ShipmentPartsOfDay;
import com.bakery.management.enums.converters.OrderItemStatusConverter;
import com.bakery.management.enums.converters.ShipmentPartsOfDayConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "SaleDetail", schema = "dbo", catalog = "onlineaccounting")
public class OrderItem implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    // TODO: Refactor to use long or uuid.
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Column(name = "ProductId", nullable = false, updatable = false, insertable = false)
    private UUID productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SaleId", nullable = false)
    private Order order;

    @Column(name = "SaleId", nullable = false, updatable = false, insertable = false)
    private int orderId;

    @Column(name = "CarrierTrackingNumber")
    private String carrierTrackingNumber;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @Column(name = "UnitPrice", nullable = false, precision = 9)
    private BigDecimal unitPrice;

    @Column(name = "LineTotal", nullable = false, precision = 9)
    private BigDecimal lineTotal;

    @Column(name = "TaxAmount", nullable = false, precision = 9)
    private BigDecimal taxAmount;

    @Column(name = "TotalDue", nullable = false, precision = 9)
    private BigDecimal totalDue;

    @Convert(converter = ShipmentPartsOfDayConverter.class)
    @Column(name = "ShippingDayPart", nullable = false, length = 1)
    private ShipmentPartsOfDay shippingDayPart;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Convert(converter = OrderItemStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private OrderItemStatus status;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItem")
    private Set<ShipmentLoad> shipmentLoads = new HashSet<>(0);

    public OrderItem() {
    }

}
