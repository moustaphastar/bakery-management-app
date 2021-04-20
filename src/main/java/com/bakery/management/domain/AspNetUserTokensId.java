package com.bakery.management.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AspNetUserTokensId implements java.io.Serializable {

	private String userId;
	private String loginProvider;
	private String name;
	private String value;

	public AspNetUserTokensId() {
	}

	@Column(name = "UserId", nullable = false)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "LoginProvider", nullable = false)
	public String getLoginProvider() {
		return this.loginProvider;
	}

	public void setLoginProvider(String loginProvider) {
		this.loginProvider = loginProvider;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Value")
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AspNetUserTokensId))
			return false;
		AspNetUserTokensId castOther = (AspNetUserTokensId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this.getUserId() != null
				&& castOther.getUserId() != null && this.getUserId().equals(castOther.getUserId())))
				&& ((this.getLoginProvider() == castOther.getLoginProvider())
						|| (this.getLoginProvider() != null && castOther.getLoginProvider() != null
								&& this.getLoginProvider().equals(castOther.getLoginProvider())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null
						&& this.getName().equals(castOther.getName())))
				&& ((this.getValue() == castOther.getValue()) || (this.getValue() != null
						&& castOther.getValue() != null && this.getValue().equals(castOther.getValue())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result + (getLoginProvider() == null ? 0 : this.getLoginProvider().hashCode());
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result + (getValue() == null ? 0 : this.getValue().hashCode());
		return result;
	}

}
