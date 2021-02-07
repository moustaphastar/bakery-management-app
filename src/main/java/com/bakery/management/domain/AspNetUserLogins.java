package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "AspNetUserLogins", schema = "dbo", catalog = "onlineaccounting")
public class AspNetUserLogins implements java.io.Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "loginProvider",
                    column = @Column(name = "LoginProvider", nullable = false)),
            @AttributeOverride(name = "providerKey",
                    column = @Column(name = "ProviderKey", nullable = false))})
    private AspNetUserLoginsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private AspNetUsers aspNetUsers;

    @Column(name = "UserId", nullable = false, insertable = false, updatable = false)
    private UUID UserId;

    @Column(name = "ProviderDisplayName")
    private String providerDisplayName;

    public AspNetUserLogins() {
    }

}
