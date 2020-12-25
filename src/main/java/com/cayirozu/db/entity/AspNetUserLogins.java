package com.cayirozu.db.entity;
// Generated 19 Ara 2020 06:35:03 by Hibernate Tools 5.2.12.Final

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AspNetUserLogins generated by hbm2java
 */
@Entity
@Table(name = "AspNetUserLogins", schema = "dbo", catalog = "onlineaccounting")
public class AspNetUserLogins implements java.io.Serializable {

	private AspNetUserLoginsId id;
	private AspNetUsers aspNetUsers;
	private Serializable providerDisplayName;

	public AspNetUserLogins() {
	}

	public AspNetUserLogins(AspNetUserLoginsId id, AspNetUsers aspNetUsers) {
		this.id = id;
		this.aspNetUsers = aspNetUsers;
	}

	public AspNetUserLogins(AspNetUserLoginsId id, AspNetUsers aspNetUsers, Serializable providerDisplayName) {
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
	public Serializable getProviderDisplayName() {
		return this.providerDisplayName;
	}

	public void setProviderDisplayName(Serializable providerDisplayName) {
		this.providerDisplayName = providerDisplayName;
	}

}
