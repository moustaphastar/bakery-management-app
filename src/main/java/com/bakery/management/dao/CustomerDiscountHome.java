package com.bakery.management.dao;

import com.bakery.management.domain.CustomerDiscount;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CustomerDiscount.
 *
 * @author Hibernate Tools
 * @see CustomerDiscount
 */
public class CustomerDiscountHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(CustomerDiscountHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance CustomerDiscount entity to persist
     */
    public void persist(final CustomerDiscount transientInstance) {
        LOG.debug("persisting CustomerDiscount instance");
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
     * @param persistentInstance CustomerDiscount entity to remove
     */
    public void remove(final CustomerDiscount persistentInstance) {
        LOG.debug("removing CustomerDiscount instance");
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
     * @param detachedInstance CustomerDiscount entity to merge
     * @return CustomerDiscount
     */
    public CustomerDiscount merge(final CustomerDiscount detachedInstance) {
        LOG.debug("merging CustomerDiscount instance");
        try {
            CustomerDiscount result = entityManager.merge(detachedInstance);
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
     * @return CustomerDiscount
     */
    public CustomerDiscount findById(final int id) {
        LOG.debug("getting CustomerDiscount instance with id: " + id);
        try {
            CustomerDiscount instance = entityManager
                    .find(CustomerDiscount.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
