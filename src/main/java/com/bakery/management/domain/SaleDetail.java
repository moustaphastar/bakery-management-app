package com.bakery.management.domain;

import com.bakery.management.enums.OrderItemStatus;
import com.bakery.management.enums.ShipmentPartOfDay;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "SaleDetail", schema = "dbo", catalog = "bakery")
public class SaleDetail implements java.io.Serializable {

    private int id;
    private Product product;
    private Sale sale;
    private String carrierTrackingNumber;
    private int quantity;
    private BigDecimal unitPrice;
    private BigDecimal lineTotal;
    private BigDecimal taxAmount;
    private BigDecimal totalDue;
    private ShipmentPartOfDay shipmentPartOfDay;
    private Date lastUpdate;
    private OrderItemStatus status;
    private boolean active;
    private Set<ShipmentLoad> shipmentLoads = new HashSet<>(0);

    public SaleDetail() {
    }

    public SaleDetail(int id, Product product, Sale sale, int quantity, BigDecimal unitPrice, BigDecimal lineTotal,
                      BigDecimal taxAmount, BigDecimal totalDue, ShipmentPartOfDay shipmentPartOfDay, Date lastUpdate, OrderItemStatus status,
                      boolean active) {
        this.id = id;
        this.product = product;
        this.sale = sale;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.lineTotal = lineTotal;
        this.taxAmount = taxAmount;
        this.totalDue = totalDue;
        this.shipmentPartOfDay = shipmentPartOfDay;
        this.lastUpdate = lastUpdate;
        this.status = status;
        this.active = active;
    }

	public SaleDetail(int id, Product product, Sale sale, String carrierTrackingNumber, int quantity,
                      BigDecimal unitPrice, BigDecimal lineTotal, BigDecimal taxAmount, BigDecimal totalDue, ShipmentPartOfDay shipmentPartOfDay,
                      Date lastUpdate, OrderItemStatus status, boolean active, Set<ShipmentLoad> shipmentLoads) {
        this.id = id;
        this.product = product;
        this.sale = sale;
        this.carrierTrackingNumber = carrierTrackingNumber;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.lineTotal = lineTotal;
        this.taxAmount = taxAmount;
        this.totalDue = totalDue;
        this.shipmentPartOfDay = shipmentPartOfDay;
        this.lastUpdate = lastUpdate;
        this.status = status;
        this.active = active;
        this.shipmentLoads = shipmentLoads;
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
	@JoinColumn(name = "ProductId", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SaleId", nullable = false)
	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	@Column(name = "CarrierTrackingNumber")
	public String getCarrierTrackingNumber() {
		return this.carrierTrackingNumber;
	}

	public void setCarrierTrackingNumber(String carrierTrackingNumber) {
		this.carrierTrackingNumber = carrierTrackingNumber;
	}

	@Column(name = "Quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "UnitPrice", nullable = false, precision = 9)
	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "LineTotal", nullable = false, precision = 9)
	public BigDecimal getLineTotal() {
		return this.lineTotal;
	}

	public void setLineTotal(BigDecimal lineTotal) {
		this.lineTotal = lineTotal;
	}

	@Column(name = "TaxAmount", nullable = false, precision = 9)
	public BigDecimal getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

    @Column(name = "TotalDue", nullable = false, precision = 9)
    public BigDecimal getTotalDue() {
        return this.totalDue;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    //@Convert(converter = ShipmentPartOfDay.class)
    @Column(name = "ShipmentPartOfDay", nullable = false, length = 1)
    public ShipmentPartOfDay getShipmentPartOfDay() {
        return this.shipmentPartOfDay;
    }

    public void setShipmentPartOfDay(ShipmentPartOfDay shipmentPartOfDay) {
        this.shipmentPartOfDay = shipmentPartOfDay;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LastUpdate", nullable = false, length = 19)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    //@Convert(converter = OrderItemStatus.class)
    @Column(name = "Status", nullable = false, length = 1)
    public OrderItemStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderItemStatus status) {
        this.status = status;
    }

    @Column(name = "Active", nullable = false)
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "saleDetail")
	public Set<ShipmentLoad> getShipmentLoads() {
		return this.shipmentLoads;
	}

	public void setShipmentLoads(Set<ShipmentLoad> shipmentLoads) {
		this.shipmentLoads = shipmentLoads;
	}

}
