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
@Table(schema = "public")
public class Order implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    /***
     * Parent {@link Address} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BillToAddressId")
    private Address billToAddress;

    /***
     * Foreign key to parent {@link Address} entity Id.
     */
    @Column(nullable = false, updatable = false,
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
    @Column(nullable = false, updatable = false,
            insertable = false)
    private int shipToAddressId;

    /***
     * Parent {@link Customer} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    /***
     * Foreign key to parent {@link Customer} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private UUID customerId;

    /***
     * Parent {@link Merchant} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchantId", nullable = false)
    private Merchant merchant;

    /***
     * Foreign key to parent {@link Merchant} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private UUID merchantId;

    /***
     * Date and time with offset the order placed.
     */
    @Column(nullable = false, length = 19)
    private OffsetDateTime orderDate;

    /***
     * Expected date of delivery.
     */
    @Column(nullable = false, length = 10)
    private OffsetDateTime dueDate;

    /***
     * Date and time with offset the order shipped.
     */
    @Column(length = 19)
    private OffsetDateTime shipDate;

    /***
     * Date and time with offset the order dropped to target.
     */
    @Column(length = 19)
    private OffsetDateTime deliveryDate;

    /***
     * Calculated total amount excluding tax.
     */
    // todo: Define decimal point indicator and precision.
    @Column(nullable = false, precision = 9)
    private BigDecimal subTotal;

    /***
     * Calculated tax amount.
     */
    // todo: Define decimal point indicator and precision.
    @Column(nullable = false, precision = 9)
    private BigDecimal taxAmount;

    /***
     * Calculated total amount including tax.
     */
    // todo: Define decimal point indicator and precision.
    @Column(precision = 10)
    private BigDecimal totalDue;

    /***
     * Type of shipment method from {@link ShipmentMethod}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = ShipmentMethodConverter.class)
    @Column(length = 1)
    private ShipmentMethod shipmentMethod;

    /***
     * Indication of the order is received online or not.
     * True if online, false if face to face.
     */
    @Column(nullable = false)
    private boolean onlineOrderFlag;

    /***
     * Type of document from {@link DocumentType}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = DocumentTypeConverter.class)
    @Column(length = 1)
    private DocumentType documentType;

    /***
     * State of order from {@link OrderStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = OrderStatusConverter.class)
    @Column(nullable = false, length = 1)
    private OrderStatus status;

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
