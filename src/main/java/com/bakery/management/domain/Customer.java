package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
 * Domain model class to hold customer data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(schema = "public")
public class Customer implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false, length = 36)
    private UUID id;

    /***
     * Parent {@link CustomerCategory} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerCategoryId", nullable = false)
    private CustomerCategory customerCategory;

    /***
     * Foreign key to parent {@link CustomerCategory} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private int customerCategoryId;

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
     * Name of the tax office.
     */
    @Column(nullable = false)
    private String taxOffice;

    /***
     * Governmental taxpayer id number.
     */
    @Column(nullable = false)
    private String taxpayerId;

    /***x
     * Governmental id number.
     */
    @Column(length = 11)
    private String nationalIdNumber;

    /***
     * International bank account number.
     */
    @Column(nullable = false)
    private String iban;

    /***
     * Legal name. Firstname and lastname in case a real person.
     */
    @Column(nullable = false)
    // todo: A short descriptive name field is needed.
    private String name;

    /***
     * Total sales amount to be collected.
     */
    @Column(nullable = false, precision = 9)
    private BigDecimal debtTotal;

    /***
     * Total amount allowed to debt. A warning should be
     * produced if a customer closed to that limit and
     * should be blocked from purchasing.
     */
    // todo: Produce warning and blocking logic.
    @Column(nullable = false, precision = 9)
    private BigDecimal debtLimit;

    /***
     * Count of warning made about {@see debtLimit}.
     */
    @Column(nullable = false)
    private byte debtLimitExceedCount;

    /***
     * Total maturity days for all active non finalized debts.
     * @see com.bakery.management.enums.DebitStatus for debit status enums.
     */
    // todo: Produce the logic to see maturity for each debt.
    @Column(nullable = false)
    private byte maturityDaysTotal;

    /***
     * Total days a debt can be paid after delivery date.
     * A warning should be produced if a customer closed
     * to that limit and should be blocked from purchasing.
     */
    @Column(nullable = false)
    private byte maturityDaysLimit;

    /***
     * Count of warnings made about {@see maturityDaysLimit}.
     */
    @Column(nullable = false)
    private byte maturityOverdueCount;

    /***
     * Contact person firstname and lastname.
     */
    @Column(nullable = false)
    private String liaisonPerson;

    /***
     * Contact person's phone number.
     */
    @Column(nullable = false)
    private String liaisonPhone;

    /***
     * User id, if available.
     */
    @Column(nullable = false)
    private String aspNetUserId;

    /***
     * State of existence in persistence.
     */
    @Column(nullable = false)
    private boolean active;

    /***
     * Date of registry.
     */
    @Column(nullable = false, length = 10)
    private LocalDate engagedOn;

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
     * Set of child {@link CustomerDebit} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerDebit> customerDebits = new HashSet<>(0);

    /***
     * Set of child {@link CustomerPayment} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerPayment> customerPayments = new HashSet<>(0);

    /***
     * Set of child {@link CustomerDiscount} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerDiscount> customerDiscounts = new HashSet<>(0);

    /***
     * Set of child {@link Order} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> orders = new HashSet<>(0);

    /***
     * Set of child {@link DriverCustomer} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<DriverCustomer> driverCustomers = new HashSet<>(0);

    /***
     * Set of child {@link CustomerAddress} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerAddress> customerAddresses = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Customer() {
    }

}
