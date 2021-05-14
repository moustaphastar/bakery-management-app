package com.bakery.management.domain;

import com.bakery.management.enums.PaymentStatus;
import com.bakery.management.enums.PaymentType;
import com.bakery.management.enums.converters.PaymentStatusConverter;
import com.bakery.management.enums.converters.PaymentTypeConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

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
@Table(schema = "public")
public class CustomerPayment implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Customer} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId", nullable = false)
    private Customer customer;

    /***
     * Foreign key to parent {@link Customer} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private UUID customerId;

    /***
     * Parent {@link CustomerDebit} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerDebitId", nullable = false)
    private CustomerDebit customerDebit;

    /***
     * Foreign key to parent {@link CustomerDebit} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private int customerDebitId;

    /***
     * Amount of payment received.
     */
    // todo: Enhance Javadoc. Define decimal point separator and precision.
    @Column(nullable = false, precision = 9)
    private BigDecimal amountPaid;

    /***
     * Date and time with offset the payment received from customer.
     */
    @Column(nullable = false, length = 19)
    private OffsetDateTime paymentDate;

    /***
     * Type of payment from {@link PaymentType}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = PaymentTypeConverter.class)
    @Column(nullable = false, length = 1)
    private PaymentType paymentType;

    /***
     * State of payment from {@link PaymentStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = PaymentStatusConverter.class)
    @Column(nullable = false, length = 1)
    private PaymentStatus approvalStatus;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
    @Generated(value = GenerationTime.INSERT)
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
     * Class constructor.
     */
    public CustomerPayment() {
    }

}
