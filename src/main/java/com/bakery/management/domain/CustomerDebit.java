package com.bakery.management.domain;

import com.bakery.management.enums.DebitStatus;
import com.bakery.management.enums.converters.DebitStatusConverter;
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
@Table(name = "CustomerDebit", schema = "dbo", catalog = "onlineaccounting")
public class CustomerDebit implements java.io.Serializable {

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
     * Foreign key to parent {@link Order} entity Id.
     */
    // todo: Add many to one relation for order too.
    @Column(name = "SaleId") // todo: Is this mapped to Order entity?
    private UUID saleId;

    /***
     * Expected payment date.
     */
    @Column(name = "DueDate", nullable = false, length = 10)
    private LocalDate dueDate;

    /***
     * Calculated total amount including tax.
     */
    // todo: Define decimal point indicator and precision.
    @Column(name = "TotalDue", nullable = false, precision = 9)
    private BigDecimal totalDue;

    /***
     * State of debit from {@link DebitStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = DebitStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private DebitStatus status;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

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
