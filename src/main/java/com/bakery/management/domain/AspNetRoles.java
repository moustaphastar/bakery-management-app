package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "AspNetRoles", schema = "dbo", catalog = "onlineaccounting",
        uniqueConstraints = @UniqueConstraint(columnNames = "NormalizedName"))
public class AspNetRoles implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "Name")
    private String name;

    @Column(name = "NormalizedName", unique = true)
    private String normalizedName;

    @Column(name = "ConcurrencyStamp")
    private String concurrencyStamp;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetRoles")
    private Set<AspNetRoleClaims> aspNetRoleClaims = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AspNetUserRoles", schema = "dbo", catalog = "onlineaccounting",
            joinColumns = {@JoinColumn(name = "RoleId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "UserId", nullable = false, updatable = false)})
    private Set<AspNetUsers> aspNetUsers = new HashSet<>(0);

    public AspNetRoles() {
    }

}
