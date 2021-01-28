package com.bakery.management.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "AspNetUserLogins", schema = "dbo", catalog = "bakery")
public class AspNetUserLogins implements java.io.Serializable {

	private AspNetUserLoginsId id;
	private AspNetUsers aspNetUsers;
	private String providerDisplayName;

	public AspNetUserLogins() {
	}

	public AspNetUserLogins(AspNetUserLoginsId id, AspNetUsers aspNetUsers) {
		this.id = id;
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUserLogins(AspNetUserLoginsId id, AspNetUsers aspNetUsers, String providerDisplayName) {
		this.id = id;
		this.aspNetUsers = aspNetUsers;
		this.providerDisplayName = providerDisplayName;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "loginProvider", column = @Column(name = "LoginProvider", nullable = false)),
			@AttributeOverride(name = "providerKey", column = @Column(name = "ProviderKey", nullable = false)) })
	public AspNetUserLoginsId getId() {
		return this.id;
	}

	public void setId(AspNetUserLoginsId id) {
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

	@Column(name = "ProviderDisplayName")
	public String getProviderDisplayName() {
		return this.providerDisplayName;
	}

	public void setProviderDisplayName(String providerDisplayName) {
		this.providerDisplayName = providerDisplayName;
	}

}
