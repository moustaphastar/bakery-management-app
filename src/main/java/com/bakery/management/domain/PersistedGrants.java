package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PersistedGrants", schema = "public", catalog = "bakery")
public class PersistedGrants implements java.io.Serializable {

    private UUID key;
    private String type;
    private String subjectId;
    private String sessionId;
    private String clientId;
    private String description;
    private Date creationTime;
    private Date expiration;
    private Date consumedTime;
    private String data;

    public PersistedGrants() {
    }

    public PersistedGrants(UUID key, String type, String clientId, Date creationTime,
                           String data) {
        this.key = key;
        this.type = type;
        this.clientId = clientId;
        this.creationTime = creationTime;
        this.data = data;
    }

    public PersistedGrants(UUID key, String type, String subjectId, String sessionId,
                           String clientId, String description, Date creationTime, Date expiration, Date consumedTime,
                           String data) {
        this.key = key;
        this.type = type;
        this.subjectId = subjectId;
        this.sessionId = sessionId;
        this.clientId = clientId;
        this.description = description;
        this.creationTime = creationTime;
        this.expiration = expiration;
		this.consumedTime = consumedTime;
        this.data = data;
    }

    @Id
    @GeneratedValue
    @Column(name = "Key", unique = true, nullable = false)
    public UUID getKey() {
        return this.key;
    }

    public void setKey(UUID key) {
        this.key = key;
    }

    @Column(name = "Type", nullable = false)
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
	}

	@Column(name = "SubjectId")
	public String getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	@Column(name = "SessionId")
	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "ClientId", nullable = false)
	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Column(name = "Description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreationTime", nullable = false, length = 27)
	public Date getCreationTime() {
		return this.creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Expiration", length = 27)
	public Date getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ConsumedTime", length = 27)
	public Date getConsumedTime() {
		return this.consumedTime;
	}

	public void setConsumedTime(Date consumedTime) {
		this.consumedTime = consumedTime;
	}

	@Column(name = "Data", nullable = false)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
