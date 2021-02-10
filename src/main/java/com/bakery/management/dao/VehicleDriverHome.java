package com.bakery.management.dao;

import com.bakery.management.domain.Driver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Driver.
 *
 * @author Hibernate Tools
 * @see Driver
 */
public class VehicleDriverHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(VehicleDriverHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Driver entity to persist
     */
    public void persist(final Driver transientInstance) {
        LOG.debug("persisting Driver instance");
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
     * @param persistentInstance Driver entity to remove
     */
    public void remove(final Driver persistentInstance) {
        LOG.debug("removing Driver instance");
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
     * @param detachedInstance Driver entity to merge
     * @return Driver
     */
    public Driver merge(final Driver detachedInstance) {
        LOG.debug("merging Driver instance");
        try {
            Driver result = entityManager.merge(detachedInstance);
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
     * @return Driver
     */
    public Driver findById(final int id) {
        LOG.debug("getting Driver instance with id: " + id);
        try {
            Driver instance = entityManager.find(Driver.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
