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
    @Column(nullable = false)
    private String userId;

    /***
     * Provider name.
     */
    // todo: Enhance Javadoc. What is this related with?
    @Column(nullable = false)
    private String loginProvider;

    /***
     * Token name.
     */
    @Column(nullable = false)
    private String name;

    /***
     * Token value.
     */
    @Column(nullable = false)
    private String value;

    /***
     * Class constructor.
     */
    public AspNetUserTokensId() {
    }

}
