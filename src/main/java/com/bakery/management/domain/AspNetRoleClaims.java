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
import javax.persistence.Table;

/***
 * Domain model class to hold claim data for related {@link AspNetRoles}.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "AspNetRoleClaims", schema = "dbo", catalog = "onlineaccounting")
public class AspNetRoleClaims implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link AspNetRoles} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleId", nullable = false)
    private AspNetRoles aspNetRoles;

    /***
     * Foreign key to parent {@link AspNetRoles} entity Id.
     */
    @Column(name = "RoleId", nullable = false, updatable = false,
            insertable = false)
    private int roleId;

    /***
     * Claim type name to be associated with an {@link AspNetRoles}.
     * i.e. Email, Sid, Role.
     */
    @Column(name = "ClaimType")
    private String claimType;

    /***
     * Value of an associated {@link #claimType}.
     */
    @Column(name = "ClaimValue")
    private String claimValue;

    /***
     * Class constructor.
     */
    public AspNetRoleClaims() {
    }

}
