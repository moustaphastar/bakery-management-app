package com.bakery.management.domain;

import com.bakery.management.enums.AddressType;
import com.bakery.management.enums.converters.AddressTypeConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CustomerAddress", schema = "public")
public class CustomerAddress implements java.io.Serializable {

    private int id;
    private Address address;
    private Customer customer;
    private AddressType description;
    private Date lastUpdate;
    private boolean active;
    private Set<ShipmentRouteIndex> shipmentRouteIndexes = new HashSet<>(0);

    public CustomerAddress() {
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
    @JoinColumn(name = "CustomerId", nullable = false)
    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Convert(converter = AddressTypeConverter.class)
    @Column(name = "Description", nullable = false, length = 1)
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerAddress")
	public Set<ShipmentRouteIndex> getShipmentRouteIndexes() {
		return this.shipmentRouteIndexes;
	}

	public void setShipmentRouteIndexes(Set<ShipmentRouteIndex> shipmentRouteIndexes) {
		this.shipmentRouteIndexes = shipmentRouteIndexes;
	}

}
