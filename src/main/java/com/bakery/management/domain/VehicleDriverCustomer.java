package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VehicleDriverCustomer", schema = "dbo", catalog = "bakery")
public class VehicleDriverCustomer implements java.io.Serializable {

	private int id;
	private Customer customer;
	private VehicleDriver vehicleDriver;
	private Date validFrom;
	private Date validTo;
	private boolean active;

	public VehicleDriverCustomer() {
	}

	public VehicleDriverCustomer(int id, Customer customer, VehicleDriver vehicleDriver, Date validFrom,
			boolean active) {
		this.id = id;
		this.customer = customer;
		this.vehicleDriver = vehicleDriver;
		this.validFrom = validFrom;
		this.active = active;
	}

	public VehicleDriverCustomer(int id, Customer customer, VehicleDriver vehicleDriver, Date validFrom, Date validTo,
			boolean active) {
		this.id = id;
		this.customer = customer;
		this.vehicleDriver = vehicleDriver;
		this.validFrom = validFrom;
		this.validTo = validTo;
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
	@JoinColumn(name = "CustomerId", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DriverId", nullable = false)
	public VehicleDriver getVehicleDriver() {
		return this.vehicleDriver;
	}

	public void setVehicleDriver(VehicleDriver vehicleDriver) {
		this.vehicleDriver = vehicleDriver;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ValidFrom", nullable = false, length = 19)
	public Date getValidFrom() {
		return this.validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ValidTo", length = 19)
	public Date getValidTo() {
		return this.validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
