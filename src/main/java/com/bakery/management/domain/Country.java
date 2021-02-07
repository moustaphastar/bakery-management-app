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
@Table(name = "Country", schema = "dbo", catalog = "onlineaccounting")
public class Country implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @Column(name = "ISO2", nullable = false, length = 2)
    private String iso2;

    @Column(name = "ISO3", length = 3)
    private String iso3;

    @Column(name = "Name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Set<City> cities = new HashSet<>(0);

    public Country() {
    }

}
