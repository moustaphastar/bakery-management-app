package com.bakery.management.domain;

import com.bakery.management.enums.DebitStatus;
import com.bakery.management.enums.converters.DebitStatusConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "CustomerDebit", schema = "dbo", catalog = "onlineaccounting")
public class CustomerDebit implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    @Column(name = "CustomerId", nullable = false, updatable = false, insertable = false)
    private UUID customerId;

    @Column(name = "SaleId") // TODO: Is this mapped to Order entity?
    private UUID saleId;

    @Column(name = "DueDate", nullable = false, length = 10)
    private LocalDate dueDate;

    @Column(name = "TotalDue", nullable = false, precision = 9)
    private BigDecimal totalDue;

    @Convert(converter = DebitStatusConverter.class)
    @Column(name = "Status", nullable = false, length = 1)
    private DebitStatus status;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerDebit")
    private Set<CustomerPayment> customerPayments = new HashSet<>(0);

    public CustomerDebit() {
    }

}
