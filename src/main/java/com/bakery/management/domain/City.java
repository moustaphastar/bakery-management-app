package com.bakery.management.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "City", schema = "public")
public class City implements java.io.Serializable {

	private int id;
	private Country country;
	private String name;
	private Set<District> districts = new HashSet<>(0);

	public City() {
	}

	public City(int id, Country country, String name) {
		this.id = id;
		this.country = country;
		this.name = name;
	}

	public City(int id, Country country, String name, Set<District> districts) {
		this.id = id;
		this.country = country;
		this.name = name;
		this.districts = districts;
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
	@JoinColumn(name = "CountryId", nullable = false)
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
	public Set<District> getDistricts() {
		return this.districts;
	}

	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}

}
