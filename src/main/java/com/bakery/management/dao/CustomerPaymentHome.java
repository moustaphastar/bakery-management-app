package com.bakery.management.dao;

import com.bakery.management.domain.CustomerPayment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CustomerPayment.
 *
 * @author Hibernate Tools
 * @see CustomerPayment
 */
public class CustomerPaymentHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(CustomerPaymentHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance CustomerPayment entity to persist
     */
    public void persist(final CustomerPayment transientInstance) {
        LOG.debug("persisting CustomerPayment instance");
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
     * @param persistentInstance CustomerPayment entity to remove
     */
    public void remove(final CustomerPayment persistentInstance) {
        LOG.debug("removing CustomerPayment instance");
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
     * @param detachedInstance CustomerPayment entity to merge
     * @return CustomerPayment
     */
    public CustomerPayment merge(final CustomerPayment detachedInstance) {
        LOG.debug("merging CustomerPayment instance");
        try {
            CustomerPayment result = entityManager.merge(detachedInstance);
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
     * @return CustomerPayment
     */
    public CustomerPayment findById(final int id) {
        LOG.debug("getting CustomerPayment instance with id: " + id);
        try {
            CustomerPayment instance = entityManager
                    .find(CustomerPayment.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
