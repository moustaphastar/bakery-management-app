package com.bakery.management.domain;

import com.bakery.management.enums.PaymentStatus;
import com.bakery.management.enums.PaymentType;
import com.bakery.management.enums.converters.PaymentStatusConverter;
import com.bakery.management.enums.converters.PaymentTypeConverter;
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
@Table(name = "CustomerPayment", schema = "dbo", catalog = "onlineaccounting")
public class CustomerPayment implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Customer} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    /***
     * Foreign key to parent {@link Customer} entity Id.
     */
    @Column(name = "CustomerId", nullable = false, updatable = false,
            insertable = false)
    private UUID customerId;

    /***
     * Parent {@link CustomerDebit} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerDebitId", nullable = false)
    private CustomerDebit customerDebit;

    /***
     * Foreign key to parent {@link CustomerDebit} entity Id.
     */
    @Column(name = "CustomerDebitId", nullable = false, updatable = false,
            insertable = false)
    private int customerDebitId;

    /***
     * Amount of payment received.
     */
    // todo: Enhance Javadoc. Define decimal point separator and precision.
    @Column(name = "AmountPaid", nullable = false, precision = 9)
    private BigDecimal amountPaid;

    /***
     * Date and time with offset the payment received from customer.
     */
    @Column(name = "PaymentDate", nullable = false, length = 19)
    private OffsetDateTime paymentDate;

    /***
     * Type of payment from {@link PaymentType}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = PaymentTypeConverter.class)
    @Column(name = "PaymentType", nullable = false, length = 1)
    private PaymentType paymentType;

    /***
     * State of payment from {@link PaymentStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = PaymentStatusConverter.class)
    @Column(name = "ApprovalStatus", nullable = false, length = 1)
    private PaymentStatus approvalStatus;

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
    public CustomerPayment() {
    }

}
