package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/***
 * Domain model class to hold user login id data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "AspNetUserTokens", schema = "public")
public class AspNetUserTokens implements java.io.Serializable {

    /***
     * Id of the entity. Embedded from {@link AspNetUserTokensId} entity.
     */
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "userId",
                    column = @Column(name = "UserId", nullable = false)),
            @AttributeOverride(name = "loginProvider",
                    column = @Column(name = "LoginProvider",
                            nullable = false)),
            @AttributeOverride(name = "name",
                    column = @Column(name = "Name", nullable = false)),
            @AttributeOverride(name = "value",
                    column = @Column(name = "Value"))})
    private AspNetUserTokensId id;

    /***
     * Class constructor.
     */
    public AspNetUserTokens() {
    }

}
