package com.bakery.management.domain;

import com.bakery.management.enums.CashTransactionType;
import com.bakery.management.enums.converters.CashTransactionTypeConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "CashTransaction", schema = "dbo", catalog = "onlineaccounting")
public class CashTransaction implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CashAccountId", nullable = false)
    private CashAccount cashAccount;

    @Column(name = "CashAccountId", nullable = false, updatable = false, insertable = false)
    private int cashAccountId;

    @Column(name = "TransactionDate", nullable = false, length = 19)
    private OffsetDateTime transactionDate;

    @Convert(converter = CashTransactionTypeConverter.class)
    @Column(name = "TransactionType", nullable = false, length = 1, columnDefinition = "char(1)")
    private CashTransactionType transactionType;

    @Column(name = "TransactionAmount", nullable = false, precision = 9)
    private BigDecimal transactionAmount;

    @Column(name = "Explanation", nullable = false)
    private String explanation;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    public CashTransaction() {
    }

}
