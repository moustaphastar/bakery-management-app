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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/***
 * Domain model class to hold cash account data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(schema = "public")
public class CashAccount implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

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
     * Yearly financial period that financial accounting is applied.
     */
    @Column(nullable = false)
    private int fiscalYear;

    /***
     * Total cash amount received currently.
     */
    @SuppressWarnings("magicnumber")
    @Column(nullable = false, precision = 9)
    private BigDecimal totalReceived;

    /***
     * Total cash amount paid currently.
     */
    @SuppressWarnings("magicnumber")
    @Column(nullable = false, precision = 9)
    private BigDecimal totalPaid;

    /***
     * The balance coming from previous financial term or an opening balance.
     */
    @SuppressWarnings("magicnumber")
    @Column(nullable = false, precision = 9)
    private BigDecimal outstandingBalance;

    /***
     * Current balance.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(precision = 11)
    private BigDecimal balance;

    /***
     * From this amount,it is compulsory to issue an invoice.
     * Transactions with lower amounts can be processed without invoice
     * such as point of sale receipts, bills.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(nullable = false, precision = 9)
    private BigDecimal regularInvoiceLimit;

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
     * State of existence in persistence.
     */
    @Column(nullable = false)
    private boolean active;

    /***
     * Set of child {@link CashTransaction} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cashAccount")
    private Set<CashTransaction> cashTransactions = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public CashAccount() {
    }

}
