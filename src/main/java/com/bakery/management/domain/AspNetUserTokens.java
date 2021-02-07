package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "AspNetUserTokens", schema = "dbo", catalog = "onlineaccounting")
public class AspNetUserTokens implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "userId", column = @Column(name = "UserId", nullable = false)),
            @AttributeOverride(name = "loginProvider", column = @Column(name = "LoginProvider",
                    nullable = false)),
            @AttributeOverride(name = "name", column = @Column(name = "Name", nullable = false)),
            @AttributeOverride(name = "value", column = @Column(name = "Value"))})
    private AspNetUserTokensId id;

    public AspNetUserTokens() {
    }

}
