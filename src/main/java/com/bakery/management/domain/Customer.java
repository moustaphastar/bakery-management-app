package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Customer", schema = "dbo", catalog = "onlineaccounting")
public class Customer implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeId", nullable = false)
    private CustomerType customerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    @Column(name = "MerchantId", nullable = false, updatable = false, insertable = false)
    private Merchant merchantId;

    @Column(name = "TaxOffice", nullable = false)
    private String taxOffice;

    @Column(name = "TaxpayerId", nullable = false)
    private String taxpayerId;

    @Column(name = "NationalIdNumber", length = 11)
    private String nationalIdNumber;

    @Column(name = "IBAN")
    private String iban;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "DebtTotal", nullable = false, precision = 9)
    private BigDecimal debtTotal;

    @Column(name = "DebtLimit", nullable = false, precision = 9)
    private BigDecimal debtLimit;

    @Column(name = "DebtLimitExceedCount", nullable = false)
    private byte debtLimitExceedCount;

    @Column(name = "MaturityDaysTotal", nullable = false)
    private byte maturityDaysTotal;

    @Column(name = "MaturityDaysLimit", nullable = false)
    private byte maturityDaysLimit;

    @Column(name = "MaturityOverdueCount", nullable = false)
    private byte maturityOverdueCount;

    @Column(name = "LiasonPerson")
    private String liaisonPerson;

    @Column(name = "LiasonPhone")
    private String liaisonPhone;

    @Column(name = "AspNetUserId")
    private String aspNetUserId;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @Column(name = "EngagedOn", nullable = false, length = 10)
    private LocalDate engagedOn;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerDebit> customerDebits = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerPayment> customerPayments = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerDiscount> customerDiscounts = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<Order> orders = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<DriverCustomer> driverCustomers = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
    private Set<CustomerAddress> customerAddresses = new HashSet<>(0);

    public Customer() {
    }

}
