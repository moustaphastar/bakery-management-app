package com.bakery.management.dao;

import com.bakery.management.domain.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Customer.
 *
 * @author Hibernate Tools
 * @see Customer
 */
public class CustomerHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(CustomerHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Customer entity to persist
     */
    public void persist(final Customer transientInstance) {
        LOG.debug("persisting Customer instance");
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
     * @param persistentInstance Customer entity to remove
     */
    public void remove(final Customer persistentInstance) {
        LOG.debug("removing Customer instance");
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
     * @param detachedInstance Customer entity to merge
     * @return Customer
     */
    public Customer merge(final Customer detachedInstance) {
        LOG.debug("merging Customer instance");
        try {
            Customer result = entityManager.merge(detachedInstance);
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
     * @return Customer
     */
    public Customer findById(final String id) {
        LOG.debug("getting Customer instance with id: " + id);
        try {
            Customer instance = entityManager.find(Customer.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
