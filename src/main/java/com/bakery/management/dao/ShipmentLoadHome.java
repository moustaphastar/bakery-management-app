package com.bakery.management.dao;

import com.bakery.management.domain.ShipmentLoad;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ShipmentLoad.
 *
 * @author Hibernate Tools
 * @see ShipmentLoad
 */
public class ShipmentLoadHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(ShipmentLoadHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance ShipmentLoad entity to persist
     */
    public void persist(final ShipmentLoad transientInstance) {
        LOG.debug("persisting ShipmentLoad instance");
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
     * @param persistentInstance ShipmentLoad entity to remove
     */
    public void remove(final ShipmentLoad persistentInstance) {
        LOG.debug("removing ShipmentLoad instance");
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
     * @param detachedInstance ShipmentLoad entity to merge
     * @return ShipmentLoad
     */
    public ShipmentLoad merge(final ShipmentLoad detachedInstance) {
        LOG.debug("merging ShipmentLoad instance");
        try {
            ShipmentLoad result = entityManager.merge(detachedInstance);
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
     * @return ShipmentLoad
     */
    public ShipmentLoad findById(final int id) {
        LOG.debug("getting ShipmentLoad instance with id: " + id);
        try {
            ShipmentLoad instance = entityManager.find(ShipmentLoad.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
