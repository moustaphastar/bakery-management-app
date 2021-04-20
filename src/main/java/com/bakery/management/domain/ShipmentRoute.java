package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ShipmentRoute", schema = "dbo", catalog = "bakery")
public class ShipmentRoute implements java.io.Serializable {

	private int id;
	private VehicleDriver vehicleDriver;
	private String name;
	private Date insertedAt;
	private Date lastUpdate;
	private boolean active;
	private Set<Shipment> shipments = new HashSet<>(0);
	private Set<ShipmentRouteIndex> shipmentRouteIndexes = new HashSet<>(0);

	public ShipmentRoute() {
	}

	public ShipmentRoute(int id, String name, Date insertedAt, Date lastUpdate, boolean active) {
		this.id = id;
		this.name = name;
		this.insertedAt = insertedAt;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public ShipmentRoute(int id, VehicleDriver vehicleDriver, String name, Date insertedAt, Date lastUpdate,
			boolean active, Set<Shipment> shipments, Set<ShipmentRouteIndex> shipmentRouteIndexes) {
		this.id = id;
		this.vehicleDriver = vehicleDriver;
		this.name = name;
		this.insertedAt = insertedAt;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.shipments = shipments;
		this.shipmentRouteIndexes = shipmentRouteIndexes;
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
	@JoinColumn(name = "VehicleDriverId")
	public VehicleDriver getVehicleDriver() {
		return this.vehicleDriver;
	}

	public void setVehicleDriver(VehicleDriver vehicleDriver) {
		this.vehicleDriver = vehicleDriver;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipmentRoute")
	public Set<Shipment> getShipments() {
		return this.shipments;
	}

	public void setShipments(Set<Shipment> shipments) {
		this.shipments = shipments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipmentRoute")
	public Set<ShipmentRouteIndex> getShipmentRouteIndexes() {
		return this.shipmentRouteIndexes;
	}

	public void setShipmentRouteIndexes(Set<ShipmentRouteIndex> shipmentRouteIndexes) {
		this.shipmentRouteIndexes = shipmentRouteIndexes;
	}

}
