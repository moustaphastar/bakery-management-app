package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/***
 * Domain model class to hold country data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Country", schema = "dbo", catalog = "onlineaccounting")
public class Country implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * ISO 3166-1 alpha-2 codes.
     */
    @Column(name = "ISO2", nullable = false, length = 2)
    private String iso2;

    /***
     * ISO 3166-1 alpha-3 codes.
     */
    @Column(name = "ISO3", length = 3)
    private String iso3;

    /***
     * Name of country.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /***
     * Set of child {@link City} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
    private Set<City> cities = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Country() {
    }

}
