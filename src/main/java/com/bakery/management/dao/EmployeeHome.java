package com.bakery.management.dao;

import com.bakery.management.domain.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Employee.
 *
 * @author Hibernate Tools
 * @see Employee
 */
public class EmployeeHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(EmployeeHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Employee entity to persist
     */
    public void persist(final Employee transientInstance) {
        LOG.debug("persisting Employee instance");
        try {
            entityManager.persist(transientInstance);
            LOG.debug("persist successful");
        } catch (RuntimeException re) {
            LOG.error("persist failed", re);
            throw re;
        }
    }

    /***
     * Remove entity from database.
     * @param persistentInstance Employee entity to remove
     */
    public void remove(final Employee persistentInstance) {
        LOG.debug("removing Employee instance");
        try {
            entityManager.remove(persistentInstance);
            LOG.debug("remove successful");
        } catch (RuntimeException re) {
            LOG.error("remove failed", re);
            throw re;
        }
    }

    /***
     * Merge entity from database.
     * @param detachedInstance Employee entity to merge
     * @return Employee
     */
    public Employee merge(final Employee detachedInstance) {
        LOG.debug("merging Employee instance");
        try {
            Employee result = entityManager.merge(detachedInstance);
            LOG.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            LOG.error("merge failed", re);
            throw re;
        }
    }

    /***
     * Finds an entity from database.
     * @param id Id of the entity to find from database
     * @return Employee
     */
    public Employee findById(final String id) {
        LOG.debug("getting Employee instance with id: " + id);
        try {
            Employee instance = entityManager.find(Employee.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
