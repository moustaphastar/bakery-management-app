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
import java.time.OffsetDateTime;
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
@Table(schema = "public")
public class AspNetUserClaims implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link AspNetUsers} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private AspNetUsers aspNetUsers;

    /***
     * Foreign key to parent {@link AspNetUsers} entity.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private UUID userId;

    /***
     * Claim type name to be associated with an {@link AspNetUsers}.
     * i.e. Email, Sid, Expiration.
     */
    @Column(nullable = false)
    private String claimType;

    /***
     * Value of an associated {@link #claimType}.
     */
    @Column(nullable = false)
    private String claimValue;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
    private OffsetDateTime insertedDate;

    /***
     * Application user id who committed the insert.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID insertedBy;

    /***
     * Date and time of last update with an offset.
     */
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    /***
     * Application user id who committed the last update.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID lastUpdatedBy;

    /***
     * Class constructor.
     */
    public AspNetUserClaims() {
    }

}
