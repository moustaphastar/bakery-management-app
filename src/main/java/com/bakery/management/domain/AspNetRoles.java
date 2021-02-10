package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

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
@Table(name = "AspNetRoles", schema = "dbo", catalog = "onlineaccounting",
        uniqueConstraints = @UniqueConstraint(columnNames = "NormalizedName"))
public class AspNetRoles implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false)
    private UUID id;

    /***
     * Name of the role.
     */
    @Column(name = "Name")
    private String name;

    /***
     * Name of the role, all letters in uppercase.
     */
    @Column(name = "NormalizedName", unique = true)
    private String normalizedName;

    /***
     * Timestamp to avoid concurrency in database.
     */
    @Column(name = "ConcurrencyStamp")
    private String concurrencyStamp;

    /***
     * Set of child {@link AspNetRoleClaims} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetRoles")
    private Set<AspNetRoleClaims> aspNetRoleClaims = new HashSet<>(0);

    /***
     * Set of child {@link AspNetUsers} with many to many relation.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AspNetUserRoles", schema = "dbo",
            catalog = "onlineaccounting",
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
