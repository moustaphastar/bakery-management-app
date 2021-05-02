package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
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
public class DispatchNote implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    // todo: Refactor to long or UUID.
    private int id;

    /***
     * Parent {@link Invoice} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InvoiceId")
    private Invoice invoice;

    /***
     * Foreign key to parent {@link Invoice} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private UUID invoiceId;

    /***
     * Parent {@link Merchant} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId")
    private Merchant merchant;

    /***
     * Foreign key to parent {@link Merchant} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private UUID merchantId;

    /***
     * Parent {@link ShipmentLoad} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ShipmentLoadId")
    // todo: Map to OrderItem? ShipmentLoad might be deprecated in future.
    private ShipmentLoad shipmentLoad;

    /***
     * Foreign key to parent {@link Customer} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    // todo : Map to Customer entity?
    private UUID customerId;

    /***
     * Document reference number.
     */
    // todo: Generate reference number producer method.
    @Column(nullable = false)
    private String referenceNumber;

    /***
     * Legal serial number. Unique in a year.
     */
    @Column(nullable = false)
    private String serialNumber;

    /***
     * Legal sequence number. Unique in a serial group.
     */
    @Column(nullable = false)
    private Integer sequenceNumber;

    /***
     * Date and time with offset the document first became legally existing.
     * It might be very close to paper printing time but not the same.
     * @see #isPaperPrinted
     * @see #isPaperPrinted()
     */
    @Column(nullable = false, length = 19)
    private OffsetDateTime issueDate;

    /***
     * Calculated total amount excluding tax.
     */
    // todo: Define decimal point indicator and precision.
    @Column(precision = 9)
    private BigDecimal subTotal;

    /***
     * Calculated tax amount.
     */
    // todo: Define decimal point indicator and precision.
    @Column(precision = 9)
    private BigDecimal taxAmount;

    /***
     * Calculated total amount including tax.
     */
    // todo: Define decimal point indicator and precision.
    @Column(precision = 9)
    private BigDecimal totalDue;

    /***
     * Firstname and lastname of the person who delivered the document.
     */
    @Column(length = 36)
    // todo: Map to Employee or Shipment entity?
    private String deliveryPersonId;

    /***
     * First and last name of the authorized person who received the document.
     */
    @Column(nullable = false)
    private String receiver;

    /***
     * Date and time of delivery with offset.
     * @see Shipment
     */
    @Column(length = 19)
    private OffsetDateTime deliveredAt;

    /***
     * Additional notes on document.
     */
    @Column(nullable = true)
    private String note;

    /***
     * State of document's physical existence as a legal paper.
     * The document and its legal copies can be paper printed
     * by this {@link com.bakery.management.Application} only once
     * since they are whole together and have the same serial
     * and sequence number.
     */
    @Column(nullable = false)
    private boolean isPaperPrinted;

    /***
     * Date and time of paper printing with offset.
     * @see #isPaperPrinted
     */
    @Column(length = 19)
    private OffsetDateTime paperPrintedAt;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
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
     * State of document usability in financial accounting.
     * The document is {@link #active} but neither the document
     * nor its serial and sequence number can not be used in accounting.
     */
    @Column(nullable = false)
    private Boolean isCancelled;

    /***
     * State of existence in persistence.
     */
    @Column(nullable = false)
    private Boolean active;

    /***
     * Class constructor.
     */
    public DispatchNote() {
    }

}
