package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "CashAccount", schema = "dbo", catalog = "onlineaccounting")
public class CashAccount implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private int id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MerchantId", nullable = false)
	private Merchant merchant;

	@Column(name = "MerchantId", nullable = false, updatable = false, insertable = false)
	private UUID merchantId;

	@Column(name = "FiscalYear", nullable = false)
	private int fiscalYear;

	@Column(name = "TotalReceived", nullable = false, precision = 9)
	private BigDecimal totalReceived;

	@Column(name = "TotalPaid", nullable = false, precision = 9)
	private BigDecimal totalPaid;

	@Column(name = "OutstandingBalance", nullable = false, precision = 9)
	private BigDecimal outstandingBalance;

	@Column(name = "Balance", precision = 11)
	private BigDecimal balance;

	@Column(name = "RegularInvoiceLimit", nullable = false, precision = 9)
	private BigDecimal regularInvoiceLimit;

	@Column(name = "LastUpdate", nullable = false, length = 19)
	private OffsetDateTime lastUpdate;

	@Column(name = "Active", nullable = false)
	private boolean active;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cashAccount")
	private Set<CashTransaction> cashTransactions = new HashSet<>(0);

	public CashAccount() {
	}

}
