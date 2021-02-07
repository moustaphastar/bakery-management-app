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
@Table(name = "City", schema = "dbo", catalog = "onlineaccounting")
public class City implements java.io.Serializable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CountryId", nullable = false)
    private Country country;

    @Column(name = "CountryId", nullable = false, updatable = false, insertable = false)
    private int countryId;

    @Column(name = "Name", nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private Set<District> districts = new HashSet<>(0);

    public City() {
    }

}
