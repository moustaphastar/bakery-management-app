package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "AspNetRoleClaims", schema = "dbo", catalog = "onlineaccounting")
public class AspNetRoleClaims implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleId", nullable = false)
    private AspNetRoles aspNetRoles;

    @Column(name = "RoleId", nullable = false, updatable = false, insertable = false)
    private int RoleId;

    @Column(name = "ClaimType")
    private String claimType;

    @Column(name = "ClaimValue")
    private String claimValue;

    public AspNetRoleClaims() {
    }

}
