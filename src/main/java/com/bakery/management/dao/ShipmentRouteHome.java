package com.bakery.management.dao;

import com.bakery.management.domain.ShipmentRoute;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ShipmentRoute.
 *
 * @author Hibernate Tools
 * @see ShipmentRoute
 */
public class ShipmentRouteHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(ShipmentRouteHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance ShipmentRoute entity to persist
     */
    public void persist(final ShipmentRoute transientInstance) {
        LOG.debug("persisting ShipmentRoute instance");
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
     * @param persistentInstance ShipmentRoute entity to remove
     */
    public void remove(final ShipmentRoute persistentInstance) {
        LOG.debug("removing ShipmentRoute instance");
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
     * @param detachedInstance ShipmentRoute entity to merge
     * @return ShipmentRoute
     */
    public ShipmentRoute merge(final ShipmentRoute detachedInstance) {
        LOG.debug("merging ShipmentRoute instance");
        try {
            ShipmentRoute result = entityManager.merge(detachedInstance);
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
     * @return ShipmentRoute
     */
    public ShipmentRoute findById(final int id) {
        LOG.debug("getting ShipmentRoute instance with id: " + id);
        try {
            ShipmentRoute instance = entityManager
                    .find(ShipmentRoute.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
