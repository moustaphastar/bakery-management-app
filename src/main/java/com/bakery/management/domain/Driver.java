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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
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
@Table(name = "VehicleDriver", schema = "dbo", catalog = "onlineaccounting")
public class Driver implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Employee} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeId", nullable = false)
    private Employee employee;

    /***
     * Foreign key to parent {@link Employee} entity Id.
     */
    @Column(name = "EmployeeId", nullable = false, updatable = false,
            insertable = false)
    private UUID employeeId;

    /***
     * Parent {@link Vehicle} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VehicleId", nullable = false)
    private Vehicle vehicle;

    /***
     * Foreign key to parent {@link Vehicle} entity Id.
     */
    @Column(name = "VehicleId", nullable = false, updatable = false,
            insertable = false)
    private int vehicleId;

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
     * Set of child {@link DriverCustomer} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private Set<DriverCustomer> driverCustomers = new HashSet<>(0);

    /***
     * Set of child {@link ShipmentRoute} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private Set<ShipmentRoute> shipmentRoutes = new HashSet<>(0);

    /***
     * Set of child {@link Shipment} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    private Set<Shipment> shipments = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Driver() {
    }

}
