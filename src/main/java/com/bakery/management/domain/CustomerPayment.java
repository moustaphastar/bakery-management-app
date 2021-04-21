package com.bakery.management.domain;

import com.bakery.management.enums.PaymentStatus;
import com.bakery.management.enums.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CustomerPayment", schema = "public")
public class CustomerPayment implements java.io.Serializable {

	private int id;
	private Customer customer;
	private CustomerDebit customerDebit;
	private BigDecimal amountPaid;
	private Date paymentDate;
	private PaymentType paymentType;
	private PaymentStatus approvalStatus;
	private Date lastUpdate;
	private boolean active;

	public CustomerPayment() {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerDebitId", nullable = false)
	public CustomerDebit getCustomerDebit() {
		return this.customerDebit;
	}

	public void setCustomerDebit(CustomerDebit customerDebit) {
		this.customerDebit = customerDebit;
	}

	@Column(name = "AmountPaid", nullable = false, precision = 9)
	public BigDecimal getAmountPaid() {
		return this.amountPaid;
	}

	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PaymentDate", nullable = false, length = 19)
	public Date getPaymentDate() {
		return this.paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	//@Convert(converter = PaymentTypeConverter.class)
	@Column(name = "PaymentType", nullable = false, length = 1)
	public PaymentType getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	//@Convert(converter = PaymentStatusConverter.class)
	@Column(name = "ApprovalStatus", nullable = false, length = 1)
	public PaymentStatus getApprovalStatus() {
		return this.approvalStatus;
	}

	public void setApprovalStatus(PaymentStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
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
