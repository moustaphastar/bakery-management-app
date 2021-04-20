package com.bakery.management.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AspNetUserLoginsId implements java.io.Serializable {

	private String loginProvider;
	private String providerKey;

	public AspNetUserLoginsId() {
	}

	public AspNetUserLoginsId(String loginProvider, String providerKey) {
		this.loginProvider = loginProvider;
		this.providerKey = providerKey;
	}

	@Column(name = "LoginProvider", nullable = false)
	public String getLoginProvider() {
		return this.loginProvider;
	}

	public void setLoginProvider(String loginProvider) {
		this.loginProvider = loginProvider;
	}

	@Column(name = "ProviderKey", nullable = false)
	public String getProviderKey() {
		return this.providerKey;
	}

	public void setProviderKey(String providerKey) {
		this.providerKey = providerKey;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AspNetUserLoginsId))
			return false;
		AspNetUserLoginsId castOther = (AspNetUserLoginsId) other;

		return ((this.getLoginProvider() == castOther.getLoginProvider())
				|| (this.getLoginProvider() != null && castOther.getLoginProvider() != null
						&& this.getLoginProvider().equals(castOther.getLoginProvider())))
				&& ((this.getProviderKey() == castOther.getProviderKey())
						|| (this.getProviderKey() != null && castOther.getProviderKey() != null
								&& this.getProviderKey().equals(castOther.getProviderKey())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getLoginProvider() == null ? 0 : this.getLoginProvider().hashCode());
		result = 37 * result + (getProviderKey() == null ? 0 : this.getProviderKey().hashCode());
		return result;
	}

}
