package com.bakery.management.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.UUID;

/***
 * Domain model class to hold user data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "VehicleDriverCustomer", schema = "dbo",
        catalog = "onlineaccounting")
public class DriverCustomer implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Customer} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;

    /***
     * Foreign key to parent {@link Customer} entity Id.
     */
    @Column(name = "CustomerId", nullable = false, updatable = false,
            insertable = false)
    private UUID customerId;

    /***
     * Parent {@link Driver} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DriverId", nullable = false)
    private Driver driver;

    /***
     * Foreign key to parent {@link Driver} entity Id.
     */
    @Column(name = "DriverId", nullable = false, updatable = false,
            insertable = false)
    private int vehicleDriverId;

    /***
     * Beginning date of validity.
     */
    @Column(name = "ValidFrom", nullable = false, length = 19)
    private OffsetDateTime validFrom;

    /***
     * Ending date of validity.
     */
    @Column(name = "ValidTo", length = 19)
    private OffsetDateTime validTo;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Class constructor.
     */
    public DriverCustomer() {
    }

}
