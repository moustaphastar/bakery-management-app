package com.bakery.management.domain;

import javax.persistence.*;

@Entity
@Table(name = "AspNetUserClaims", schema = "dbo", catalog = "bakery")
public class AspNetUserClaims implements java.io.Serializable {

	private int id;
	private AspNetUsers aspNetUsers;
	private String claimType;
	private String claimValue;

	public AspNetUserClaims() {
	}

	public AspNetUserClaims(int id, AspNetUsers aspNetUsers) {
		this.id = id;
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUserClaims(int id, AspNetUsers aspNetUsers, String claimType, String claimValue) {
		this.id = id;
		this.aspNetUsers = aspNetUsers;
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
	@JoinColumn(name = "UserId", nullable = false)
	public AspNetUsers getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(AspNetUsers aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
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
