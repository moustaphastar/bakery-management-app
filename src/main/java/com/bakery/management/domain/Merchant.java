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
@Table(schema = "public")
public class Merchant implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false, length = 36)
    private UUID id;

    /***
     * Parent {@link MerchantCategory} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchantCategoryId", nullable = false)
    private MerchantCategory merchantCategory;

    /***
     * Foreign key to parent {@link MerchantCategory} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private int merchantCategoryId;

    /***
     * Merchant's legal (business) name that should be used on legal documents.
     */
    @Column(nullable = false)
    private String legalName;

    /***
     * Merchant's legal registry identification number for trading.
     */
    @Column(nullable = false)
    private String commercialRegisterNumber;

    /***
     * Governmental registration number for trading.
     */
    // todo: What is the difference between a mersis and trade registry id?
    @Column(nullable = true)
    private String centralRegistrationSystemId;

    /***
     * Name of the tax office.
     */
    @Column(nullable = false)
    private String taxOffice;

    /***
     * Governmental taxpayer Id.
     */
    @Column(nullable = false)
    private String taxpayerId;

    /***
     * International bank account number.
     */
    @Column(nullable = false)
    private String iban;

    /***
     * Contact person first and last name.
     */
    @Column(nullable = false)
    private String contactPersonName;

    /***
     * Contact person's phone number.
     */
    @Column(nullable = false)
    private String contactPersonPhone;

    /***
     * Phone number.
     */
    @Column(nullable = false)
    private String phone;

    /***
     * Web site address.
     */
    @Column()
    private String web;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
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
