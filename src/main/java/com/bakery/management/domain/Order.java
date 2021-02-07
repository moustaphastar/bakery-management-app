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

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Sale", schema = "dbo", catalog = "onlineaccounting")
public class Order implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BillToAddressId")
    private Address billToAddress;

    @Column(name = "BillToAddressId", nullable = false, updatable = false, insertable = false)
    private int billToAddressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipToAddressId")
    private Address shipToAddress;

    @Column(name = "ShipToAddressId", nullable = false, updatable = false, insertable = false)
    private int shipToAddressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    @Column(name = "CustomerId", nullable = false, updatable = false, insertable = false)
    private UUID customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    @Column(name = "MerchantId", nullable = false, updatable = false, insertable = false)
    private UUID merchantId;

    @Column(name = "OrderDate", nullable = false, length = 19)
    private OffsetDateTime orderDate;

    @Column(name = "DueDate", nullable = false, length = 10)
    private LocalDate dueDate;

    @Column(name = "ShipDate", length = 19)
    private LocalDate shipDate;

    @Column(name = "DeliveryDate", length = 19)
    private OffsetDateTime deliveryDate;

    @Column(name = "SubTotal", nullable = false, precision = 9)
    private BigDecimal subTotal;

    @Column(name = "TaxAmount", nullable = false, precision = 9)
    private BigDecimal taxAmount;

    @Column(name = "TotalDue", precision = 10)
    private BigDecimal totalDue;

    @Convert(converter = ShipmentMethodConverter.class)
    @Column(name = "ShipmentMethod", length = 1)
    private ShipmentMethod shipmentMethod;

    @Column(name = "OnlineOrderFlag", nullable = false)
    private boolean onlineOrderFlag;

    @Convert(converter = DocumentTypeConverter.class)
    @Column(name = "DocumentType", length = 1)
    private DocumentType documentType;

    @Convert(converter = OrderStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private OrderStatus status;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<Invoice> invoices = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<>(0);

    public Order() {
    }

}
