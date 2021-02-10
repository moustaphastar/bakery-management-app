package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/***
 * Domain model class to hold embeddable Id data for {@link AspNetUserTokens}.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class AspNetUserTokensId implements java.io.Serializable {

    /***
     * Id of user.
     */
    @Column(name = "UserId", nullable = false)
    private String userId;

    /***
     * Provider name.
     */
    // todo: Enhance Javadoc. What is this related with?
    @Column(name = "LoginProvider", nullable = false)
    private String loginProvider;

    /***
     * Token name.
     */
    @Column(name = "Name", nullable = false)
    private String name;

    /***
     * Token value.
     */
    @Column(name = "Value")
    private String value;

    /***
     * Class constructor.
     */
    public AspNetUserTokensId() {
    }

}
