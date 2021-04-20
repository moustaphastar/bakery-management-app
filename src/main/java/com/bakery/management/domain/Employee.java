package com.bakery.management.domain;

import com.bakery.management.enums.Gender;
import com.bakery.management.enums.MaritalStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Employee", schema = "public", catalog = "bakery")
public class Employee implements java.io.Serializable {

	private UUID id;
	private Job job;
    private Merchant merchant;
    private String ssn;
    private String firstName;
    private String middleName;
    private String lastName;
	private String nationalIdNumber;
	private Date birthDate;
	private Gender gender;
    private MaritalStatus maritalStatus;
    private String phone;
    private Date hireDate;
    private Date resignDate;
    private Byte vacationDaysLeft;
    private Byte sickHoursLeave;
    private String aspUserId;
	private Date insertedAt;
	private Date lastUpdate;
	private boolean active;
	private Set<EmployeeAddress> employeeAddresses = new HashSet<>(0);
	private Set<EmployeeLeave> employeeLeaves = new HashSet<>(0);
	private Set<VehicleDriver> vehicleDrivers = new HashSet<>(0);

	public Employee() {
	}

	public Employee(UUID id, Job job, Merchant merchant, String ssn, String firstName,
					String lastName, String nationalIdNumber, Date birthDate, Date hireDate, Date insertedAt,
					boolean active) {
		this.id = id;
		this.job = job;
		this.merchant = merchant;
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdNumber = nationalIdNumber;
		this.birthDate = birthDate;
		this.hireDate = hireDate;
		this.insertedAt = insertedAt;
		this.active = active;
	}

	public Employee(UUID id, Job job, Merchant merchant, String ssn, String firstName,
					String middleName, String lastName, String nationalIdNumber, Date birthDate, Gender gender,
					MaritalStatus maritalStatus, String phone, Date hireDate, Date resignDate, Byte vacationDaysLeft,
					Byte sickHoursLeave, String aspUserId, Date insertedAt, Date lastUpdate, boolean active,
					Set<EmployeeAddress> employeeAddresses, Set<EmployeeLeave> employeeLeaves, Set<VehicleDriver> vehicleDrivers) {
		this.id = id;
		this.job = job;
		this.merchant = merchant;
		this.ssn = ssn;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.nationalIdNumber = nationalIdNumber;
		this.birthDate = birthDate;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
		this.phone = phone;
		this.hireDate = hireDate;
		this.resignDate = resignDate;
		this.vacationDaysLeft = vacationDaysLeft;
		this.sickHoursLeave = sickHoursLeave;
		this.aspUserId = aspUserId;
		this.insertedAt = insertedAt;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.employeeAddresses = employeeAddresses;
		this.employeeLeaves = employeeLeaves;
		this.vehicleDrivers = vehicleDrivers;
	}

	@Id
	@GeneratedValue
	@Column(name = "Id", unique = true, nullable = false, length = 36)
	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JobId", nullable = false)
	public Job getJob() {
		return this.job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MerchantId", nullable = false)
	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Column(name = "SSN", nullable = false)
	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Column(name = "FirstName", nullable = false)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MiddleName")
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "LastName", nullable = false)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "NationalIdNumber", nullable = false, length = 11)
	public String getNationalIdNumber() {
		return this.nationalIdNumber;
	}

	public void setNationalIdNumber(String nationalIdNumber) {
		this.nationalIdNumber = nationalIdNumber;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BirthDate", nullable = false, length = 10)
	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	//@Convert(converter = GenderConverter.class)
	@Column(name = "Gender", length = 1)
	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
    }

	//@Convert(converter = MaritalStatusConverter.class)
    @Column(name = "MaritalStatus", length = 1)
    public MaritalStatus getMaritalStatus() {
        return this.maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Column(name = "Phone", length = 10)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "HireDate", nullable = false, length = 10)
	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ResignDate", length = 10)
	public Date getResignDate() {
		return this.resignDate;
	}

	public void setResignDate(Date resignDate) {
		this.resignDate = resignDate;
	}

	@Column(name = "VacationDaysLeft")
	public Byte getVacationDaysLeft() {
		return this.vacationDaysLeft;
	}

	public void setVacationDaysLeft(Byte vacationDaysLeft) {
		this.vacationDaysLeft = vacationDaysLeft;
	}

	@Column(name = "SickHoursLeave")
	public Byte getSickHoursLeave() {
		return this.sickHoursLeave;
	}

	public void setSickHoursLeave(Byte sickHoursLeave) {
		this.sickHoursLeave = sickHoursLeave;
	}

	@Column(name = "AspUserId")
	public String getAspUserId() {
		return this.aspUserId;
	}

	public void setAspUserId(String aspUserId) {
		this.aspUserId = aspUserId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "InsertedAt", nullable = false, length = 19)
	public Date getInsertedAt() {
		return this.insertedAt;
	}

	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LastUpdate", length = 19)
	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<EmployeeAddress> getEmployeeAddresses() {
		return this.employeeAddresses;
	}

	public void setEmployeeAddresses(Set<EmployeeAddress> employeeAddresses) {
		this.employeeAddresses = employeeAddresses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<EmployeeLeave> getEmployeeLeaves() {
		return this.employeeLeaves;
	}

	public void setEmployeeLeaves(Set<EmployeeLeave> employeeLeaves) {
		this.employeeLeaves = employeeLeaves;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public Set<VehicleDriver> getVehicleDrivers() {
		return this.vehicleDrivers;
	}

	public void setVehicleDrivers(Set<VehicleDriver> vehicleDrivers) {
		this.vehicleDrivers = vehicleDrivers;
	}

}
