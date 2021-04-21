package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
@Table(name = "Customer", schema = "public")
public class Customer implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    /***
     * Parent {@link CustomerType} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeId", nullable = false)
    private CustomerType customerType;

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
    private Merchant merchantId;

    /***
     * Name of the tax office.
     */
    @Column(name = "TaxOffice", nullable = false)
    private String taxOffice;

    /***
     * Governmental taxpayer id number.
     */
    @Column(name = "TaxpayerId", nullable = false)
    private String taxpayerId;

    /***x
     * Governmental id number.
     */
    @Column(name = "NationalIdNumber", length = 11)
    private String nationalIdNumber;

    /***
     * International bank account number.
     */
    @Column(name = "IBAN")
    private String iban;

    /***
     * Legal name. Firstname and lastname in case a real person.
     */
    @Column(name = "Name", nullable = false)
    // todo: A short descriptive name field is needed.
    private String name;

    /***
     * Total sales amount to be collected.
     */
    @Column(name = "DebtTotal", nullable = false, precision = 9)
    private BigDecimal debtTotal;

    /***
     * Total amount allowed to debt. A warning should be
     * produced if a customer closed to that limit and
     * should be blocked from purchasing.
     */
    // todo: Produce warning and blocking logic.
    @Column(name = "DebtLimit", nullable = false, precision = 9)
    private BigDecimal debtLimit;

    /***
     * Count of warning made about {@see debtLimit}.
     */
    @Column(name = "DebtLimitExceedCount", nullable = false)
    private byte debtLimitExceedCount;

    /***
     * Total maturity days for all active non finalized debts.
     * @see com.bakery.management.enums.DebitStatus for debit status enums.
     */
    // todo: Produce the logic to see maturity for each debt.
    @Column(name = "MaturityDaysTotal", nullable = false)
    private byte maturityDaysTotal;

    /***
     * Total days a debt can be paid after delivery date.
     * A warning should be produced if a customer closed
     * to that limit and should be blocked from purchasing.
     */
    @Column(name = "MaturityDaysLimit", nullable = false)
    private byte maturityDaysLimit;

    /***
     * Count of warnings made about {@see maturityDaysLimit}.
     */
    @Column(name = "MaturityOverdueCount", nullable = false)
    private byte maturityOverdueCount;

    /***
     * Contact person firstname and lastname.
     */
    @Column(name = "LiasonPerson")
    private String liaisonPerson;

    /***
     * Contact person's phone number.
     */
    @Column(name = "LiasonPhone")
    private String liaisonPhone;

    /***
     * User id, if available.
     */
    @Column(name = "AspNetUserId")
    private String aspNetUserId;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Date of registry.
     */
    @Column(name = "EngagedOn", nullable = false, length = 10)
    private LocalDate engagedOn;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

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
