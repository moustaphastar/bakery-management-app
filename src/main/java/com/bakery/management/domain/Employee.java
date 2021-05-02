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
@Table(schema = "public")
public class Employee implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false, length = 36)
    private UUID id;

    /***
     * Parent {@link Job} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobId", nullable = false)
    private Job job;

    /***
     * Foreign key to parent {@link Job} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private int jobId;

    /***
     * Parent {@link Merchant} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchantId", nullable = false)
    private Merchant merchant;

    /***
     * Foreign key to parent {@link Merchant} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private UUID merchantId;

    /***
     * Social security number.
     */
    @Column(nullable = false)
    private String ssn;

    /***
     * First name.
     */
    @Column(nullable = false)
    private String firstName;

    /***
     * Middle name.
     */
    @Column(nullable = false)
    private String middleName;

    /***
     * Last name.
     */
    @Column(nullable = false)
    private String lastName;

    /***
     * Governmental identity number.
     */
    @Column(nullable = false, length = 11)
    private String nationalIdNumber;

    /***
     * Date of birth.
     */
    @Column(nullable = false, length = 10)
    private LocalDate birthDate;

    /***
     * Gender from {@link Gender}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = GenderConverter.class)
    @Column(length = 1)
    private Gender gender;

    /***
     * Marital status from {@link MaritalStatus}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = MaritalStatusConverter.class)
    @Column(length = 1)
    private MaritalStatus maritalStatus;

    /***
     * Phone number.
     */
    @Column(length = 10)
    private String phone;

    /***
     * Date of hire.
     */
    @Column(nullable = false, length = 10)
    // todo: Convert all LocalDate fields to OffsetDateTime?
    private LocalDate hireDate;

    /***
     * Date of resign.
     */
    @Column(length = 10)
    private LocalDate resignDate;

    /***
     * Days count available for vacation.
     */
    // todo: Inverse? Otherwise we have to keep max vacation day number.
    @Column(nullable = false)
    private Byte vacationDaysLeft;

    /***
     * Days off count due to illness.
     */
    @Column(nullable = false)
    private Byte sickHoursLeave;

    /***
     * User id if available.
     */
    @Column(nullable = false)
    private String aspUserId;

    /***
     * Date and time of first persisting with an offset.
     */
    @Column(nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
    private OffsetDateTime insertedDate;

    /***
     * Application user id who committed the insert.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID insertedBy;

    /***
     * Date and time of last update with an offset.
     */
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    /***
     * Application user id who committed the last update.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID lastUpdatedBy;

    /***
     * State of existence in persistence.
     */
    @Column(nullable = false)
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
