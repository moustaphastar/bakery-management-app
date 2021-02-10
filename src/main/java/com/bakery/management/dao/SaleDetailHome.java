package com.bakery.management.dao;

import com.bakery.management.domain.OrderItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class OrderItem.
 *
 * @author Hibernate Tools
 * @see OrderItem
 */
public class SaleDetailHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(SaleDetailHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance OrderItem entity to persist
     */
    public void persist(final OrderItem transientInstance) {
        LOG.debug("persisting OrderItem instance");
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
     * @param persistentInstance OrderItem entity to remove
     */
    public void remove(final OrderItem persistentInstance) {
        LOG.debug("removing OrderItem instance");
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
     * @param detachedInstance OrderItem entity to merge
     * @return OrderItem
     */
    public OrderItem merge(final OrderItem detachedInstance) {
        LOG.debug("merging OrderItem instance");
        try {
            OrderItem result = entityManager.merge(detachedInstance);
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
     * @return OrderItem
     */
    public OrderItem findById(final int id) {
        LOG.debug("getting OrderItem instance with id: " + id);
        try {
            OrderItem instance = entityManager.find(OrderItem.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
