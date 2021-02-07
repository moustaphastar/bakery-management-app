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
public class AspNetUserTokensId implements java.io.Serializable {

    @Column(name = "UserId", nullable = false)
    private String userId;

    @Column(name = "LoginProvider", nullable = false)
    private String loginProvider;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Value")
    private String value;

    public AspNetUserTokensId() {
    }

}
