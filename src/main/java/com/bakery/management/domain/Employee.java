package com.bakery.management.domain;

import com.bakery.management.enums.Gender;
import com.bakery.management.enums.MaritalStatus;
import com.bakery.management.enums.converters.GenderConverter;
import com.bakery.management.enums.converters.MaritalStatusConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Employee", schema = "dbo", catalog = "onlineaccounting")
public class Employee implements java.io.Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id", unique = true, nullable = false, length = 36)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JobId", nullable = false)
    private Job job;

    @Column(name = "JobId", nullable = false, updatable = false, insertable = false)
    private int jobId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    @Column(name = "MerchantId", nullable = false, updatable = false, insertable = false)
    private UUID merchantId;

    @Column(name = "SSN", nullable = false)
    private String ssn;

    @Column(name = "FirstName", nullable = false)
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName", nullable = false)
    private String lastName;

    @Column(name = "NationalIdNumber", nullable = false, length = 11)
    private String nationalIdNumber;

    @Column(name = "BitrhDate", nullable = false, length = 10)
    private LocalDate birthDate;

    @Convert(converter = GenderConverter.class)
    @Column(name = "Gender", length = 1)
    private Gender gender;

    @Convert(converter = MaritalStatusConverter.class)
    @Column(name = "MaritalStatus", length = 1)
    private MaritalStatus maritalStatus;

    @Column(name = "Phone", length = 10)
    private String phone;

    @Column(name = "HireDate", nullable = false, length = 10)
    // TODO: Convert all LocalDate fields to OffsetDateTime?
    private LocalDate hireDate;

    @Column(name = "ResignDate", length = 10)
    private LocalDate resignDate;

    @Column(name = "VacationDaysLeft")
    private Byte vacationDaysLeft;

    @Column(name = "SickHoursLeave")
    private Byte sickHoursLeave;

    @Column(name = "AspUserId")
    private String aspUserId;

    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    @Column(name = "LastUpdate", length = 19)
    private OffsetDateTime lastUpdate;

    @Column(name = "Active", nullable = false)
    private boolean active;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<EmployeeAddress> employeeAddresses = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<EmployeeLeave> employeeLeaves = new HashSet<>(0);

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<Driver> vehicleAssignments = new HashSet<>(0);

    public Employee() {
    }

}
