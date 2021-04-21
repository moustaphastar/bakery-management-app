package com.bakery.management.domain;

import com.bakery.management.enums.AddressType;
import com.bakery.management.enums.converters.AddressTypeConverter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EmployeeAddress", schema = "public")
public class EmployeeAddress implements java.io.Serializable {

    private int id;
    private Address address;
    private Employee employee;
    private AddressType description;
    private Date lastUpdate;
    private boolean active;

    public EmployeeAddress() {
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
	@JoinColumn(name = "AddressId", nullable = false)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeId", nullable = false)
    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Convert(converter = AddressTypeConverter.class)
    @Column(name = "Description", nullable = false)
    public AddressType getDescription() {
        return this.description;
    }

    public void setDescription(AddressType description) {
        this.description = description;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LastUpdate", nullable = false, length = 19)
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

}
