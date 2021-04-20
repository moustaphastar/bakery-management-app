package com.bakery.management.domain;

import com.bakery.management.enums.ShipmentLoadStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ShipmentLoad", schema = "public", catalog = "bakery")
public class ShipmentLoad implements java.io.Serializable {

	private int id;
	private SaleDetail saleDetail;
	private Shipment shipment;
	private Date deliveryDate;
	private int returnedQuantity;
	private ShipmentLoadStatus status;
	private Date lastUpdate;
	private int active;
	private Set<DocumentShipment> documentShipments = new HashSet<>(0);

	public ShipmentLoad() {
	}

	public ShipmentLoad(int id, SaleDetail saleDetail, Shipment shipment, int returnedQuantity, ShipmentLoadStatus status,
						Date lastUpdate, int active) {
		this.id = id;
		this.saleDetail = saleDetail;
		this.shipment = shipment;
		this.returnedQuantity = returnedQuantity;
		this.status = status;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public ShipmentLoad(int id, SaleDetail saleDetail, Shipment shipment, Date deliveryDate, int returnedQuantity,
						ShipmentLoadStatus status, Date lastUpdate, int active, Set<DocumentShipment> documentShipments) {
		this.id = id;
		this.saleDetail = saleDetail;
		this.shipment = shipment;
		this.deliveryDate = deliveryDate;
		this.returnedQuantity = returnedQuantity;
		this.status = status;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.documentShipments = documentShipments;
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
	@JoinColumn(name = "SaleDetailId", nullable = false)
	public SaleDetail getSaleDetail() {
		return this.saleDetail;
	}

	public void setSaleDetail(SaleDetail saleDetail) {
		this.saleDetail = saleDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentId", nullable = false)
	public Shipment getShipment() {
		return this.shipment;
	}

	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DeliveryDate", length = 19)
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

    @Column(name = "ReturnedQuantity", nullable = false)
    public int getReturnedQuantity() {
        return this.returnedQuantity;
    }

    public void setReturnedQuantity(int returnedQuantity) {
        this.returnedQuantity = returnedQuantity;
    }

    //@Convert(converter = ShipmentLoadStatus.class)
    @Column(name = "Status", nullable = false, length = 1)
    public ShipmentLoadStatus getStatus() {
        return this.status;
    }

    public void setStatus(ShipmentLoadStatus status) {
        this.status = status;
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
	public int getActive() {
		return this.active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shipmentLoad")
	public Set<DocumentShipment> getDocumentShipments() {
		return this.documentShipments;
	}

	public void setDocumentShipments(Set<DocumentShipment> documentShipments) {
		this.documentShipments = documentShipments;
	}

}
