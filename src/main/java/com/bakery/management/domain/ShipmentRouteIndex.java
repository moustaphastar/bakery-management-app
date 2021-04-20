package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ShipmentRouteIndex", schema = "public", catalog = "bakery")
public class ShipmentRouteIndex implements java.io.Serializable {

	private int id;
	private CustomerAddress customerAddress;
	private ShipmentRoute shipmentRoute;
	private short indexInRoute;
	private Date lastUpdate;
	private boolean active;

	public ShipmentRouteIndex() {
	}

	public ShipmentRouteIndex(int id, CustomerAddress customerAddress, ShipmentRoute shipmentRoute, short indexInRoute,
			Date lastUpdate, boolean active) {
		this.id = id;
		this.customerAddress = customerAddress;
		this.shipmentRoute = shipmentRoute;
		this.indexInRoute = indexInRoute;
		this.lastUpdate = lastUpdate;
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
	@JoinColumn(name = "LocationId", nullable = false)
	public CustomerAddress getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentRouteId", nullable = false)
	public ShipmentRoute getShipmentRoute() {
		return this.shipmentRoute;
	}

	public void setShipmentRoute(ShipmentRoute shipmentRoute) {
		this.shipmentRoute = shipmentRoute;
	}

	@Column(name = "IndexInRoute", nullable = false)
	public short getIndexInRoute() {
		return this.indexInRoute;
	}

	public void setIndexInRoute(short indexInRoute) {
		this.indexInRoute = indexInRoute;
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
