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
@Table(name = "MerchantType", schema = "dbo", catalog = "onlineaccounting")
public class MerchantType implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchantType")
    private Set<ProductCategory> productCategories = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchantType")
    private Set<Merchant> merchants = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "merchantType")
    private Set<ProductProperty> productProperties = new HashSet<>(0);

    public MerchantType() {
    }

}
