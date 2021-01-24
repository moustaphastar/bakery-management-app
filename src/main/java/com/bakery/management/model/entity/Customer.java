package com.bakery.management.model.entity;
// Generated 19 Ara 2020 06:35:03 by Hibernate Tools 5.2.12.Final

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "Customer", schema = "dbo", catalog = "onlineaccounting")
public class Customer implements java.io.Serializable {

	private String id;
	private CustomerType customerType;
	private Merchant merchant;
	private String taxOffice;
	private String taxpayerId;
	private String nationalIdNumber;
	private String iban;
	private String name;
	private BigDecimal debtTotal;
	private BigDecimal debtLimit;
	private byte debtLimitExceedCount;
	private byte maturityDaysTotal;
	private byte maturityDaysLimit;
	private byte maturityOverdueCount;
	private String liasonPerson;
	private String liasonPhone;
	private String aspNetUserId;
	private boolean active;
	private Date engagedOn;
	private Date lastUpdate;
	private Set<CustomerDebit> customerDebits = new HashSet<>(0);
	private Set<CustomerPayment> customerPayments = new HashSet<>(0);
	private Set<CustomerDiscount> customerDiscounts = new HashSet<>(0);
	private Set<Sale> sales = new HashSet<>(0);
	private Set<VehicleDriverCustomer> vehicleDriverCustomers = new HashSet<>(0);
	private Set<CustomerAddress> customerAddresses = new HashSet<>(0);

	public Customer() {
	}

	public Customer(String id, CustomerType customerType, Merchant merchant, String taxOffice,
					String taxpayerId, String name, BigDecimal debtTotal, BigDecimal debtLimit,
					byte debtLimitExceedCount, byte maturityDaysTotal, byte maturityDaysLimit, byte maturityOverdueCount,
					boolean active, Date engagedOn, Date lastUpdate) {
		this.id = id;
		this.customerType = customerType;
		this.merchant = merchant;
		this.taxOffice = taxOffice;
		this.taxpayerId = taxpayerId;
		this.name = name;
		this.debtTotal = debtTotal;
		this.debtLimit = debtLimit;
		this.debtLimitExceedCount = debtLimitExceedCount;
		this.maturityDaysTotal = maturityDaysTotal;
		this.maturityDaysLimit = maturityDaysLimit;
		this.maturityOverdueCount = maturityOverdueCount;
		this.active = active;
		this.engagedOn = engagedOn;
		this.lastUpdate = lastUpdate;
	}

	public Customer(String id, CustomerType customerType, Merchant merchant, String taxOffice,
					String taxpayerId, String nationalIdNumber, String iban, String name,
					BigDecimal debtTotal, BigDecimal debtLimit, byte debtLimitExceedCount, byte maturityDaysTotal,
					byte maturityDaysLimit, byte maturityOverdueCount, String liasonPerson, String liasonPhone,
					String aspNetUserId, boolean active, Date engagedOn, Date lastUpdate, Set<CustomerDebit> customerDebits,
					Set<CustomerPayment> customerPayments, Set<CustomerDiscount> customerDiscounts, Set<Sale> sales, Set<VehicleDriverCustomer> vehicleDriverCustomers, Set customerAddresses) {
		this.id = id;
		this.customerType = customerType;
		this.merchant = merchant;
		this.taxOffice = taxOffice;
		this.taxpayerId = taxpayerId;
		this.nationalIdNumber = nationalIdNumber;
		this.iban = iban;
		this.name = name;
		this.debtTotal = debtTotal;
		this.debtLimit = debtLimit;
		this.debtLimitExceedCount = debtLimitExceedCount;
		this.maturityDaysTotal = maturityDaysTotal;
		this.maturityDaysLimit = maturityDaysLimit;
		this.maturityOverdueCount = maturityOverdueCount;
		this.liasonPerson = liasonPerson;
		this.liasonPhone = liasonPhone;
		this.aspNetUserId = aspNetUserId;
		this.active = active;
		this.engagedOn = engagedOn;
		this.lastUpdate = lastUpdate;
		this.customerDebits = customerDebits;
		this.customerPayments = customerPayments;
		this.customerDiscounts = customerDiscounts;
		this.sales = sales;
		this.vehicleDriverCustomers = vehicleDriverCustomers;
		this.customerAddresses = customerAddresses;
	}

