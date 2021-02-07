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
@Table(name = "AspNetUsers", schema = "dbo", catalog = "onlineaccounting",
        uniqueConstraints = @UniqueConstraint(columnNames = "NormalizedUserName"))
public class AspNetUsers implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false)
    private UUID id;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "NormalizedUserName", unique = true)
    private String normalizedUserName;

    @Column(name = "Email")
    private String email;

    @Column(name = "NormalizedEmail")
    private String normalizedEmail;

    @Column(name = "EmailConfirmed", nullable = false)
    private boolean emailConfirmed;

    @Column(name = "PasswordHash")
    private String passwordHash;

    @Column(name = "SecurityStamp")
    private String securityStamp;

    @Column(name = "ConcurrencyStamp")
    private String concurrencyStamp;

    @Column(name = "PhoneNumber")
    private String phoneNumber;

    @Column(name = "PhoneNumberConfirmed", nullable = false)
    private boolean phoneNumberConfirmed;

    @Column(name = "TwoFactorEnabled", nullable = false)
    private boolean twoFactorEnabled;

    @Column(name = "LockoutEnd")
    private String lockoutEnd;

    @Column(name = "LockoutEnabled", nullable = false)
    private boolean lockoutEnabled;

    @Column(name = "AccessFailedCount", nullable = false)
    private int accessFailedCount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetUsers")
    private Set<AspNetUserLogins> aspNetUserLogins = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetUsers")
    private Set<AspNetUserClaims> aspNetUserClaims = new HashSet<>(0);

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AspNetUserRoles", schema = "dbo", catalog = "onlineaccounting", joinColumns = {
            @JoinColumn(name = "UserId", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "RoleId", nullable = false, updatable = false)})
    private Set<AspNetRoles> aspNetRoles = new HashSet<>(0);

    public AspNetUsers() {
    }

}
