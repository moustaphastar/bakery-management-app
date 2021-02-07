package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Merchant", schema = "dbo", catalog = "onlineaccounting")
public class Merchant implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeId", nullable = false)
    private MerchantType merchantType;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "CommercialTitle", nullable = false)
    private String commercialTitle;

    @Column(name = "TradeRegistrationId")
    private String tradeRegistrationId;

    @Column(name = "MersisId")
    private String mersisId;

    @Column(name = "TaxOffice")
    private String taxOffice;

    @Column(name = "TaxpayerId")
    private String taxpayerId;

    @Column(name = "IBAN")
    private String iban;

    @Column(name = "LiasonPerson")
    private String liaisonPerson;

    @Column(name = "LiasonPhone")
    private String liaisonPhone;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Web")
    private String web;

    @Column(name = "EngagedOn", nullable = false, length = 10)
    private LocalDate engagedOn;

    @Column(name = "LastUpdate", nullable = false, length = 23)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Vehicle> vehicles = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Invoice> invoices = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Employee> employees = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Product> products = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<MerchantAddress> merchantAddresses = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Job> jobs = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Order> orders = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Customer> customers = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<DispatchNote> dispatchNotes = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<CashAccount> cashAccounts = new HashSet<>(0);

    public Merchant() {
    }

}
