package com.bakery.management.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "AspNetUsers", schema = "public", catalog = "bakery", uniqueConstraints = @UniqueConstraint(columnNames = "NormalizedUserName"))
public class AspNetUsers implements java.io.Serializable {

    private UUID id;
    private String userName;
    private String normalizedUserName;
    private String email;
    private String normalizedEmail;
    private boolean emailConfirmed;
    private String passwordHash;
    private String securityStamp;
    private String concurrencyStamp;
    private String phoneNumber;
    private boolean phoneNumberConfirmed;
	private boolean twoFactorEnabled;
    private String lockoutEnd;
    private boolean lockoutEnabled;
    private int accessFailedCount;
    private Set<AspNetUserLogins> aspNetUserLogins = new HashSet<>(0);
    private Set<AspNetUserClaims> aspNetUserClaims = new HashSet<>(0);
    private Set<AspNetRoles> aspNetRoles = new HashSet<>(0);

    public AspNetUsers() {
    }

    public AspNetUsers(UUID id, boolean emailConfirmed, boolean phoneNumberConfirmed, boolean twoFactorEnabled,
                       boolean lockoutEnabled, int accessFailedCount) {
        this.id = id;
        this.emailConfirmed = emailConfirmed;
        this.phoneNumberConfirmed = phoneNumberConfirmed;
        this.twoFactorEnabled = twoFactorEnabled;
        this.lockoutEnabled = lockoutEnabled;
        this.accessFailedCount = accessFailedCount;
    }

    public AspNetUsers(UUID id, String userName, String normalizedUserName, String email,
                       String normalizedEmail, boolean emailConfirmed, String passwordHash, String securityStamp,
                       String concurrencyStamp, String phoneNumber, boolean phoneNumberConfirmed,
                       boolean twoFactorEnabled, String lockoutEnd, boolean lockoutEnabled, int accessFailedCount,
                       Set<AspNetUserLogins> aspNetUserLogins, Set<AspNetUserClaims> aspNetUserClaims, Set<AspNetRoles> aspNetRoles) {
        this.id = id;
        this.userName = userName;
        this.normalizedUserName = normalizedUserName;
        this.email = email;
        this.normalizedEmail = normalizedEmail;
        this.emailConfirmed = emailConfirmed;
		this.passwordHash = passwordHash;
		this.securityStamp = securityStamp;
		this.concurrencyStamp = concurrencyStamp;
		this.phoneNumber = phoneNumber;
		this.phoneNumberConfirmed = phoneNumberConfirmed;
		this.twoFactorEnabled = twoFactorEnabled;
		this.lockoutEnd = lockoutEnd;
		this.lockoutEnabled = lockoutEnabled;
		this.accessFailedCount = accessFailedCount;
		this.aspNetUserLogins = aspNetUserLogins;
		this.aspNetUserClaims = aspNetUserClaims;
        this.aspNetRoles = aspNetRoles;
    }

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false)
    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "UserName")
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
	}

	@Column(name = "NormalizedUserName", unique = true)
	public String getNormalizedUserName() {
		return this.normalizedUserName;
	}

	public void setNormalizedUserName(String normalizedUserName) {
		this.normalizedUserName = normalizedUserName;
	}

	@Column(name = "Email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "NormalizedEmail")
	public String getNormalizedEmail() {
		return this.normalizedEmail;
	}

	public void setNormalizedEmail(String normalizedEmail) {
		this.normalizedEmail = normalizedEmail;
	}

	@Column(name = "EmailConfirmed", nullable = false)
	public boolean isEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	@Column(name = "PasswordHash")
	public String getPasswordHash() {
		return this.passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@Column(name = "SecurityStamp")
	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	@Column(name = "ConcurrencyStamp")
	public String getConcurrencyStamp() {
		return this.concurrencyStamp;
	}

	public void setConcurrencyStamp(String concurrencyStamp) {
		this.concurrencyStamp = concurrencyStamp;
	}

	@Column(name = "PhoneNumber")
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "PhoneNumberConfirmed", nullable = false)
	public boolean isPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	@Column(name = "TwoFactorEnabled", nullable = false)
	public boolean isTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	@Column(name = "LockoutEnd")
	public String getLockoutEnd() {
		return this.lockoutEnd;
	}

	public void setLockoutEnd(String lockoutEnd) {
		this.lockoutEnd = lockoutEnd;
	}

	@Column(name = "LockoutEnabled", nullable = false)
	public boolean isLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	@Column(name = "AccessFailedCount", nullable = false)
	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetUsers")
	public Set<AspNetUserLogins> getAspNetUserLogins() {
		return this.aspNetUserLogins;
	}

	public void setAspNetUserLogins(Set<AspNetUserLogins>aspNetUserLogins) {
		this.aspNetUserLogins = aspNetUserLogins;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aspNetUsers")
	public Set<AspNetUserClaims> getAspNetUserClaims() {
		return this.aspNetUserClaims;
	}

	public void setAspNetUserClaims(Set<AspNetUserClaims> aspNetUserClaims) {
		this.aspNetUserClaims = aspNetUserClaims;
	}

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "AspNetUserRoles", schema = "public", catalog = "bakery", joinColumns = {
            @JoinColumn(name = "UserId", nullable = false, updatable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "RoleId", nullable = false, updatable = false)})
    public Set<AspNetRoles> getAspNetRoles() {
		return this.aspNetRoles;
	}

	public void setAspNetRoles(Set<AspNetRoles> aspNetRoles) {
		this.aspNetRoles = aspNetRoles;
	}

}
