package com.bakery.management.domain;

import com.bakery.management.enums.DocumentType;
import com.bakery.management.enums.OrderStatus;
import com.bakery.management.enums.ShipmentMethod;
import com.bakery.management.enums.converters.DocumentTypeConverter;
import com.bakery.management.enums.converters.OrderStatusConverter;
import com.bakery.management.enums.converters.ShipmentMethodConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "Sale", schema = "public")
public class Order implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Address} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BillToAddressId")
    private Address billToAddress;

    /***
     * Foreign key to parent {@link Address} entity Id.
     */
    @Column(name = "BillToAddressId", nullable = false, updatable = false,
            insertable = false)
    private int billToAddressId;

    /***
     * Parent {@link Address} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipToAddressId")
    private Address shipToAddress;

    /***
     * Foreign key to parent {@link Address} entity Id.
     */
    @Column(name = "ShipToAddressId", nullable = false, updatable = false,
            insertable = false)
    private int shipToAddressId;

    /***
     * Parent {@link Customer} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    /***
     * Foreign key to parent {@link Customer} entity Id.
     */
    @Column(name = "CustomerId", nullable = false, updatable = false,
            insertable = false)
    private UUID customerId;

    /***
     * Parent {@link Merchant} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    /***
     * Foreign key to parent {@link Merchant} entity Id.
     */
    @Column(name = "MerchantId", nullable = false, updatable = false,
            insertable = false)
    private UUID merchantId;

    /***
     * Date and time with offset the order placed.
     */
    @Column(name = "OrderDate", nullable = false, length = 19)
    private OffsetDateTime orderDate;

    /***
     * Expected date of delivery.
     */
    @Column(name = "DueDate", nullable = false, length = 10)
    private LocalDate dueDate;

    /***
     * Date and time with offset the order shipped.
     */
    @Column(name = "ShipDate", length = 19)
    private LocalDate shipDate;

    /***
     * Date and time with offset the order dropped to target.
     */
    @Column(name = "DeliveryDate", length = 19)
    private OffsetDateTime deliveryDate;

    /***
     * Calculated total amount excluding tax.
     */
    // todo: Define decimal point indicator and precision.
    @Column(name = "SubTotal", nullable = false, precision = 9)
    private BigDecimal subTotal;

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
    @Column(name = "TotalDue", precision = 10)
    private BigDecimal totalDue;

    /***
     * Type of shipment method from {@link ShipmentMethod}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = ShipmentMethodConverter.class)
    @Column(name = "ShipmentMethod", length = 1)
    private ShipmentMethod shipmentMethod;

    /***
     * Indication of the order is received online or not.
     * True if online, false if face to face.
     */
    @Column(name = "OnlineOrderFlag", nullable = false)
    private boolean onlineOrderFlag;

    /***
     * Type of document from {@link DocumentType}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = DocumentTypeConverter.class)
    @Column(name = "DocumentType", length = 1)
    private DocumentType documentType;

    /***
     * State of order from {@link OrderStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = OrderStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private OrderStatus status;

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
     * Set of child {@link Invoice} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<Invoice> invoices = new HashSet<>(0);

    /***
     * Set of child {@link OrderItem} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Order() {
    }

}
