package com.bakery.management.model.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CustomerType", schema = "dbo", catalog = "bakery")
public class CustomerType implements java.io.Serializable {

	private int id;
	private String name;
	private Date insertedAt;
	private boolean active;
	private Set<Customer> customers = new HashSet<>(0);

	public CustomerType() {
	}

	public CustomerType(int id, String name, Date insertedAt, boolean active) {
		this.id = id;
		this.name = name;
		this.insertedAt = insertedAt;
		this.active = active;
	}

	public CustomerType(int id, String name, Date insertedAt, boolean active, Set<Customer> customers) {
		this.id = id;
		this.name = name;
		this.insertedAt = insertedAt;
		this.active = active;
		this.customers = customers;
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

	@Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customerType")
	public Set<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

}
