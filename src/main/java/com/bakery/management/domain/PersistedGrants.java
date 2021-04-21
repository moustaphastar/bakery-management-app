package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

/***
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "PersistedGrants", schema = "public")
public class PersistedGrants implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @Column(name = "Key", unique = true, nullable = false)
    private String key;

    /***
     * Type definition of grant.
     */
    @Column(name = "Type", nullable = false)
    private String type;

    /***
     * Subject Id claim.
     */
    @Column(name = "SubjectId")
    private String subjectId;

    /***
     * Session token.
     */
    @Column(name = "SessionId")
    private String sessionId;

    /***
     * Client Id.
     */
    @Column(name = "ClientId", nullable = false)
    private String clientId;

    /***
     * Description for grant.
     */
    @Column(name = "Description")
    private String description;

    /***
     * Date and time with offset token produced.
     */
    @Column(name = "CreationTime", nullable = false, length = 27)
    private OffsetDateTime creationTime;

    /***
     * Date and time with offset token will expire.
     */
    @Column(name = "Expiration", length = 27)
    private OffsetDateTime expiration;

    /***
     * Date and time with offset token consumed.
     */
    @Column(name = "ConsumedTime", length = 27)
    private OffsetDateTime consumedTime;

    /***
     * Data.
     */
    // todo: Enhance Javadoc. What is it for?
    @Column(name = "Data", nullable = false)
    private String data;

    /***
     * Class constructor.
     */
    public PersistedGrants() {
    }

}
