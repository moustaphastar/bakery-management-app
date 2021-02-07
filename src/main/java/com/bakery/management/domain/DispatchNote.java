package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "DocumentShipment", schema = "dbo", catalog = "onlineaccounting")
public class DispatchNote implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    // TODO: Refactor to long or UUID.
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InvoiceId")
    private Invoice invoice;

    @Column(name = "InvoiceId", nullable = false, updatable = false, insertable = false)
    private UUID invoiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId")
    private Merchant merchant;

    @Column(name = "MerchantId", nullable = false, updatable = false, insertable = false)
    private UUID merchantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentLoadId")
    // TODO: Map to OrderItem? ShipmentLoad might be deprecated in future.
    private ShipmentLoad shipmentLoad;

    @Column(name = "CustomerId", nullable = false, updatable = false, insertable = false)
    // TODO : Map to Customer entity?
    private UUID customerId;

    @Column(name = "ReferenceNumber")
    private String referenceNumber;

    @Column(name = "SerialNumber")
    private String serialNumber;

    @Column(name = "SequenceNumber")
    private Integer sequenceNumber;

    @Column(name = "IssueDate", nullable = false, length = 19)
    private OffsetDateTime issueDate;

    @Column(name = "SubTotal", precision = 9)
    private BigDecimal subTotal;

    @Column(name = "TaxAmount", precision = 9)
    private BigDecimal taxAmount;

    @Column(name = "TotalDue", precision = 9)
    private BigDecimal totalDue;

    @Column(name = "DeliveryPersonId", length = 36)
    // TODO: Map to Employee or Shipment entity?
    private String deliveryPersonId;

    @Column(name = "Receiver")
    private String receiver;

    @Column(name = "DeliveredAt", length = 19)
    private OffsetDateTime deliveredAt;

    @Column(name = "Note")
    private String note;

    @Column(name = "IsPaperPrinted", nullable = false)
    private boolean isPaperPrinted;

    @Column(name = "PaperPrintedAt", length = 19)
    private OffsetDateTime paperPrintedAt;

    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    @Column(name = "IsCancelled")
    private Boolean isCancelled;

    @Column(name = "Active")
    private Boolean active;

    public DispatchNote() {
    }

}
