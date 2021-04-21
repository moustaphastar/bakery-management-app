package com.bakery.management.domain;

import com.bakery.management.enums.ShipmentStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Shipment", schema = "public")
public class Shipment implements java.io.Serializable {

	private int id;
	private ShipmentRoute shipmentRoute;
	private VehicleDriver vehicleDriver;
	private Date date;
	private Date timeStart;
	private Date timeEnd;
	private Integer odometerStart;
	private Integer odometerEnd;
	private ShipmentStatus status;
	private Date lastUpdate;
	private boolean active;
	private Set<ShipmentLoad> shipmentLoads = new HashSet<>(0);

	public Shipment() {
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
	@JoinColumn(name = "ShipmentRouteId")
	public ShipmentRoute getShipmentRoute() {
		return this.shipmentRoute;
	}

	public void setShipmentRoute(ShipmentRoute shipmentRoute) {
		this.shipmentRoute = shipmentRoute;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CarrierId", nullable = false)
	public VehicleDriver getVehicleDriver() {
		return this.vehicleDriver;
	}

	public void setVehicleDriver(VehicleDriver vehicleDriver) {
		this.vehicleDriver = vehicleDriver;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "Date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "TimeStart", length = 8)
	public Date getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(Date timeStart) {
		this.timeStart = timeStart;
	}

	@Temporal(TemporalType.TIME)
	@Column(name = "TimeEnd", length = 8)
	public Date getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(Date timeEnd) {
		this.timeEnd = timeEnd;
	}

	@Column(name = "OdometerStart")
	public Integer getOdometerStart() {
		return this.odometerStart;
	}

	public void setOdometerStart(Integer odometerStart) {
		this.odometerStart = odometerStart;
	}

    @Column(name = "OdometerEnd")
    public Integer getOdometerEnd() {
        return this.odometerEnd;
    }

    public void setOdometerEnd(Integer odometerEnd) {
        this.odometerEnd = odometerEnd;
    }

    //@Convert(converter = ShipmentStatus.class)
    @Column(name = "Status", nullable = false, length = 1)
    public ShipmentStatus getStatus() {
        return this.status;
    }

    public void setStatus(ShipmentStatus status) {
        this.status = status;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment")
	public Set<ShipmentLoad> getShipmentLoads() {
		return this.shipmentLoads;
	}

	public void setShipmentLoads(Set<ShipmentLoad> shipmentLoads) {
		this.shipmentLoads = shipmentLoads;
	}

}
