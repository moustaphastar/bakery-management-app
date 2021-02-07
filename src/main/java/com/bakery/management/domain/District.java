package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "District", schema = "dbo", catalog = "onlineaccounting")
public class District implements java.io.Serializable {

    @Id
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CityId", nullable = false)
    private City city;

    @Column(name = "CityId", nullable = false, updatable = false, insertable = false)
    private int cityId;

    @Column(name = "Name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
    private Set<Address> addresses = new HashSet<>(0);

    public District() {
    }

}
