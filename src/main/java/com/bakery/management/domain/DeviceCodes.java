package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.OffsetDateTime;
import java.util.UUID;

/***
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(schema = "public",
        uniqueConstraints = @UniqueConstraint(columnNames = "DeviceCode"))
public class DeviceCodes implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private UUID userCode;

    /***
     * Device identification code.
     */
    @Column(unique = true, nullable = false)
    private String deviceCode;

    /***
     * Subject Id claim.
     */
    @Column(nullable = false)
    private String subjectId;

    /***
     * Session token.
     */
    @Column(nullable = false)
    private String sessionId;

    /***x
     * Client Id.
     */
    @Column(nullable = false)
    private String clientId;

    /***
     * Description for device.
     */
    @Column(nullable = false)
    private String description;

    /***
     * Date and time with offset token produced.
     */
    @Column(nullable = false, length = 27)
    private OffsetDateTime creationTime;

    /***
     * Date and time with offset token will expire.
     */
    @Column(nullable = false, length = 27)
    private OffsetDateTime expiration;

    /***
     * Data.
     */
    // todo: Enhance Javadoc. What is it for?
    @Column(nullable = false)
    private String data;

    /***
     * Class constructor.
     */
    public DeviceCodes() {
    }

}
