package com.bakery.management.domain;

import com.bakery.management.enums.AddressType;
import com.bakery.management.enums.converters.AddressTypeConverter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MerchantAddress", schema = "dbo", catalog = "bakery")
public class MerchantAddress implements java.io.Serializable {

    private int id;
    private Address address;
    private Merchant merchant;
    private AddressType description;
    private Date lastUpdate;
    private boolean active;

    public MerchantAddress() {
    }

    public MerchantAddress(int id, Address address, Merchant merchant, AddressType description, Date lastUpdate,
                           boolean active) {
        this.id = id;
        this.address = address;
        this.merchant = merchant;
        this.description = description;
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
	@JoinColumn(name = "AddressId", nullable = false)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CompanyId", nullable = false)
    public Merchant getMerchant() {
        return this.merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    @Convert(converter = AddressTypeConverter.class)
    @Column(name = "Description", nullable = false)
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

}
