package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/***
 * Domain model class to hold embeddable Id data for {@link AspNetUserLogins}.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class AspNetUserLoginsId implements java.io.Serializable {

    /***
     * Name of login provider.
     */
    @Column(name = "LoginProvider", nullable = false)
    private String loginProvider;

    /***
     * A key to identify login provider.
     */
    @Column(name = "ProviderKey", nullable = false)
    private String providerKey;

    /***
     * Class constructor.
     */
    public AspNetUserLoginsId() {
    }

}
