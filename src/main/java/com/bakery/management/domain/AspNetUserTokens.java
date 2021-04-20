package com.bakery.management.domain;

import javax.persistence.*;

@Entity
@Table(name = "AspNetUserTokens", schema = "public", catalog = "bakery")
public class AspNetUserTokens implements java.io.Serializable {

	private AspNetUserTokensId id;

	public AspNetUserTokens() {
	}

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "userId", column = @Column(name = "UserId", nullable = false)),
			@AttributeOverride(name = "loginProvider", column = @Column(name = "LoginProvider", nullable = false)),
			@AttributeOverride(name = "name", column = @Column(name = "Name", nullable = false)),
			@AttributeOverride(name = "value", column = @Column(name = "Value")) })
	public AspNetUserTokensId getId() {
		return this.id;
	}

	public void setId(AspNetUserTokensId id) {
		this.id = id;
	}

}
