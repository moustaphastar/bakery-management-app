package com.bakery.management.domain;

import com.bakery.management.enums.OrderItemStatus;
import com.bakery.management.enums.ShipmentPartsOfDay;
import com.bakery.management.enums.converters.OrderItemStatusConverter;
import com.bakery.management.enums.converters.ShipmentPartsOfDayConverter;
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
import java.math.BigDecimal;
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
@Table(name = "SaleDetail", schema = "public")
public class OrderItem implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    // todo: Refactor to use long or uuid.
    private int id;

    /***
     * Parent {@link Product} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    /***
     * Foreign key to parent {@link Product} entity Id.
     */
    @Column(name = "ProductId", nullable = false, updatable = false,
            insertable = false)
    private UUID productId;

    /***
     * Parent {@link Order} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SaleId", nullable = false)
    private Order order;

    /***
     * Foreign key to parent {@link Order} entity Id.
     */
    @Column(name = "SaleId", nullable = false, updatable = false,
            insertable = false)
    private int orderId;

    /***
     * Reference number to track order item as load of a carrier and shipment.
     */
    @Column(name = "CarrierTrackingNumber")
    private String carrierTrackingNumber;

    /***
     * Quantity of ordered product.
     */
    @Column(name = "Quantity", nullable = false)
    private int quantity;

    /***
     * Unit price of ordered product.
     */
    // todo: Include unit data in a separate field?
    @Column(name = "UnitPrice", nullable = false, precision = 9)
    private BigDecimal unitPrice;

    /***
     * Calculated total amount excluding tax.
     */
    @Column(name = "LineTotal", nullable = false, precision = 9)
    private BigDecimal lineTotal;

    /***
     * Calculated tax amount.
     */
    // todo: Define decimal point indicator and precision.
    @Column(name = "TaxAmount", nullable = false, precision = 9)
    private BigDecimal taxAmount;

    /***
     * Calculated total amount including tax.
     */
    // todo: Define decimal point indicator and precision.
    @Column(name = "TotalDue", nullable = false, precision = 9)
    private BigDecimal totalDue;

    /***
     * Type of day part from {@link ShipmentPartsOfDay}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = ShipmentPartsOfDayConverter.class)
    @Column(name = "ShippingDayPart", nullable = false, length = 1)
    private ShipmentPartsOfDay shippingDayPart;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    /***
     * State of order item from {@link OrderItemStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = OrderItemStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private OrderItemStatus status;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link ShipmentLoad} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderItem")
    private Set<ShipmentLoad> shipmentLoads = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public OrderItem() {
    }

}
