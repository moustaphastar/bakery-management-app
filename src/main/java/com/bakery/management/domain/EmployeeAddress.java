package com.bakery.management.domain;

import com.bakery.management.enums.AddressType;
import com.bakery.management.enums.converters.AddressTypeConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
@Table(name = "EmployeeAddress", schema = "public")
public class EmployeeAddress implements java.io.Serializable {

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
     * Type of address from {@link AddressType}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = AddressTypeConverter.class)
    @Column(name = "Description", nullable = false)
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
     * Class constructor.
     */
    public EmployeeAddress() {
    }

}
