package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "PersistedGrants", schema = "dbo", catalog = "onlineaccounting")
public class PersistedGrants implements java.io.Serializable {

    @Id
    @Column(name = "Key", unique = true, nullable = false)
    private String key;

    @Column(name = "Type", nullable = false)
    private String type;

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

    @Column(name = "Expiration", length = 27)
    private OffsetDateTime expiration;

    @Column(name = "ConsumedTime", length = 27)
    private OffsetDateTime consumedTime;

    @Column(name = "Data", nullable = false)
    private String data;

    public PersistedGrants() {
    }

}
