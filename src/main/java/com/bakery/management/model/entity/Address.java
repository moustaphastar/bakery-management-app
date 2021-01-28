package com.bakery.management.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Address", schema = "dbo", catalog = "bakery")
public class Address implements java.io.Serializable {

	private int id;
	private District district;
	private String addressLine1;
	private String addressLine2;
	private String spatialLocation;
	private Date lastUpdate;
	private boolean active;
	private Set<MerchantAddress> merchantAddresses = new HashSet<>(0);
	private Set<Sale> salesForBillToAddressId = new HashSet<>(0);
	private Set<EmployeeAddress> employeeAddresses = new HashSet<>(0);
	private Set<Sale> salesForShipToAddressId = new HashSet<>(0);
	private Set<CustomerAddress> customerAddresses = new HashSet<>(0);

	public Address() {
	}

	public Address(int id, District district, String addressLine1, String addressLine2, Date lastUpdate,
				   boolean active) {
		this.id = id;
		this.district = district;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public Address(int id, District district, String addressLine1, String addressLine2, String spatialLocation,
				   Date lastUpdate, boolean active, Set<MerchantAddress> merchantAddresses,
				   Set<Sale> salesForBillToAddressId, Set<EmployeeAddress> employeeAddresses,
				   Set<Sale> salesForShipToAddressId, Set<CustomerAddress> customerAddresses) {
		this.id = id;
		this.district = district;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.spatialLocation = spatialLocation;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.merchantAddresses = merchantAddresses;
		this.salesForBillToAddressId = salesForBillToAddressId;
		this.employeeAddresses = employeeAddresses;
		this.salesForShipToAddressId = salesForShipToAddressId;
		this.customerAddresses = customerAddresses;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false, updatable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DistrictId", nullable = false)
	public District getDistrict() {
		return this.district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	@Column(name = "AddressLine1", nullable = false)
	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "AddressLine2", nullable = false)
	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "SpatialLocation")
	public String getSpatialLocation() {
		return this.spatialLocation;
	}

	public void setSpatialLocation(String spatialLocation) {
		this.spatialLocation = spatialLocation;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<MerchantAddress> getMerchantAddresses() {
		return this.merchantAddresses;
	}

	public void setMerchantAddresses(Set<MerchantAddress> merchantAddresses) {
		this.merchantAddresses = merchantAddresses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "addressByBillToAddressId")
	public Set<Sale> getSalesForBillToAddressId() {
		return this.salesForBillToAddressId;
	}

	public void setSalesForBillToAddressId(Set<Sale> salesForBillToAddressId) {
		this.salesForBillToAddressId = salesForBillToAddressId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<EmployeeAddress> getEmployeeAddresses() {
		return this.employeeAddresses;
	}

	public void setEmployeeAddresses(Set<EmployeeAddress> employeeAddresses) {
		this.employeeAddresses = employeeAddresses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "addressByShipToAddressId")
	public Set<Sale> getSalesForShipToAddressId() {
		return this.salesForShipToAddressId;
	}

	public void setSalesForShipToAddressId(Set<Sale> salesForShipToAddressId) {
		this.salesForShipToAddressId = salesForShipToAddressId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<CustomerAddress> getCustomerAddresses() {
		return this.customerAddresses;
	}

	public void setCustomerAddresses(Set<CustomerAddress> customerAddresses) {
		this.customerAddresses = customerAddresses;
	}

}
