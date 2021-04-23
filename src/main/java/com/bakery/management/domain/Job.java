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
@Table(name = "Job", schema = "public")
public class Job implements java.io.Serializable {

    /***
     * Id of the entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;

    /***
     * Parent {@link Merchant} entity with many to one relation.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MerchantId", nullable = false)
    private Merchant merchant;

    /***
     * Foreign key to parent {@link Merchant} entity Id.
     */
    @Column(name = "MerchantId", nullable = false, updatable = false,
            insertable = false)
    private UUID merchantId;

    /***
     * Job title.
     */
    @Column(name = "Title", nullable = false)
    private String title;

    /***
     * Date and time of insertion with an offset.
     */
    @Column(name = "InsertDate", nullable = false)
    private OffsetDateTime insertedDate;

    /***
     * Application user id who committed the insert.
     * Corresponds to an authorized employee id.
     */
    @Column(name = "InsertedBy", nullable = false)
    private UUID insertedBy;

    /***
     * Date and time of last update with an offset.
     */
    @Column(name = "LastUpdate", nullable = false)
    private OffsetDateTime lastUpdate;

    /***
     * Application user id who committed the last update.
     * Corresponds to an authorized employee id.
     */
    @Column(name = "LastUpdatedBy", nullable = false)
    private UUID lastUpdatedBy;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Set of child {@link Employee} with one to many relation.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "job")
    private Set<Employee> employees = new HashSet<>(0);

    /***
     * Class constructor.
     */
    public Job() {
    }

}
