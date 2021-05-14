package com.bakery.management.domain;

import com.bakery.management.enums.AddressType;
import com.bakery.management.enums.converters.AddressTypeConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Column;
import javax.persistence.Convert;
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
@Table(schema = "public")
public class MerchantAddress implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Address} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId", nullable = false)
    private Address address;

    /***
     * Foreign key to parent {@link Address} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private int addressId;

    /***
     * Parent {@link Merchant} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "merchantId", nullable = false)
    private Merchant merchant;

    /***
     * Foreign key to parent {@link Merchant} entity Id.
     */
    @Column(nullable = false, updatable = false,
            insertable = false)
    private UUID merchantId;

    /***
     * Type of address from {@link AddressType}
     * Enum constant is converted to enum value
     * before persisting to database.
     */
    @Convert(converter = AddressTypeConverter.class)
    @Column(nullable = false)
    private AddressType description;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(nullable = false)
    @Generated(value = GenerationTime.INSERT)
    private OffsetDateTime insertedDate;

    /***
     * Application user id who committed the insert.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID insertedBy;

    /***
     * Date and time of last update with an offset.
     */
    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    /***
     * Application user id who committed the last update.
     * Corresponds to an authorized employee id.
     */
    @Column(nullable = false)
    private UUID lastUpdatedBy;

    /***
     * State of existence in persistence.
     */
    @Column(nullable = false)
    private boolean active;

    /***
     * Class constructor.
     */
    public MerchantAddress() {
    }

}
