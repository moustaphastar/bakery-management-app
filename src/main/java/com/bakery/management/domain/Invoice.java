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

/***
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "DocumentInvoice", schema = "public")
public class Invoice implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

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
    private int saleId;

    /***
     * Foreign key to parent {@link Customer} entity Id.
     */
    @Column(name = "CustomerId", length = 36)
    // todo: Is this mapped to Customer entity?
    private String customerId;

    /***
     * Document reference number.
     */
    @Column(name = "ReferenceNumber", nullable = false)
    private String referenceNumber;

    /***
     * Legal serial number. Unique in a year.
     */
    @Column(name = "SerialNumber")
    private String serialNumber;

    /***
     * Legal sequence number. Unique in a serial group.
     */
    @Column(name = "SequenceNumber")
    private Integer sequenceNumber;

    /***
     * Date and time with offset the document first became legally existing.
     * It might be very close to paper printing time but not the same.
     * It can not be more than 7 days later than delivery date.
     * @see #isPaperPrinted
     * @see #isPaperPrinted()
     * @see ShipmentLoad for delivery date
     */
    @Column(name = "IssueDate", length = 19)
    private OffsetDateTime issueDate;

    /***
     * Calculated total amount excluding tax.
     */
    // todo: Define decimal point indicator and precision.
    @Column(name = "SubTotal", precision = 9)
    private BigDecimal subTotal;

    /***
     * Calculated tax amount.
     */
    // todo: Define decimal point indicator and precision.
    @Column(name = "TaxAmount", precision = 9)
    private BigDecimal taxAmount;

    /***
     * Calculated total amount including tax.
     */
    // todo: Define decimal point indicator and precision.
    @Column(name = "TotalDue", precision = 9)
    private BigDecimal totalDue;

    /***
     * Firstname and lastname of the person who delivered the document.
     */
    @Column(name = "DeliveryPersonId", length = 36)
    // todo: Shipment model class holds the driver employee id.
    private String deliveryPersonId;

    /***
     * Firstname and lastname of the person who received the document.
     */
    @Column(name = "Receiver")
    private String receiver;

    /***
     * Date and time of delivery with offset.
     * @see Shipment
     */
    @Column(name = "DeliveredAt", length = 19)
    private OffsetDateTime deliveredAt;

    /***
     * Additional notes on document.
     */
    @Column(name = "Note")
    private String note;

    /***
     * State of document's physical existence as a legal paper.
     * The document and its legal copies can be paper printed
     * by this {@link com.bakery.management.Application} only once
     * since they are whole together and have the same serial
     * and sequence number.
     */
    @Column(name = "IsPaperPrinted", nullable = false)
    // todo: Refactor to use DocumentType enum.
    private boolean isPaperPrinted;

    /***
     * Date and time of paper printing with offset.
     * @see #isPaperPrinted
     */
    @Column(name = "PaperPrintedAt", length = 19)
    // todo: Consider with isPaperPrinted field.
    private OffsetDateTime paperPrintedAt;

    /***
     * Date and time of first persisting with an offset.
     */
    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    /***
     * State of document usability in financial accounting.
     * The document is {@link #active} but neither the document
     * nor its serial and sequence number can not be used in accounting.
     */
    @Column(name = "IsCancelled")
    // todo: Implement a DocumentStatus enum.
    private Boolean isCancelled;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link DispatchNote} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice")
    private Set<DispatchNote> dispatchNotes = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Invoice() {
    }

}
