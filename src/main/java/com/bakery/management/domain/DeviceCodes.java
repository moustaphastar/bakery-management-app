package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "DeviceCodes", schema = "dbo", catalog = "onlineaccounting", uniqueConstraints = @UniqueConstraint(columnNames = "DeviceCode"))
public class DeviceCodes implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "UserCode", unique = true, nullable = false)
    private UUID userCode;

    @Column(name = "DeviceCode", unique = true, nullable = false)
    private String deviceCode;

    @Column(name = "SubjectId")
    private String subjectId;

    @Column(name = "SessionId")
    private String sessionId;

    @Column(name = "ClientId", nullable = false)
    private String clientId;

    @Column(name = "Description")
    private String description;

    @Column(name = "CreationTime", nullable = false, length = 27)
    private OffsetDateTime creationTime;

    @Column(name = "Expiration", nullable = false, length = 27)
    private OffsetDateTime expiration;

    @Column(name = "Data", nullable = false)
    private String data;

    public DeviceCodes() {
    }

}
