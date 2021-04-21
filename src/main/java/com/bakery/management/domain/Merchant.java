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
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
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
@Table(name = "Merchant", schema = "public")
public class Merchant implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    /***
     * Parent {@link MerchantType} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeId", nullable = false)
    private MerchantType merchantType;

    /***
     * Short descriptive name of the merchant.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /***
     * Legal name of the merchant that should be used on documents.
     */
    @Column(name = "CommercialTitle", nullable = false)
    private String commercialTitle;

    /***
     * Governmental registration number for trading.
     */
    @Column(name = "TradeRegistrationId")
    private String tradeRegistrationId;

    /***
     * Governmental registration number for trading.
     */
    // todo: What is the difference between a mersis and trade registry id?
    @Column(name = "MersisId")
    private String mersisId;

    /***
     * Name of the tax office.
     */
    @Column(name = "TaxOffice")
    private String taxOffice;

    /***
     * Governmental taxpayer Id.
     */
    @Column(name = "TaxpayerId")
    private String taxpayerId;

    /***
     * International bank account number.
     */
    @Column(name = "IBAN")
    private String iban;

    /***
     * Contact person first and last name.
     */
    @Column(name = "LiasonPerson")
    private String liaisonPerson;

    /***
     * Contact person's phone number.
     */
    @Column(name = "LiasonPhone")
    private String liaisonPhone;

    /***
     * Phone number.
     */
    @Column(name = "Phone")
    private String phone;

    /***
     * Web site address.
     */
    @Column(name = "Web")
    private String web;

    /***
     * Registration date of merchant.
     */
    @Column(name = "EngagedOn", nullable = false, length = 10)
    private LocalDate engagedOn;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false, length = 23)
    private OffsetDateTime lastUpdate;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link Vehicle} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Vehicle> vehicles = new HashSet<>(0);

    /***
     * Set of child {@link Invoice} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Invoice> invoices = new HashSet<>(0);

    /***
     * Set of child {@link Employee} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Employee> employees = new HashSet<>(0);

    /***
     * Set of child {@link Product} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Product> products = new HashSet<>(0);

    /***
     * Set of child {@link MerchantAddress} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<MerchantAddress> merchantAddresses = new HashSet<>(0);

    /***
     * Set of child {@link Job} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Job> jobs = new HashSet<>(0);

    /***
     * Set of child {@link Order} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Order> orders = new HashSet<>(0);

    /***
     * Set of child {@link Customer} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<Customer> customers = new HashSet<>(0);

    /***
     * Set of child {@link DispatchNote} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<DispatchNote> dispatchNotes = new HashSet<>(0);

    /***
     * Set of child {@link CashAccount} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
    private Set<CashAccount> cashAccounts = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Merchant() {
    }

}
