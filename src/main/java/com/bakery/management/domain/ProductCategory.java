package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ProductCategory", schema = "dbo", catalog = "onlineaccounting")
public class ProductCategory implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantTypeId")
    private MerchantType merchantType;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productCategory")
    private Set<Product> products = new HashSet<>(0);

    public ProductCategory() {
    }

}
