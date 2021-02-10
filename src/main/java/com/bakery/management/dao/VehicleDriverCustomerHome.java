package com.bakery.management.dao;

import com.bakery.management.domain.DriverCustomer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class DriverCustomer.
 *
 * @author Hibernate Tools
 * @see DriverCustomer
 */
public class VehicleDriverCustomerHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(VehicleDriverCustomerHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance DriverCustomer entity to persist
     */
    public void persist(final DriverCustomer transientInstance) {
        LOG.debug("persisting DriverCustomer instance");
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
     * @param persistentInstance DriverCustomer entity to remove
     */
    public void remove(final DriverCustomer persistentInstance) {
        LOG.debug("removing DriverCustomer instance");
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
     * @param detachedInstance DriverCustomer entity to merge
     * @return DriverCustomer
     */
    public DriverCustomer merge(final DriverCustomer detachedInstance) {
        LOG.debug("merging DriverCustomer instance");
        try {
            DriverCustomer result = entityManager.merge(detachedInstance);
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
     * @return DriverCustomer
     */
    public DriverCustomer findById(final int id) {
        LOG.debug("getting DriverCustomer instance with id: " + id);
        try {
            DriverCustomer instance = entityManager
                    .find(DriverCustomer.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
