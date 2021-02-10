package com.bakery.management.dao;

import com.bakery.management.domain.Vehicle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Vehicle.
 *
 * @author Hibernate Tools
 * @see Vehicle
 */
public class VehicleHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(VehicleHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Vehicle entity to persist
     */
    public void persist(final Vehicle transientInstance) {
        LOG.debug("persisting Vehicle instance");
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
     * @param persistentInstance Vehicle entity to remove
     */
    public void remove(final Vehicle persistentInstance) {
        LOG.debug("removing Vehicle instance");
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
     * @param detachedInstance Vehicle entity to merge
     * @return Vehicle
     */
    public Vehicle merge(final Vehicle detachedInstance) {
        LOG.debug("merging Vehicle instance");
        try {
            Vehicle result = entityManager.merge(detachedInstance);
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
     * @return Vehicle
     */
    public Vehicle findById(final int id) {
        LOG.debug("getting Vehicle instance with id: " + id);
        try {
            Vehicle instance = entityManager.find(Vehicle.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
