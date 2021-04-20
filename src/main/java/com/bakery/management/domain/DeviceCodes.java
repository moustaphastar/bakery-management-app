package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DeviceCodes", schema = "public", catalog = "bakery", uniqueConstraints = @UniqueConstraint(columnNames = "DeviceCode"))
public class DeviceCodes implements java.io.Serializable {

	private String userCode;
	private String deviceCode;
	private String subjectId;
	private String sessionId;
	private String clientId;
	private String description;
	private Date creationTime;
	private Date expiration;
	private String data;

	public DeviceCodes() {
	}

    @Id
    @GeneratedValue
    @Column(name = "UserCode", unique = true, nullable = false)
    public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name = "DeviceCode", unique = true, nullable = false)
	public String getDeviceCode() {
		return this.deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
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
	@Column(name = "Expiration", nullable = false, length = 27)
	public Date getExpiration() {
		return this.expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	@Column(name = "Data", nullable = false)
	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
