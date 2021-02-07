package com.bakery.management.domain;

import com.bakery.management.enums.VehicleServiceType;
import com.bakery.management.enums.converters.VehicleServiceTypeConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Vehicle", schema = "dbo", catalog = "onlineaccounting")
public class Vehicle implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    @Column(name = "MerchantId", nullable = false, updatable = false, insertable = false)
    private UUID merchantId;

    @Column(name = "PlateNumber", nullable = false, length = 15)
    private String plateNumber;

    @Column(name = "AssesmentDate", nullable = false, length = 10)
    private LocalDate assessmentDate;

    @Column(name = "AssuranceRenewalDate", length = 10)
    private LocalDate assuranceRenewalDate;

    @Column(name = "OutOfOrderFlag", nullable = false)
    private boolean outOfOrderFlag;

    @Convert(converter = VehicleServiceTypeConverter.class)
    @Column(name = "ServiceType", length = 1)
    private VehicleServiceType serviceType;

    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
    private Set<Driver> drivers = new HashSet<>(0);

    public Vehicle() {
    }

}
