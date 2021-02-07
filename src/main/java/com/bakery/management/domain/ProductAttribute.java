package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ProductAttribute", schema = "dbo", catalog = "onlineaccounting")
public class ProductAttribute implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductId", nullable = false)
    private Product product;

    @Column(name = "ProductId", nullable = false, updatable = false, insertable = false)
    private UUID productId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductPropertyId", nullable = false)
    private ProductProperty productProperty;

    @Column(name = "ProductPropertyId", nullable = false, updatable = false, insertable = false)
    private int productPropertyId;

    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    @Column(name = "Active", nullable = false)
    private boolean active;

    public ProductAttribute() {
    }

}
