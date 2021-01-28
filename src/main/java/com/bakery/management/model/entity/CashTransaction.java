package com.bakery.management.model.entity;

import com.bakery.management.enums.CashTransactionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CashTransaction", schema = "dbo", catalog = "bakery")
public class CashTransaction implements java.io.Serializable {

	private int id;
	private CashAccount cashAccount;
	private Date transactionDate;
	private CashTransactionType transactionType;
	private BigDecimal transactionAmount;
	private String explanation;
	private Date lastUpdate;
	private boolean active;

	public CashTransaction() {
	}

	public CashTransaction(int id, CashAccount cashAccount, Date transactionDate, CashTransactionType transactionType,
						   BigDecimal transactionAmount, String explanation, Date lastUpdate, boolean active) {
		this.id = id;
		this.cashAccount = cashAccount;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.explanation = explanation;
		this.lastUpdate = lastUpdate;
		this.active = active;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CashAccountId", nullable = false)
	public CashAccount getCashAccount() {
		return this.cashAccount;
	}

	public void setCashAccount(CashAccount cashAccount) {
		this.cashAccount = cashAccount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TransactionDate", nullable = false, length = 19)
	public Date getTransactionDate() {
		return this.transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	//@Convert(converter = CashTransactionTypeConverter.class)
	@Column(name = "TransactionType", nullable = false, length = 1, columnDefinition = "char(1)")
	public CashTransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(CashTransactionType transactionType) {
		this.transactionType = transactionType;
	}

	@Column(name = "TransactionAmount", nullable = false, precision = 9)
	public BigDecimal getTransactionAmount() {
		return this.transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Column(name = "Explanation", nullable = false)
	public String getExplanation() {
		return this.explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
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

}
