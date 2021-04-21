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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/***
 * Domain model class to hold city data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "City", schema = "public")
public class City implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Country} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CountryId", nullable = false)
    private Country country;

    /***
     * Foreign key to parent {@link Country} entity Id.
     */
    @Column(name = "CountryId", nullable = false, updatable = false,
            insertable = false)
    private int countryId;

    /***
     * Name of city.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /***
     * Set of child {@link District} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    private Set<District> districts = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public City() {
    }

}
