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
@Table(name = "EmployeeLeave", schema = "dbo", catalog = "onlineaccounting")
public class EmployeeLeave implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeId", nullable = false)
    private Employee employee;

    @Column(name = "EmployeeId", nullable = false, updatable = false, insertable = false)
    private UUID employeeId;

    @Column(name = "LaeveFrom", nullable = false, length = 19)
    private OffsetDateTime leaveFrom;

    @Column(name = "LeaveTo", length = 19)
    private OffsetDateTime leaveTo;

    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    @Column(name = "Active", nullable = false)
    private boolean active;

    public EmployeeLeave() {
    }

}
