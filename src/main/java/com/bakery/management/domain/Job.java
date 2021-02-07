package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Job", schema = "dbo", catalog = "onlineaccounting")
public class Job implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    @Column(name = "MerchantId", nullable = false, updatable = false, insertable = false)
    private UUID merchantId;

    @Column(name = "Title", nullable = false)
    private String title;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "job")
    private Set<Employee> employees = new HashSet<>(0);

    public Job() {
    }

}
