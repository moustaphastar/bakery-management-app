package com.cayirozu.db.entity;
// Generated 19 Ara 2020 06:35:03 by Hibernate Tools 5.2.12.Final

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PersistedGrants generated by hbm2java
 */
@Entity
@Table(name = "PersistedGrants", schema = "dbo", catalog = "onlineaccounting")
public class PersistedGrants implements java.io.Serializable {

	private Serializable key;
	private Serializable type;
	private Serializable subjectId;
	private Serializable sessionId;
	private Serializable clientId;
	private Serializable description;
	private Date creationTime;
	private Date expiration;
	private Date consumedTime;
	private Serializable data;

	public PersistedGrants() {
	}

	public PersistedGrants(Serializable key, Serializable type, Serializable clientId, Date creationTime,
			Serializable data) {
		this.key = key;
		this.type = type;
		this.clientId = clientId;
		this.creationTime = creationTime;
		this.data = data;
	}

	public PersistedGrants(Serializable key, Serializable type, Serializable subjectId, Serializable sessionId,
			Serializable clientId, Serializable description, Date creationTime, Date expiration, Date consumedTime,
			Serializable data) {
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

	@Column(name = "Key", unique = true, nullable = false)
	public Serializable getKey() {
		return this.key;
	}

	public void setKey(Serializable key) {
		this.key = key;
	}

	@Column(name = "Type", nullable = false)
	public Serializable getType() {
		return this.type;
	}

	public void setType(Serializable type) {
		this.type = type;
	}

	@Column(name = "SubjectId")
	public Serializable getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Serializable subjectId) {
		this.subjectId = subjectId;
	}

	@Column(name = "SessionId")
	public Serializable getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(Serializable sessionId) {
		this.sessionId = sessionId;
	}

	@Column(name = "ClientId", nullable = false)
	public Serializable getClientId() {
		return this.clientId;
	}

	public void setClientId(Serializable clientId) {
		this.clientId = clientId;
	}

	@Column(name = "Description")
	public Serializable getDescription() {
		return this.description;
	}

	public void setDescription(Serializable description) {
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
	public Serializable getData() {
		return this.data;
	}

	public void setData(Serializable data) {
		this.data = data;
	}

}
