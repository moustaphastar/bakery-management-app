package com.bakery.management.dao;

import com.bakery.management.domain.Order;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Order.
 *
 * @author Hibernate Tools
 * @see Order
 */
public class SaleHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(SaleHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Order entity to persist
     */
    public void persist(final Order transientInstance) {
        LOG.debug("persisting Order instance");
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
     * @param persistentInstance Order entity to remove
     */
    public void remove(final Order persistentInstance) {
        LOG.debug("removing Order instance");
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
     * @param detachedInstance Order entity to merge
     * @return Order
     */
    public Order merge(final Order detachedInstance) {
        LOG.debug("merging Order instance");
        try {
            Order result = entityManager.merge(detachedInstance);
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
     * @return Order
     */
    public Order findById(final int id) {
        LOG.debug("getting Order instance with id: " + id);
        try {
            Order instance = entityManager.find(Order.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
