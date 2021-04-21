package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

/***
 * Domain model class to hold user claims data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "AspNetUserClaims", schema = "public")
public class AspNetUserClaims implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link AspNetUsers} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId", nullable = false)
    private AspNetUsers aspNetUsers;

    /***
     * Foreign key to parent {@link AspNetUsers} entity.
     */
    @Column(name = "UserId", nullable = false, updatable = false,
            insertable = false)
    private UUID userId;

    /***
     * Claim type name to be associated with an {@link AspNetUsers}.
     * i.e. Email, Sid, Expiration.
     */
    @Column(name = "ClaimType")
    private String claimType;

    /***
     * Value of an associated {@link #claimType}.
     */
    @Column(name = "ClaimValue")
    private String claimValue;

    /***
     * Class constructor.
     */
    public AspNetUserClaims() {
    }

}
