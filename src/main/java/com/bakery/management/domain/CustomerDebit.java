package com.bakery.management.domain;

import com.bakery.management.enums.DebitStatus;
import com.bakery.management.enums.converters.DebitStatusConverter;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/***
 * Domain model class to hold customer debit data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(schema = "public")
public class CustomerDebit implements java.io.Serializable {

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
     * Parent {@link Order} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    /***
     * Foreign key to parent {@link Order} entity Id.
     */
    @Column(nullable = false)
    private UUID oderId;

    /***
     * Expected payment date.
     */
    @Column(nullable = false, length = 10)
    private LocalDate dueDate;

    /***
     * Calculated total amount including tax.
     */
    @Column(nullable = false, precision = 9)
    private BigDecimal totalDue;

    /***
     * State of debit from {@link DebitStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = DebitStatusConverter.class)
    @Column(nullable = false, length = 1)
    private DebitStatus status;

    /***
     * State of existence in persistence.
     */
    @Column(nullable = false)
    private boolean active;

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
     * Set of child {@link CustomerPayment} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerDebit")
    private Set<CustomerPayment> customerPayments = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public CustomerDebit() {
    }

}
