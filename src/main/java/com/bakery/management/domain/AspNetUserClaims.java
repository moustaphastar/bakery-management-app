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
@Table(name = "AspNetUserClaims", schema = "dbo", catalog = "onlineaccounting")
public class AspNetUserClaims implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private AspNetUsers aspNetUsers;

    @Column(name = "UserId", nullable = false, updatable = false, insertable = false)
    private UUID UserId;

    @Column(name = "ClaimType")
    private String claimType;

    @Column(name = "ClaimValue")
    private String claimValue;

    public AspNetUserClaims() {
    }

}
