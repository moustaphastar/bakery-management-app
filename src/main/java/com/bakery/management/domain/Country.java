package com.bakery.management.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Country", schema = "public", catalog = "bakery")
public class Country implements java.io.Serializable {

	private int id;
	private String iso2;
	private String iso3;
	private String name;
	private Set<City> cities = new HashSet<>(0);

	public Country() {
	}

	public Country(int id, String iso2, String name) {
		this.id = id;
		this.iso2 = iso2;
		this.name = name;
	}

	public Country(int id, String iso2, String iso3, String name, Set<City> cities) {
		this.id = id;
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.name = name;
		this.cities = cities;
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

	@Column(name = "ISO2", nullable = false, length = 2)
	public String getIso2() {
		return this.iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	@Column(name = "ISO3", length = 3)
	public String getIso3() {
		return this.iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	@Column(name = "Name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<City> getCities() {
		return this.cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

}
