package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/***
 * Domain model class to hold roles data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(schema = "public",
        uniqueConstraints = @UniqueConstraint(columnNames = "NormalizedName"))
public class AspNetRoles implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private UUID id;

    /***
     * Name of the role.
     */
    @Column(name = "Name")
    private String name;

    /***
     * Name of the role, all letters in uppercase.
     */
    @Column(unique = true)
    private String normalizedName;

    /***
     * Timestamp to avoid concurrency in database.
     */
    @Column(name = "ConcurrencyStamp")
    private String concurrencyStamp;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
    @Generated(value = GenerationTime.INSERT)
    private OffsetDateTime insertedDate;

    /***
     * Set of child {@link AspNetRoleClaims} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetRoles")
    private Set<AspNetRoleClaims> aspNetRoleClaims = new HashSet<>(0);

    /***
     * Set of child {@link AspNetUsers} with many to many relation.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AspNetUserRoles",
            joinColumns = {@JoinColumn(name = "RoleId",
                    nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "UserId",
                    nullable = false, updatable = false)})
    private Set<AspNetUsers> aspNetUsers = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public AspNetRoles() {
    }

}
