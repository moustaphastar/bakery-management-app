package com.bakery.management.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "AspNetRoles", schema = "dbo", catalog = "bakery", uniqueConstraints = @UniqueConstraint(columnNames = "NormalizedName"))
public class AspNetRoles implements java.io.Serializable {

	private UUID id;
	private String name;
	private String normalizedName;
	private String concurrencyStamp;
	private Set<AspNetRoleClaims> aspNetRoleClaims = new HashSet<>(0);
	private Set<AspNetUsers> aspNetUsers = new HashSet<>(0);

	public AspNetRoles() {
	}

	public AspNetRoles(UUID id) {
		this.id = id;
	}

	public AspNetRoles(UUID id, String name, String normalizedName, String concurrencyStamp,
					   Set<AspNetRoleClaims> aspNetRoleClaims, Set<AspNetUsers> aspNetUsers) {
		this.id = id;
		this.name = name;
		this.normalizedName = normalizedName;
		this.concurrencyStamp = concurrencyStamp;
		this.aspNetRoleClaims = aspNetRoleClaims;
		this.aspNetUsers = aspNetUsers;
	}

	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Column(name = "Name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NormalizedName", unique = true)
	public String getNormalizedName() {
		return this.normalizedName;
	}

	public void setNormalizedName(String normalizedName) {
		this.normalizedName = normalizedName;
	}

	@Column(name = "ConcurrencyStamp")
	public String getConcurrencyStamp() {
		return this.concurrencyStamp;
	}

	public void setConcurrencyStamp(String concurrencyStamp) {
		this.concurrencyStamp = concurrencyStamp;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetRoles")
	public Set<AspNetRoleClaims> getAspNetRoleClaims() {
		return this.aspNetRoleClaims;
	}

	public void setAspNetRoleClaims(Set<AspNetRoleClaims> aspNetRoleClaims) {
		this.aspNetRoleClaims = aspNetRoleClaims;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "AspNetUserRoles", schema = "dbo", catalog = "bakery", joinColumns = {
			@JoinColumn(name = "RoleId", nullable = false, updatable = false)}, inverseJoinColumns = {
			@JoinColumn(name = "UserId", nullable = false, updatable = false)})
	public Set<AspNetUsers> getAspNetUsers() {
		return this.aspNetUsers;
	}

	public void setAspNetUsers(Set<AspNetUsers> aspNetUsers) {
		this.aspNetUsers = aspNetUsers;
	}

}
