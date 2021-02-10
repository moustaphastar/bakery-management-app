package com.bakery.management.domain;

import com.bakery.management.enums.Gender;
import com.bakery.management.enums.MaritalStatus;
import com.bakery.management.enums.converters.GenderConverter;
import com.bakery.management.enums.converters.MaritalStatusConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
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
@Table(name = "Employee", schema = "dbo", catalog = "onlineaccounting")
public class Employee implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    /***
     * Parent {@link Job} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JobId", nullable = false)
    private Job job;

    /***
     * Foreign key to parent {@link Job} entity Id.
     */
    @Column(name = "JobId", nullable = false, updatable = false,
            insertable = false)
    private int jobId;

    /***
     * Parent {@link Merchant} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    /***
     * Foreign key to parent {@link Merchant} entity Id.
     */
    @Column(name = "MerchantId", nullable = false, updatable = false,
            insertable = false)
    private UUID merchantId;

    /***
     * Social security number.
     */
    @Column(name = "SSN", nullable = false)
    private String ssn;

    /***
     * First name.
     */
    @Column(name = "FirstName", nullable = false)
    private String firstName;

    /***
     * Middle name.
     */
    @Column(name = "MiddleName")
    private String middleName;

    /***
     * Last name.
     */
    @Column(name = "LastName", nullable = false)
    private String lastName;

    /***
     * Governmental identity number.
     */
    @Column(name = "NationalIdNumber", nullable = false, length = 11)
    private String nationalIdNumber;

    /***
     * Date of birth.
     */
    @Column(name = "BitrhDate", nullable = false, length = 10)
    private LocalDate birthDate;

    /***
     * Gender from {@link Gender}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = GenderConverter.class)
    @Column(name = "Gender", length = 1)
    private Gender gender;

    /***
     * Marital status from {@link MaritalStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = MaritalStatusConverter.class)
    @Column(name = "MaritalStatus", length = 1)
    private MaritalStatus maritalStatus;

    /***
     * Phone number.
     */
    @Column(name = "Phone", length = 10)
    private String phone;

    /***
     * Date of hire.
     */
    @Column(name = "HireDate", nullable = false, length = 10)
    // todo: Convert all LocalDate fields to OffsetDateTime?
    private LocalDate hireDate;

    /***
     * Date of resign.
     */
    @Column(name = "ResignDate", length = 10)
    private LocalDate resignDate;

    /***
     * Days count available for vacation.
     */
    // todo: Inverse? Otherwise we have to keep max vacation day number.
    @Column(name = "VacationDaysLeft")
    private Byte vacationDaysLeft;

    /***
     * Days off count due to illness.
     */
    @Column(name = "SickHoursLeave")
    private Byte sickHoursLeave;

    /***
     * User id if available.
     */
    @Column(name = "AspUserId")
    private String aspUserId;

    /***
     * Date and time of first persisting with an offset.
     */
    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", length = 19)
    private OffsetDateTime lastUpdate;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link EmployeeAddress} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<EmployeeAddress> employeeAddresses = new HashSet<>(0);

    /***
     * Set of child {@link EmployeeLeave} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<EmployeeLeave> employeeLeaves = new HashSet<>(0);

    /***
     * Set of child {@link Driver} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<Driver> vehicleAssignments = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Employee() {
    }

}
