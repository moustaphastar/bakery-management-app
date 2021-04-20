package com.bakery.management.domain;

import javax.persistence.*;

@Entity
@Table(name = "AspNetRoleClaims", schema = "public", catalog = "bakery")
public class AspNetRoleClaims implements java.io.Serializable {

	private int id;
	private AspNetRoles aspNetRoles;
	private String claimType;
	private String claimValue;

	public AspNetRoleClaims() {
	}

	public AspNetRoleClaims(int id, AspNetRoles aspNetRoles) {
		this.id = id;
		this.aspNetRoles = aspNetRoles;
	}

	public AspNetRoleClaims(int id, AspNetRoles aspNetRoles, String claimType, String claimValue) {
		this.id = id;
		this.aspNetRoles = aspNetRoles;
		this.claimType = claimType;
		this.claimValue = claimValue;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RoleId", nullable = false)
	public AspNetRoles getAspNetRoles() {
		return this.aspNetRoles;
	}

	public void setAspNetRoles(AspNetRoles aspNetRoles) {
		this.aspNetRoles = aspNetRoles;
	}

	@Column(name = "ClaimType")
	public String getClaimType() {
		return this.claimType;
	}

	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}

	@Column(name = "ClaimValue")
	public String getClaimValue() {
		return this.claimValue;
	}

	public void setClaimValue(String claimValue) {
		this.claimValue = claimValue;
	}

}
