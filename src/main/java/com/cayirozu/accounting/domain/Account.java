/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cayirozu.accounting.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bahar
 */
@Entity
@Table(name = "Account")
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
        @NamedQuery(name = "Account.findById", query = "SELECT a FROM Account a WHERE a.id = :id"),
        @NamedQuery(name = "Account.findByFiscalYear", query = "SELECT a FROM Account a WHERE a.fiscalYear = :fiscalYear"),
        @NamedQuery(name = "Account.findByTotalReceived", query = "SELECT a FROM Account a WHERE a.totalReceived = :totalReceived"),
        @NamedQuery(name = "Account.findByTotalPaid", query = "SELECT a FROM Account a WHERE a.totalPaid = :totalPaid"),
        @NamedQuery(name = "Account.findByOutstandingBalance", query = "SELECT a FROM Account a WHERE a.outstandingBalance = :outstandingBalance"),
        @NamedQuery(name = "Account.findByBalance", query = "SELECT a FROM Account a WHERE a.balance = :balance"),
        @NamedQuery(name = "Account.findByRegularInvoiceLimit", query = "SELECT a FROM Account a WHERE a.regularInvoiceLimit = :regularInvoiceLimit"),
        @NamedQuery(name = "Account.findByLastUpdate", query = "SELECT a FROM Account a WHERE a.lastUpdate = :lastUpdate"),
        @NamedQuery(name = "Account.findByActive", query = "SELECT a FROM Account a WHERE a.active = :active")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FiscalYear")
    private int fiscalYear;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalReceived")
    private BigDecimal totalReceived;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TotalPaid")
    private BigDecimal totalPaid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OutstandingBalance")
    private BigDecimal outstandingBalance;
    @Column(name = "Balance")
    private BigDecimal balance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RegularInvoiceLimit")
    private BigDecimal regularInvoiceLimit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LastUpdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Active")
    private boolean active;

    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, int fiscalYear, BigDecimal totalReceived, BigDecimal totalPaid, BigDecimal outstandingBalance, BigDecimal regularInvoiceLimit, Date lastUpdate, boolean active) {
        this.id = id;
        this.fiscalYear = fiscalYear;
        this.totalReceived = totalReceived;
        this.totalPaid = totalPaid;
        this.outstandingBalance = outstandingBalance;
        this.regularInvoiceLimit = regularInvoiceLimit;
        this.lastUpdate = lastUpdate;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFiscalYear() {
        return fiscalYear;
    }

    public void setFiscalYear(int fiscalYear) {
        this.fiscalYear = fiscalYear;
    }

    public BigDecimal getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(BigDecimal totalReceived) {
        this.totalReceived = totalReceived;
    }

    public BigDecimal getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(BigDecimal totalPaid) {
        this.totalPaid = totalPaid;
    }

    public BigDecimal getOutstandingBalance() {
        return outstandingBalance;
    }

    public void setOutstandingBalance(BigDecimal outstandingBalance) {
        this.outstandingBalance = outstandingBalance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getRegularInvoiceLimit() {
        return regularInvoiceLimit;
    }

    public void setRegularInvoiceLimit(BigDecimal regularInvoiceLimit) {
        this.regularInvoiceLimit = regularInvoiceLimit;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domains.Account[ id=" + id + " ]";
    }

}
