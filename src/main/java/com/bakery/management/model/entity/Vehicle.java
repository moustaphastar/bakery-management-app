package com.bakery.management.model.entity;

import com.bakery.management.enums.VehicleServiceType;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Vehicle", schema = "dbo", catalog = "bakery")
public class Vehicle implements java.io.Serializable {

    private int id;
    private Merchant merchant;
    private String plateNumber;
    private Date assessmentDate;
    private Date assuranceRenewalDate;
    private boolean outOfOrderFlag;
    private VehicleServiceType serviceType;
    private Date lastUpdate;
    private boolean active;
    private Set<VehicleDriver> vehicleDrivers = new HashSet<>(0);

    public Vehicle() {
    }

    public Vehicle(int id, Merchant merchant, String plateNumber, Date assessmentDate, boolean outOfOrderFlag,
                   Date lastUpdate, boolean active) {
        this.id = id;
        this.merchant = merchant;
        this.plateNumber = plateNumber;
        this.assessmentDate = assessmentDate;
        this.outOfOrderFlag = outOfOrderFlag;
        this.lastUpdate = lastUpdate;
        this.active = active;
    }

    public Vehicle(int id, Merchant merchant, String plateNumber, Date assessmentDate, Date assuranceRenewalDate,
                   boolean outOfOrderFlag, VehicleServiceType serviceType, Date lastUpdate, boolean active, Set<VehicleDriver> vehicleDrivers) {
        this.id = id;
        this.merchant = merchant;
        this.plateNumber = plateNumber;
        this.assessmentDate = assessmentDate;
        this.assuranceRenewalDate = assuranceRenewalDate;
        this.outOfOrderFlag = outOfOrderFlag;
        this.serviceType = serviceType;
        this.lastUpdate = lastUpdate;
        this.active = active;
        this.vehicleDrivers = vehicleDrivers;
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

	@Column(name = "PlateNumber", nullable = false, length = 15)
	public String getPlateNumber() {
		return this.plateNumber;
	}

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "AssessmentDate", nullable = false, length = 10)
    public Date getAssessmentDate() {
        return this.assessmentDate;
    }

    public void setAssessmentDate(Date assessmentDate) {
        this.assessmentDate = assessmentDate;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "AssuranceRenewalDate", length = 10)
    public Date getAssuranceRenewalDate() {
        return this.assuranceRenewalDate;
    }

    public void setAssuranceRenewalDate(Date assuranceRenewalDate) {
        this.assuranceRenewalDate = assuranceRenewalDate;
	}

    @Column(name = "OutOfOrderFlag", nullable = false)
    public boolean isOutOfOrderFlag() {
        return this.outOfOrderFlag;
    }

    public void setOutOfOrderFlag(boolean outOfOrderFlag) {
        this.outOfOrderFlag = outOfOrderFlag;
    }

    //@Convert(converter = VehicleServiceType.class)
    @Column(name = "ServiceType", length = 1)
    public VehicleServiceType getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(VehicleServiceType serviceType) {
        this.serviceType = serviceType;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
	public Set<VehicleDriver> getVehicleDrivers() {
		return this.vehicleDrivers;
	}

	public void setVehicleDrivers(Set<VehicleDriver> vehicleDrivers) {
		this.vehicleDrivers = vehicleDrivers;
	}

}
