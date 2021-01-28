package com.bakery.management.model.entity;

import com.bakery.management.enums.DocumentType;
import com.bakery.management.enums.OrderStatus;
import com.bakery.management.enums.ShipmentMethod;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Sale", schema = "dbo", catalog = "bakery")
public class Sale implements java.io.Serializable {

	private int id;
	private Address addressByBillToAddressId;
	private Address addressByShipToAddressId;
	private Customer customer;
	private Merchant merchant;
	private Date orderDate;
	private Date dueDate;
	private Date shipDate;
	private Date deliveryDate;
	private BigDecimal subTotal;
	private BigDecimal taxAmount;
	private BigDecimal totalDue;
	private ShipmentMethod shipmentMethod;
	private boolean onlineOrderFlag;
	private DocumentType documentType;
	private OrderStatus status;
	private Date lastUpdate;
	private boolean active;
	private Set<DocumentInvoice> documentInvoices = new HashSet<>(0);
	private Set<SaleDetail> saleDetails = new HashSet<>(0);

	public Sale() {
	}

	public Sale(int id, Customer customer, Merchant merchant, Date orderDate, Date dueDate, BigDecimal subTotal,
				BigDecimal taxAmount, boolean onlineOrderFlag, OrderStatus status, Date lastUpdate, boolean active) {
		this.id = id;
		this.customer = customer;
		this.merchant = merchant;
		this.orderDate = orderDate;
		this.dueDate = dueDate;
		this.subTotal = subTotal;
		this.taxAmount = taxAmount;
		this.onlineOrderFlag = onlineOrderFlag;
		this.status = status;
		this.lastUpdate = lastUpdate;
		this.active = active;
	}

	public Sale(int id, Address addressByBillToAddressId, Address addressByShipToAddressId, Customer customer,
				Merchant merchant, Date orderDate, Date dueDate, Date shipDate, Date deliveryDate, BigDecimal subTotal,
				BigDecimal taxAmount, BigDecimal totalDue, ShipmentMethod shipmentMethod, boolean onlineOrderFlag,
				DocumentType documentType, OrderStatus status, Date lastUpdate, boolean active, Set<DocumentInvoice> documentInvoices,
				Set<SaleDetail> saleDetails) {
		this.id = id;
		this.addressByBillToAddressId = addressByBillToAddressId;
		this.addressByShipToAddressId = addressByShipToAddressId;
		this.customer = customer;
		this.merchant = merchant;
		this.orderDate = orderDate;
		this.dueDate = dueDate;
		this.shipDate = shipDate;
		this.deliveryDate = deliveryDate;
		this.subTotal = subTotal;
		this.taxAmount = taxAmount;
		this.totalDue = totalDue;
		this.shipmentMethod = shipmentMethod;
		this.onlineOrderFlag = onlineOrderFlag;
		this.documentType = documentType;
		this.status = status;
		this.lastUpdate = lastUpdate;
		this.active = active;
		this.documentInvoices = documentInvoices;
		this.saleDetails = saleDetails;
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
	@JoinColumn(name = "BillToAddressId")
	public Address getAddressByBillToAddressId() {
		return this.addressByBillToAddressId;
	}

	public void setAddressByBillToAddressId(Address addressByBillToAddressId) {
		this.addressByBillToAddressId = addressByBillToAddressId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipToAddressId")
	public Address getAddressByShipToAddressId() {
		return this.addressByShipToAddressId;
	}

	public void setAddressByShipToAddressId(Address addressByShipToAddressId) {
		this.addressByShipToAddressId = addressByShipToAddressId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CustomerId", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MerchantId", nullable = false)
	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "OrderDate", nullable = false, length = 19)
	public Date getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DueDate", nullable = false, length = 10)
	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ShipDate", length = 19)
	public Date getShipDate() {
		return this.shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DeliveryDate", length = 19)
	public Date getDeliveryDate() {
		return this.deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = "SubTotal", nullable = false, precision = 9)
	public BigDecimal getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	@Column(name = "TaxAmount", nullable = false, precision = 9)
	public BigDecimal getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	@Column(name = "TotalDue", precision = 10)
	public BigDecimal getTotalDue() {
		return this.totalDue;
	}

	public void setTotalDue(BigDecimal totalDue) {
		this.totalDue = totalDue;
	}

	//@Convert(converter = ShipmentMethodConverter.class)
	@Column(name = "ShipmentMethod", length = 1)
	public ShipmentMethod getShipmentMethod() {
		return this.shipmentMethod;
	}

	public void setShipmentMethod(ShipmentMethod shipmentMethod) {
		this.shipmentMethod = shipmentMethod;
	}

	@Column(name = "OnlineOrderFlag", nullable = false)
	public boolean isOnlineOrderFlag() {
		return this.onlineOrderFlag;
	}

	public void setOnlineOrderFlag(boolean onlineOrderFlag) {
		this.onlineOrderFlag = onlineOrderFlag;
	}

	//@Convert(converter = DocumentTypeConverter.class)
	@Column(name = "DocumentType", length = 1)
	public DocumentType getDocumentType() {
		return this.documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}

	//@Convert(converter = OrderStatusConverter.class)
	@Column(name = "Status", nullable = false, length = 1)
	public OrderStatus getStatus() {
		return this.status;
	}

	public void setStatus(OrderStatus status) {
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
	public boolean isActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
	public Set<DocumentInvoice> getDocumentInvoices() {
		return this.documentInvoices;
	}

	public void setDocumentInvoices(Set<DocumentInvoice> documentInvoices) {
		this.documentInvoices = documentInvoices;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
	public Set<SaleDetail> getSaleDetails() {
		return this.saleDetails;
	}

	public void setSaleDetails(Set<SaleDetail> saleDetails) {
		this.saleDetails = saleDetails;
	}

}
