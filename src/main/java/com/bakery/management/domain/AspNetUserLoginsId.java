package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class AspNetUserLoginsId implements java.io.Serializable {

    @Column(name = "LoginProvider", nullable = false)
    private String loginProvider;

    @Column(name = "ProviderKey", nullable = false)
    private String providerKey;

    public AspNetUserLoginsId() {
    }

}
