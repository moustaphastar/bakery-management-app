package com.bakery.management.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CashAccount", schema = "public", catalog = "bakery")
public class CashAccount implements java.io.Serializable {

	private int id;
	private Merchant merchant;
	private int fiscalYear;
	private BigDecimal totalReceived;
	private BigDecimal totalPaid;
	private BigDecimal outstandingBalance;
	private BigDecimal balance;
	private BigDecimal regularInvoiceLimit;
	private Date lastUpdate;
	private boolean active;
	private Set<CashTransaction> cashTransactions = new HashSet<>(0);

	public CashAccount() {
	}

	public CashAccount(int id, Merchant merchant, int fiscalYear, BigDecimal totalReceived, BigDecimal totalPaid,
					   BigDecimal outstandingBalance, BigDecimal regularInvoiceLimit, Date lastUpdate, boolean active) {
		this.id = id;
		this.merchant = merchant;
		this.fiscalYear = fiscalYear;
		this.totalReceived = totalReceived;
		this.totalPaid = totalPaid;
		this.outstandingBalance = outstandingBalance;
		this.regularInvoiceLimit = regularInvoiceLimit;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public CashAccount(int id, Merchant merchant, int fiscalYear, BigDecimal totalReceived, BigDecimal totalPaid,
					   BigDecimal outstandingBalance, BigDecimal balance, BigDecimal regularInvoiceLimit, Date lastUpdate,
					   boolean active, Set<CashTransaction> cashTransactions) {
		this.id = id;
		this.merchant = merchant;
		this.fiscalYear = fiscalYear;
		this.totalReceived = totalReceived;
		this.totalPaid = totalPaid;
		this.outstandingBalance = outstandingBalance;
		this.balance = balance;
		this.regularInvoiceLimit = regularInvoiceLimit;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.cashTransactions = cashTransactions;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MerchantId", nullable = false)
	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Column(name = "FiscalYear", nullable = false)
	public int getFiscalYear() {
		return this.fiscalYear;
	}

	public void setFiscalYear(int fiscalYear) {
		this.fiscalYear = fiscalYear;
	}

	@Column(name = "TotalReceived", nullable = false, precision = 9)
	public BigDecimal getTotalReceived() {
		return this.totalReceived;
	}

	public void setTotalReceived(BigDecimal totalReceived) {
		this.totalReceived = totalReceived;
	}

	@Column(name = "TotalPaid", nullable = false, precision = 9)
	public BigDecimal getTotalPaid() {
		return this.totalPaid;
	}

	public void setTotalPaid(BigDecimal totalPaid) {
		this.totalPaid = totalPaid;
	}

	@Column(name = "OutstandingBalance", nullable = false, precision = 9)
	public BigDecimal getOutstandingBalance() {
		return this.outstandingBalance;
	}

	public void setOutstandingBalance(BigDecimal outstandingBalance) {
		this.outstandingBalance = outstandingBalance;
	}

	@Column(name = "Balance", precision = 11)
	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Column(name = "RegularInvoiceLimit", nullable = false, precision = 9)
	public BigDecimal getRegularInvoiceLimit() {
		return this.regularInvoiceLimit;
	}

	public void setRegularInvoiceLimit(BigDecimal regularInvoiceLimit) {
		this.regularInvoiceLimit = regularInvoiceLimit;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdate", nullable = false, length = 19)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cashAccount")
	public Set<CashTransaction> getCashTransactions() {
		return this.cashTransactions;
	}

	public void setCashTransactions(Set<CashTransaction> cashTransactions) {
		this.cashTransactions = cashTransactions;
	}

}
