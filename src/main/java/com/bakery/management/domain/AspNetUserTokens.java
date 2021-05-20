package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/***
 * Domain model class to hold user login id data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(schema = "public")
public class AspNetUserTokens implements java.io.Serializable {

    /***
     * Id of the entity. Embedded from {@link AspNetUserTokensId} entity.
     */
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "userId",
                    column = @Column(nullable = false)),
            @AttributeOverride(name = "loginProvider",
                    column = @Column(name = "LoginProvider",
                            nullable = false)),
            @AttributeOverride(name = "name",
                    column = @Column(nullable = false)),
            @AttributeOverride(name = "value",
                    column = @Column(name = "Value"))})
    private AspNetUserTokensId id;

    /***
     * Class constructor.
     */
    public AspNetUserTokens() {
    }

}
