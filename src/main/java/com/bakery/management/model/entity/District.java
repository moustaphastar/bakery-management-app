package com.bakery.management.model.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "District", schema = "dbo", catalog = "bakery")
public class District implements java.io.Serializable {

	private int id;
	private City city;
	private String name;
	private Set<Address> addresses = new HashSet<>(0);

	public District() {
	}

	public District(int id, City city, String name) {
		this.id = id;
		this.city = city;
		this.name = name;
	}

	public District(int id, City city, String name, Set<Address> addresses) {
		this.id = id;
		this.city = city;
		this.name = name;
		this.addresses = addresses;
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
	@JoinColumn(name = "CityId", nullable = false)
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "district")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
