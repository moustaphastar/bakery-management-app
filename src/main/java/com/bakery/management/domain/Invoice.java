package com.bakery.management.domain;

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
@Table(name = "DocumentInvoice", schema = "dbo", catalog = "onlineaccounting")
public class Invoice implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    @Column(name = "MerchantId", nullable = false, updatable = false, insertable = false)
    private UUID merchantId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SaleId", nullable = false)
    private Order order;

    @Column(name = "SaleId", nullable = false, updatable = false, insertable = false)
    private int saleId;

    @Column(name = "CustomerId", length = 36)
    // TODO: Is this mapped to Customer entity?
    private String customerId;

    @Column(name = "ReferenceNumber", nullable = false)
    private String referenceNumber;

    @Column(name = "SerialNumber")
    private String serialNumber;

    @Column(name = "SequenceNumber")
    private Integer sequenceNumber;

    @Column(name = "IssueDate", length = 19)
    private OffsetDateTime issueDate;

    @Column(name = "SubTotal", precision = 9)
    private BigDecimal subTotal;

    @Column(name = "TaxAmount", precision = 9)
    private BigDecimal taxAmount;

    @Column(name = "TotalDue", precision = 9)
    private BigDecimal totalDue;

    @Column(name = "DeliveryPersonId", length = 36)
    // TODO: Shipment model class holds the driver employee id.
    private String deliveryPersonId;

    @Column(name = "Receiver")
    private String receiver;

    @Column(name = "DeliveredAt", length = 19)
    private OffsetDateTime deliveredAt;

    @Column(name = "Note")
    private String note;

    @Column(name = "IsPaperPrinted", nullable = false)
    // TODO: Refactor to use DocumentType enum.
    private boolean isPaperPrinted;

    @Column(name = "PaperPrintedAt", length = 19)
    // TODO: Consider with isPaperPrinted field.
    private OffsetDateTime paperPrintedAt;

    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    @Column(name = "IsCancelled")
    // TODO: Implement a DocumentStatus enum.
    private Boolean isCancelled;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
    private Set<DispatchNote> dispatchNotes = new HashSet<>(0);

    public Invoice() {
    }

}
