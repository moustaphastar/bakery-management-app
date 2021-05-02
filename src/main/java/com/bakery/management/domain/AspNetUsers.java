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
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(schema = "public",
        uniqueConstraints =
        @UniqueConstraint(columnNames = "NormalizedUserName"))
public class AspNetUsers implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private UUID id;

    /***
     * Name of user.
     */
    @Column(nullable = false)
    private String userName;

    /***
     * Name of user, all letters in uppercase.
     */
    @Column(unique = true)
    private String normalizedUserName;

    /***
     * Email address.
     */
    @Column(nullable = false)
    private String email;

    /***
     * Email address, all characters in uppercase.
     */
    @Column(nullable = false)
    private String normalizedEmail;

    /***
     * State of email confirmation.
     */
    @Column(nullable = false)
    private boolean emailConfirmed;

    /***
     * Password hash string.
     */
    @Column(nullable = false)
    private String passwordHash;

    /***
     * Timestamp for a security check.
     */
    @Column(nullable = false)
    private String securityStamp;

    /***
     * Timestamp to avoid concurrency in database.
     */
    @Column(nullable = false)
    private String concurrencyStamp;

    /***
     * Phone number with country and area codes.
     */
    @Column(nullable = false)
    private String phoneNumber;

    /***
     * State of phone number confirmation.
     */
    @Column(nullable = false)
    private boolean phoneNumberConfirmed;

    /***
     * State of 2FA availability.
     */
    @Column(nullable = false)
    private boolean twoFactorEnabled;

    /***
     * End of lock out.
     */
    // todo: Enhance Javadoc. What is lock end for?
    @Column(nullable = false)
    private String lockoutEnd;

    /***
     * State of lock out availability.
     */
    @Column(nullable = false)
    private boolean lockoutEnabled;

    /***
     * Count of failed access attempt.
     */
    @Column(nullable = false)
    private int accessFailedCount;

    /***
     * Set of child {@link AspNetUserLogins} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetUsers")
    private Set<AspNetUserLogins> aspNetUserLogins = new HashSet<>(0);

    /***
     * Set of child {@link AspNetUserClaims} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetUsers")
    private Set<AspNetUserClaims> aspNetUserClaims = new HashSet<>(0);

    /***
     * Set of child {@link AspNetRoles} with many to many relation.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AspNetUserRoles",
            joinColumns = {
                    @JoinColumn(
                            name = "UserId",
                            nullable = false,
                            updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "RoleId",
                            nullable = false,
                            updatable = false)})
    private Set<AspNetRoles> aspNetRoles = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public AspNetUsers() {
    }

}
