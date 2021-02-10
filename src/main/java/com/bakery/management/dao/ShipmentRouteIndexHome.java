package com.bakery.management.dao;

import com.bakery.management.domain.ShipmentRouteIndex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ShipmentRouteIndex.
 *
 * @author Hibernate Tools
 * @see ShipmentRouteIndex
 */
public class ShipmentRouteIndexHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(ShipmentRouteIndexHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance ShipmentRouteIndex entity to persist
     */
    public void persist(final ShipmentRouteIndex transientInstance) {
        LOG.debug("persisting ShipmentRouteIndex instance");
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
     * @param persistentInstance ShipmentRouteIndex entity to remove
     */
    public void remove(final ShipmentRouteIndex persistentInstance) {
        LOG.debug("removing ShipmentRouteIndex instance");
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
     * @param detachedInstance ShipmentRouteIndex entity to merge
     * @return ShipmentRouteIndex
     */
    public ShipmentRouteIndex merge(final ShipmentRouteIndex detachedInstance) {
        LOG.debug("merging ShipmentRouteIndex instance");
        try {
            ShipmentRouteIndex result = entityManager.merge(detachedInstance);
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
     * @return ShipmentRouteIndex
     */
    public ShipmentRouteIndex findById(final int id) {
        LOG.debug("getting ShipmentRouteIndex instance with id: " + id);
        try {
            ShipmentRouteIndex instance = entityManager
                    .find(ShipmentRouteIndex.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
