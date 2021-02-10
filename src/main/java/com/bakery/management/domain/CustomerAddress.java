package com.bakery.management.domain;

import com.bakery.management.enums.AddressType;
import com.bakery.management.enums.converters.AddressTypeConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
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
 * Domain model class to hold customer address data.
 * @since 1.0
 * @author Moustapha Star
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "CustomerAddress", schema = "dbo", catalog = "onlineaccounting")
public class CustomerAddress implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Address} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AddressId", nullable = false)
    private Address address;

    /***
     * Foreign key to parent {@link Address} entity Id.
     */
    @Column(name = "AddressId", nullable = false, updatable = false,
            insertable = false)
    private int addressId;

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
     * Type of address from {@link AddressType}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    // todo: Enhance Javadoc. Add converter info. Apply doc to all enum fields.
    @Convert(converter = AddressTypeConverter.class)
    @Column(name = "Description", nullable = false, length = 1)
    private AddressType description;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false, length = 19)
    private OffsetDateTime lastUpdate;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link ShipmentRouteIndex} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customerAddress")
    private Set<ShipmentRouteIndex> shipmentRouteIndexes = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public CustomerAddress() {
    }

}
