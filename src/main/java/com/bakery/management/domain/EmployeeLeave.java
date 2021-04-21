package com.bakery.management.domain;

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
@Table(name = "EmployeeLeave", schema = "public")
public class EmployeeLeave implements java.io.Serializable {

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
     * Beginning date of leave.
     */
    @Column(name = "LaeveFrom", nullable = false, length = 19)
    private OffsetDateTime leaveFrom;

    /***
     * Ending date of leave.
     */
    @Column(name = "LeaveTo", length = 19)
    private OffsetDateTime leaveTo;

    /***
     * Date and time of first persisting with an offset.
     */
    @Column(name = "InsertedAt", nullable = false, length = 19)
    private OffsetDateTime insertedAt;

    /***
     * State of existence in persistence.
     */
    @Column(name = "Active", nullable = false)
    private boolean active;

    /***
     * Class constructor.
     */
    public EmployeeLeave() {
    }

}
