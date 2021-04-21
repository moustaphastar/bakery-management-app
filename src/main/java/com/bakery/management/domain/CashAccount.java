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
 * Domain model class to hold cash account data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "CashAccount", schema = "public")
public class CashAccount implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

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
     * Yearly financial period that financial accounting is applied.
     */
    @Column(name = "FiscalYear", nullable = false)
    private int fiscalYear;

    /***
     * Total cash amount received currently.
     */
    @SuppressWarnings("magicnumber")
    @Column(name = "TotalReceived", nullable = false, precision = 9)
    private BigDecimal totalReceived;

    /***
     * Total cash amount paid currently.
     */
    @SuppressWarnings("magicnumber")
    @Column(name = "TotalPaid", nullable = false, precision = 9)
    private BigDecimal totalPaid;

    /***
     * The balance coming from previous financial term or an opening balance.
     */
    @SuppressWarnings("magicnumber")
    @Column(name = "OutstandingBalance", nullable = false, precision = 9)
    private BigDecimal outstandingBalance;

    /***
     * Current balance.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "Balance", precision = 11)
    private BigDecimal balance;

    /***
     * From this amount,it is compulsory to issue an invoice.
     * Transactions with lower amounts can be processed without invoice
     * such as point of sale receipts, bills.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "RegularInvoiceLimit", nullable = false, precision = 9)
    private BigDecimal regularInvoiceLimit;

    /***
     * Date and time of last update with an offset.
     */
    @SuppressWarnings("checkstyle:magicnumber")
    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
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
