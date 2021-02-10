package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/***
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "District", schema = "dbo", catalog = "onlineaccounting")
public class District implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link City} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CityId", nullable = false)
    private City city;

    /***
     * Foreign key to parent {@link City} entity Id.
     */
    @Column(name = "CityId", nullable = false, updatable = false,
            insertable = false)
    private int cityId;

    /***
     * Name of district.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /***
     * Set of child {@link Address} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
    private Set<Address> addresses = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public District() {
    }

}
