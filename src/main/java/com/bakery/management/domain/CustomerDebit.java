package com.bakery.management.domain;

import com.bakery.management.enums.DebitStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CustomerDebit", schema = "public")
public class CustomerDebit implements java.io.Serializable {

	private int id;
	private Customer customer;
	private String saleId;
	private Date dueDate;
	private BigDecimal totalDue;
	private DebitStatus status;
	private boolean active;
	private Date lastUpdate;
	private Set<CustomerPayment> customerPayments = new HashSet<>(0);

	public CustomerDebit() {
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
	@JoinColumn(name = "CustomerId", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Column(name = "SaleId")
	public String getSaleId() {
		return this.saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DueDate", nullable = false, length = 10)
	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Column(name = "TotalDue", nullable = false, precision = 9)
	public BigDecimal getTotalDue() {
		return this.totalDue;
	}

	public void setTotalDue(BigDecimal totalDue) {
		this.totalDue = totalDue;
	}

	//@Convert(converter = DebitStatusConverter.class)
	@Column(name = "Status", nullable = false, length = 1)
	public DebitStatus getStatus() {
		return this.status;
	}

	public void setStatus(DebitStatus status) {
		this.status = status;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdate", nullable = false, length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerDebit")
	public Set<CustomerPayment> getCustomerPayments() {
		return this.customerPayments;
	}

	public void setCustomerPayments(Set<CustomerPayment> customerPayments) {
		this.customerPayments = customerPayments;
	}

}