	@Id

	@Column(name = "Id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TypeId", nullable = false)
	public CustomerType getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MerchantId", nullable = false)
	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Column(name = "TaxOffice", nullable = false)
	public String getTaxOffice() {
		return this.taxOffice;
	}

	public void setTaxOffice(String taxOffice) {
		this.taxOffice = taxOffice;
	}

	@Column(name = "TaxpayerId", nullable = false)
	public String getTaxpayerId() {
		return this.taxpayerId;
	}

	public void setTaxpayerId(String taxpayerId) {
		this.taxpayerId = taxpayerId;
	}

	@Column(name = "NationalIdNumber", length = 11)
	public String getNationalIdNumber() {
		return this.nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	@Column(name = "IBAN")
	public String getIban() {
		return this.iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DebtTotal", nullable = false, precision = 9)
	public BigDecimal getDebtTotal() {
		return this.debtTotal;
	}

	public void setDebtTotal(BigDecimal debtTotal) {
		this.debtTotal = debtTotal;
	}

	@Column(name = "DebtLimit", nullable = false, precision = 9)
	public BigDecimal getDebtLimit() {
		return this.debtLimit;
	}

	public void setDebtLimit(BigDecimal debtLimit) {
		this.debtLimit = debtLimit;
	}

	@Column(name = "DebtLimitExceedCount", nullable = false)
	public byte getDebtLimitExceedCount() {
		return this.debtLimitExceedCount;
	}

	public void setDebtLimitExceedCount(byte debtLimitExceedCount) {
		this.debtLimitExceedCount = debtLimitExceedCount;
	}

	@Column(name = "MaturityDaysTotal", nullable = false)
	public byte getMaturityDaysTotal() {
		return this.maturityDaysTotal;
	}

	public void setMaturityDaysTotal(byte maturityDaysTotal) {
		this.maturityDaysTotal = maturityDaysTotal;
	}

	@Column(name = "MaturityDaysLimit", nullable = false)
	public byte getMaturityDaysLimit() {
		return this.maturityDaysLimit;
	}

	public void setMaturityDaysLimit(byte maturityDaysLimit) {
		this.maturityDaysLimit = maturityDaysLimit;
	}

	@Column(name = "MaturityOverdueCount", nullable = false)
	public byte getMaturityOverdueCount() {
		return this.maturityOverdueCount;
	}

	public void setMaturityOverdueCount(byte maturityOverdueCount) {
		this.maturityOverdueCount = maturityOverdueCount;
	}

	@Column(name = "LiasonPerson")
	public String getLiasonPerson() {
		return this.liasonPerson;
	}

	public void setLiasonPerson(String liasonPerson) {
		this.liasonPerson = liasonPerson;
	}

	@Column(name = "LiasonPhone")
	public String getLiasonPhone() {
		return this.liasonPhone;
	}

	public void setLiasonPhone(String liasonPhone) {
		this.liasonPhone = liasonPhone;
	}

	@Column(name = "AspNetUserId")
	public String getAspNetUserId() {
		return this.aspNetUserId;
	}

	public void setAspNetUserId(String aspNetUserId) {
		this.aspNetUserId = aspNetUserId;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
	@Column(name = "LastUpdate", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<CustomerDebit> getCustomerDebits() {
		return this.customerDebits;
	}

	public void setCustomerDebits(Set<CustomerDebit> customerDebits) {
		this.customerDebits = customerDebits;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<CustomerPayment> getCustomerPayments() {
		return this.customerPayments;
	}

	public void setCustomerPayments(Set<CustomerPayment> customerPayments) {
		this.customerPayments = customerPayments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<CustomerDiscount> getCustomerDiscounts() {
		return this.customerDiscounts;
	}

	public void setCustomerDiscounts(Set<CustomerDiscount> customerDiscounts) {
		this.customerDiscounts = customerDiscounts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Sale> getSales() {
		return this.sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<VehicleDriverCustomer> getVehicleDriverCustomers() {
		return this.vehicleDriverCustomers;
	}

	public void setVehicleDriverCustomers(Set<VehicleDriverCustomer> vehicleDriverCustomers) {
		this.vehicleDriverCustomers = vehicleDriverCustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<CustomerAddress> getCustomerAddresses() {
		return this.customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

}