package com.bakery.management.domain;

import com.bakery.management.enums.AddressType;
import com.bakery.management.enums.converters.AddressTypeConverter;
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
@Table(name = "MerchantAddress", schema = "dbo", catalog = "onlineaccounting")
public class MerchantAddress implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AddressId", nullable = false)
    private Address address;

    @Column(name = "AddressId", nullable = false, updatable = false, insertable = false)
    private int addressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CompanyId", nullable = false)
    private Merchant merchant;

    @Column(name = "CompanyId", nullable = false, updatable = false, insertable = false)
    private UUID merchantId;

    @Convert(converter = AddressTypeConverter.class)
    @Column(name = "Description", nullable = false)
    private AddressType description;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    public MerchantAddress() {
    }

}
