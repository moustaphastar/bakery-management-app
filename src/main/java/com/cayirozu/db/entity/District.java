package com.cayirozu.db.entity;
// Generated 19 Ara 2020 06:35:03 by Hibernate Tools 5.2.12.Final

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Province generated by hbm2java
 */
@Entity
@Table(name = "Province", schema = "dbo", catalog = "onlineaccounting")
public class District implements java.io.Serializable {

	private int id;
	private City city;
	private Serializable name;
	private Set<Address> addresses = new HashSet<>(0);

	public District() {
	}

	public District(int id, City city, Serializable name) {
		this.id = id;
		this.city = city;
		this.name = name;
	}

	public District(int id, City city, Serializable name, Set<Address> addresses) {
		this.id = id;
		this.city = city;
		this.name = name;
		this.addresses = addresses;
	}

	@Id

	@Column(name = "Id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CityId", nullable = false)
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "Name", nullable = false)
	public Serializable getName() {
		return this.name;
	}

	public void setName(Serializable name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "province")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
