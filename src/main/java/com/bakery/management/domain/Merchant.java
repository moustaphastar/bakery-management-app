package com.bakery.management.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Merchant", schema = "public", catalog = "bakery")
public class Merchant implements java.io.Serializable {

	private UUID id;
	private MerchantType merchantType;
	private String name;
	private String commercialTitle;
	private String tradeRegistrationId;
	private String mersisId;
	private String taxOffice;
	private String taxpayerId;
	private String iban;
	private String liaisonPerson;
	private String liaisonPhone;
	private String phone;
	private String web;
	private Date engagedOn;
	private Date lastUpdate;
	private boolean active;
	private Set<Vehicle> vehicles = new HashSet<>(0);
	private Set<DocumentInvoice> documentInvoices = new HashSet<>(0);
	private Set<Employee> employees = new HashSet<>(0);
	private Set<Product> products = new HashSet<>(0);
	private Set<MerchantAddress> merchantAddresses = new HashSet<>(0);
	private Set<Job> jobs = new HashSet<>(0);
	private Set<Sale> sales = new HashSet<>(0);
	private Set<Customer> customers = new HashSet<>(0);
	private Set<DocumentShipment> documentShipments = new HashSet<>(0);
	private Set<CashAccount> cashAccounts = new HashSet<>(0);

	public Merchant() {
	}

	public Merchant(UUID id, MerchantType merchantType, String name, String commercialTitle,
					Date engagedOn, Date lastUpdate, boolean active) {
		this.id = id;
		this.merchantType = merchantType;
		this.name = name;
		this.commercialTitle = commercialTitle;
		this.engagedOn = engagedOn;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public Merchant(UUID id, MerchantType merchantType, String name, String commercialTitle,
					String tradeRegistrationId, String mersisId, String taxOffice, String taxpayerId,
					String iban, String liaisonPerson, String liaisonPhone, String phone,
					String web, Date engagedOn, Date lastUpdate, boolean active, Set<Vehicle> vehicles, Set<DocumentInvoice> documentInvoices,
					Set<Employee> employees, Set<Product> products, Set<MerchantAddress> merchantAddresses, Set<Job> jobs, Set<Sale> sales, Set<Customer> customers,
					Set<DocumentShipment> documentShipments, Set<CashAccount> cashAccounts) {
		this.id = id;
		this.merchantType = merchantType;
		this.name = name;
		this.commercialTitle = commercialTitle;
		this.tradeRegistrationId = tradeRegistrationId;
		this.mersisId = mersisId;
		this.taxOffice = taxOffice;
		this.taxpayerId = taxpayerId;
		this.iban = iban;
		this.liaisonPerson = liaisonPerson;
		this.liaisonPhone = liaisonPhone;
		this.phone = phone;
		this.web = web;
		this.engagedOn = engagedOn;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.vehicles = vehicles;
		this.documentInvoices = documentInvoices;
		this.employees = employees;
		this.products = products;
		this.merchantAddresses = merchantAddresses;
		this.jobs = jobs;
		this.sales = sales;
		this.customers = customers;
		this.documentShipments = documentShipments;
		this.cashAccounts = cashAccounts;
	}

	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false, length = 36)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TypeId", nullable = false)
	public MerchantType getMerchantType() {
		return this.merchantType;
	}

	public void setMerchantType(MerchantType merchantType) {
		this.merchantType = merchantType;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CommercialTitle", nullable = false)
	public String getCommercialTitle() {
		return this.commercialTitle;
	}

	public void setCommercialTitle(String commercialTitle) {
		this.commercialTitle = commercialTitle;
	}

	@Column(name = "TradeRegistrationId")
	public String getTradeRegistrationId() {
		return this.tradeRegistrationId;
	}

	public void setTradeRegistrationId(String tradeRegistrationId) {
		this.tradeRegistrationId = tradeRegistrationId;
	}

	@Column(name = "MersisId")
	public String getMersisId() {
		return this.mersisId;
	}

	public void setMersisId(String mersisId) {
		this.mersisId = mersisId;
	}

	@Column(name = "TaxOffice")
	public String getTaxOffice() {
		return this.taxOffice;
	}

	public void setTaxOffice(String taxOffice) {
		this.taxOffice = taxOffice;
	}

	@Column(name = "TaxpayerId")
	public String getTaxpayerId() {
		return this.taxpayerId;
	}

	public void setTaxpayerId(String taxpayerId) {
		this.taxpayerId = taxpayerId;
	}

	@Column(name = "IBAN")
	public String getIban() {
		return this.iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Column(name = "LiaisonPerson")
	public String getLiaisonPerson() {
		return this.liaisonPerson;
	}

	public void setLiaisonPerson(String liaisonPerson) {
		this.liaisonPerson = liaisonPerson;
	}

	@Column(name = "LiaisonPhone")
	public String getLiaisonPhone() {
		return this.liaisonPhone;
	}

	public void setLiaisonPhone(String liaisonPhone) {
		this.liaisonPhone = liaisonPhone;
	}

	@Column(name = "Phone")
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "Web")
	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EngagedOn", nullable = false, length = 10)
	public Date getEngagedOn() {
		return this.engagedOn;
	}

	public void setEngagedOn(Date engagedOn) {
		this.engagedOn = engagedOn;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdate", nullable = false, length = 23)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<Vehicle> getVehicles() {
		return this.vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<DocumentInvoice> getDocumentInvoices() {
		return this.documentInvoices;
	}

	public void setDocumentInvoices(Set<DocumentInvoice> documentInvoices) {
		this.documentInvoices = documentInvoices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<Product> getProducts() {
		return this.products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<MerchantAddress> getMerchantAddresses() {
		return this.merchantAddresses;
	}

	public void setMerchantAddresses(Set<MerchantAddress> merchantAddresses) {
		this.merchantAddresses = merchantAddresses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<Job> getJobs() {
		return this.jobs;
	}

	public void setJobs(Set<Job> jobs) {
		this.jobs = jobs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<Sale> getSales() {
		return this.sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<DocumentShipment> getDocumentShipments() {
		return this.documentShipments;
	}

	public void setDocumentShipments(Set<DocumentShipment> documentShipments) {
		this.documentShipments = documentShipments;
	}

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "merchant")
	public Set<CashAccount> getCashAccounts() {
		return this.cashAccounts;
	}

	public void setCashAccounts(Set<CashAccount> cashAccounts) {
		this.cashAccounts = cashAccounts;
	}

}
