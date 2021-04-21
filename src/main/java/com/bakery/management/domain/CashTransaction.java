package com.bakery.management.domain;

import com.bakery.management.enums.CashTransactionType;
import com.bakery.management.enums.converters.CashTransactionTypeConverter;
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
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

/***
 * Domain model class to hold cash transaction data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "CashTransaction", schema = "public")
public class CashTransaction implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link CashAccount} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CashAccountId", nullable = false)
    private CashAccount cashAccount;

    /***
     * Foreign key to parent {@link CashAccount} entity Id.
     */
    @Column(name = "CashAccountId", nullable = false, updatable = false,
            insertable = false)
    private int cashAccountId;

    /***
     * Date and time with offset the transaction is processed.
     */
    @Column(name = "TransactionDate", nullable = false, length = 19)
    private OffsetDateTime transactionDate;

    /***
     * Type of transaction from {@link CashTransactionType}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = CashTransactionTypeConverter.class)
    @Column(name = "TransactionType", nullable = false, length = 1,
            columnDefinition = "char(1)")
    private CashTransactionType transactionType;

    /***
     * Total amount including tax amount.
     */
    @Column(name = "TransactionAmount", nullable = false, precision = 9)
    private BigDecimal transactionAmount;

    /***
     * Information about the source and the reason of the transaction.
     * Unique identification numbers of the corresponding payment document
     * should be included.
     */
    @Column(name = "Explanation", nullable = false)
    private String explanation;

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
     * Class constructor.
     */
    public CashTransaction() {
    }

}
