package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmployeeLeave", schema = "public", catalog = "bakery")
public class EmployeeLeave implements java.io.Serializable {

    private int id;
    private Employee employee;
    private Date leaveFrom;
    private Date leaveTo;
    private Date insertedAt;
    private boolean active;

    public EmployeeLeave() {
    }

    public EmployeeLeave(int id, Employee employee, Date leaveFrom, Date insertedAt, boolean active) {
        this.id = id;
        this.employee = employee;
        this.leaveFrom = leaveFrom;
        this.insertedAt = insertedAt;
        this.active = active;
    }

    public EmployeeLeave(int id, Employee employee, Date leaveFrom, Date leaveTo, Date insertedAt, boolean active) {
        this.id = id;
        this.employee = employee;
        this.leaveFrom = leaveFrom;
        this.leaveTo = leaveTo;
        this.insertedAt = insertedAt;
        this.active = active;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EmployeeId", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LeaveFrom", nullable = false, length = 19)
    public Date getLeaveFrom() {
        return this.leaveFrom;
    }

    public void setLeaveFrom(Date leaveFrom) {
        this.leaveFrom = leaveFrom;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LeaveTo", length = 19)
    public Date getLeaveTo() {
        return this.leaveTo;
    }

    public void setLeaveTo(Date leaveTo) {
        this.leaveTo = leaveTo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "InsertedAt", nullable = false, length = 19)
	public Date getInsertedAt() {
		return this.insertedAt;
	}

	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
