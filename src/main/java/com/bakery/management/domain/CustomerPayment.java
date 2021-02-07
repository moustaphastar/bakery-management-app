package com.bakery.management.domain;

import com.bakery.management.enums.PaymentStatus;
import com.bakery.management.enums.PaymentType;
import com.bakery.management.enums.converters.PaymentStatusConverter;
import com.bakery.management.enums.converters.PaymentTypeConverter;
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
@Table(name = "CustomerPayment", schema = "dbo", catalog = "onlineaccounting")
public class CustomerPayment implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    @Column(name = "CustomerId", nullable = false, updatable = false, insertable = false)
    private UUID customerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerDebitId", nullable = false)
    private CustomerDebit customerDebit;

    @Column(name = "AmountPaid", nullable = false, precision = 9)
    private BigDecimal amountPaid;

    @Column(name = "PaymentDate", nullable = false, length = 19)
    private OffsetDateTime paymentDate;

    @Convert(converter = PaymentTypeConverter.class)
    @Column(name = "PaymentType", nullable = false, length = 1)
    private PaymentType paymentType;

    @Convert(converter = PaymentStatusConverter.class)
    @Column(name = "ApprovalStatus", nullable = false, length = 1)
    private PaymentStatus approvalStatus;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    public CustomerPayment() {
    }

}
