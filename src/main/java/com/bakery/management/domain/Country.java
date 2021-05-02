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
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/***
 * Domain model class to hold country data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode(exclude = {"cities"})
@Entity
@Table(schema = "public")
public class Country implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    /***
     * ISO 3166-1 alpha-2 codes.
     */
    @Column(nullable = false, length = 2)
    private String iso2;

    /***
     * ISO 3166-1 alpha-3 codes.
     */
    @Column(length = 3)
    private String iso3;

    /***
     * Name of country.
     */
    @Column(nullable = false)
    private String name;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
    private OffsetDateTime insertedDate;

    /***
     * Application user id who committed the insert.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID insertedBy;

    /***
     * Date and time of last update with an offset.
     */
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    /***
     * Application user id who committed the last update.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID lastUpdatedBy;

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
