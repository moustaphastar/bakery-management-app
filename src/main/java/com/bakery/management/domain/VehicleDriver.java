package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "VehicleDriver", schema = "public", catalog = "bakery")
public class VehicleDriver implements java.io.Serializable {

	private int id;
	private Employee employee;
	private Vehicle vehicle;
	private Date validFrom;
	private Date validTo;
	private boolean active;
	private Set<VehicleDriverCustomer> vehicleDriverCustomers = new HashSet<>(0);
	private Set<ShipmentRoute> shipmentRoutes = new HashSet<>(0);
	private Set<Shipment> shipments = new HashSet<>(0);

	public VehicleDriver() {
	}

	public VehicleDriver(int id, Employee employee, Vehicle vehicle, Date validFrom, boolean active) {
		this.id = id;
		this.employee = employee;
		this.vehicle = vehicle;
		this.validFrom = validFrom;
		this.active = active;
	}

	public VehicleDriver(int id, Employee employee, Vehicle vehicle, Date validFrom, Date validTo, boolean active,
			Set<VehicleDriverCustomer> vehicleDriverCustomers, Set<ShipmentRoute> shipmentRoutes, Set<Shipment> shipments) {
		this.id = id;
		this.employee = employee;
		this.vehicle = vehicle;
		this.validFrom = validFrom;
		this.validTo = validTo;
		this.active = active;
		this.vehicleDriverCustomers = vehicleDriverCustomers;
		this.shipmentRoutes = shipmentRoutes;
		this.shipments = shipments;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VehicleId", nullable = false)
	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleDriver")
	public Set<VehicleDriverCustomer> getVehicleDriverCustomers() {
		return this.vehicleDriverCustomers;
	}

	public void setVehicleDriverCustomers(Set<VehicleDriverCustomer> vehicleDriverCustomers) {
		this.vehicleDriverCustomers = vehicleDriverCustomers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleDriver")
	public Set<ShipmentRoute> getShipmentRoutes() {
		return this.shipmentRoutes;
	}

	public void setShipmentRoutes(Set<ShipmentRoute> shipmentRoutes) {
		this.shipmentRoutes = shipmentRoutes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicleDriver")
	public Set<Shipment> getShipments() {
		return this.shipments;
	}

	public void setShipments(Set<Shipment> shipments) {
		this.shipments = shipments;
	}

}
