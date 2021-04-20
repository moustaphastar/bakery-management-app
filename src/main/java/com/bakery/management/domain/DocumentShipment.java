package com.bakery.management.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "DocumentShipment", schema = "public", catalog = "bakery")
public class DocumentShipment implements java.io.Serializable {

	private int id;
	private DocumentInvoice documentInvoice;
	private Merchant merchant;
	private ShipmentLoad shipmentLoad;
	private String customerId;
	private String referenceNumber;
	private String serialNumber;
	private Integer sequenceNumber;
	private Date issueDate;
	private BigDecimal subTotal;
	private BigDecimal taxAmount;
	private BigDecimal totalDue;
	private String deliveryPersonId;
	private String receiver;
	private Date deliveredAt;
	private String note;
	private boolean isPaperPrinted;
	private Date paperPrintedAt;
	private Date insertedAt;
	private Boolean isCancelled;
	private Boolean active;

	public DocumentShipment() {
	}

	public DocumentShipment(int id, Date issueDate, boolean isPaperPrinted, Date insertedAt) {
		this.id = id;
		this.issueDate = issueDate;
		this.isPaperPrinted = isPaperPrinted;
		this.insertedAt = insertedAt;
	}

	public DocumentShipment(int id, DocumentInvoice documentInvoice, Merchant merchant, ShipmentLoad shipmentLoad,
							String customerId, String referenceNumber, String serialNumber, Integer sequenceNumber,
							Date issueDate, BigDecimal subTotal, BigDecimal taxAmount, BigDecimal totalDue, String deliveryPersonId,
							String receiver, Date deliveredAt, String note, boolean isPaperPrinted, Date paperPrintedAt,
							Date insertedAt, Boolean isCancelled, Boolean active) {
		this.id = id;
		this.documentInvoice = documentInvoice;
		this.merchant = merchant;
		this.shipmentLoad = shipmentLoad;
		this.customerId = customerId;
		this.referenceNumber = referenceNumber;
		this.serialNumber = serialNumber;
		this.sequenceNumber = sequenceNumber;
		this.issueDate = issueDate;
		this.subTotal = subTotal;
		this.taxAmount = taxAmount;
		this.totalDue = totalDue;
		this.deliveryPersonId = deliveryPersonId;
		this.receiver = receiver;
		this.deliveredAt = deliveredAt;
		this.note = note;
		this.isPaperPrinted = isPaperPrinted;
		this.paperPrintedAt = paperPrintedAt;
		this.insertedAt = insertedAt;
		this.isCancelled = isCancelled;
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
	@JoinColumn(name = "InvoiceId")
	public DocumentInvoice getDocumentInvoice() {
		return this.documentInvoice;
	}

	public void setDocumentInvoice(DocumentInvoice documentInvoice) {
		this.documentInvoice = documentInvoice;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MerchantId")
	public Merchant getMerchant() {
		return this.merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ShipmentLoadId")
	public ShipmentLoad getShipmentLoad() {
		return this.shipmentLoad;
	}

	public void setShipmentLoad(ShipmentLoad shipmentLoad) {
		this.shipmentLoad = shipmentLoad;
	}

	@Column(name = "CustomerId", length = 36)
	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Column(name = "ReferenceNumber")
	public String getReferenceNumber() {
		return this.referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	@Column(name = "SerialNumber")
	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	@Column(name = "SequenceNumber")
	public Integer getSequenceNumber() {
		return this.sequenceNumber;
	}

	public void setSequenceNumber(Integer sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "IssueDate", nullable = false, length = 19)
	public Date getIssueDate() {
		return this.issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	@Column(name = "SubTotal", precision = 9)
	public BigDecimal getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	@Column(name = "TaxAmount", precision = 9)
	public BigDecimal getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	@Column(name = "TotalDue", precision = 9)
	public BigDecimal getTotalDue() {
		return this.totalDue;
	}

	public void setTotalDue(BigDecimal totalDue) {
		this.totalDue = totalDue;
	}

	@Column(name = "DeliveryPersonId", length = 36)
	public String getDeliveryPersonId() {
		return this.deliveryPersonId;
	}

	public void setDeliveryPersonId(String deliveryPersonId) {
		this.deliveryPersonId = deliveryPersonId;
	}

	@Column(name = "Receiver")
	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DeliveredAt", length = 19)
	public Date getDeliveredAt() {
		return this.deliveredAt;
	}

	public void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}

	@Column(name = "Note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "IsPaperPrinted", nullable = false)
	public boolean isIsPaperPrinted() {
		return this.isPaperPrinted;
	}

	public void setIsPaperPrinted(boolean isPaperPrinted) {
		this.isPaperPrinted = isPaperPrinted;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PaperPrintedAt", length = 19)
	public Date getPaperPrintedAt() {
		return this.paperPrintedAt;
	}

	public void setPaperPrintedAt(Date paperPrintedAt) {
		this.paperPrintedAt = paperPrintedAt;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "InsertedAt", nullable = false, length = 19)
	public Date getInsertedAt() {
		return this.insertedAt;
	}

	public void setInsertedAt(Date insertedAt) {
		this.insertedAt = insertedAt;
	}

	@Column(name = "IsCancelled")
	public Boolean getIsCancelled() {
		return this.isCancelled;
	}

	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}

	@Column(name = "Active")
	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
