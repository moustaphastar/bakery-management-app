package com.bakery.management.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Job", schema = "public", catalog = "bakery")
public class Job implements java.io.Serializable {

	private int id;
	private Merchant merchant;
	private String title;
	private Date lastUpdate;
	private boolean active;
	private Set<Employee> employees = new HashSet<>(0);

	public Job() {
	}

	public Job(int id, Merchant merchant, String title, Date lastUpdate, boolean active) {
		this.id = id;
		this.merchant = merchant;
		this.title = title;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public Job(int id, Merchant merchant, String title, Date lastUpdate, boolean active, Set<Employee> employees) {
		this.id = id;
		this.merchant = merchant;
		this.title = title;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.employees = employees;
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
	@JoinColumn(name = "MerchantId", nullable = false)
	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Column(name = "Title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "job")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
