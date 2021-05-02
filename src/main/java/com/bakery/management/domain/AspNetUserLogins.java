package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

/***
 * Domain model class to hold user login data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(schema = "public")
public class AspNetUserLogins implements java.io.Serializable {

    /***
     * Id of the entity. Embedded from {@link AspNetUserLoginsId} entity.
     */
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "loginProvider",
                    column = @Column(nullable = false)),
            @AttributeOverride(name = "providerKey",
                    column = @Column(nullable = false))})
    private AspNetUserLoginsId id;

    /***
     * Parent {@link AspNetUsers} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private AspNetUsers aspNetUsers;

    /***
     * Foreign key to parent {@link AspNetUsers} entity Id.
     */
    @Column(nullable = false, insertable = false,
            updatable = false)
    private UUID userId;

    /***
     * Display name for provider.
     */
    // todo: Enhance Javadoc. What is a provider?
    @Column(nullable = false)
    private String providerDisplayName;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
    private OffsetDateTime insertedDate;

    /***
     * Class constructor.
     */
    public AspNetUserLogins() {
    }

}
