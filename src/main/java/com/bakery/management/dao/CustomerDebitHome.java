package com.bakery.management.dao;

import com.bakery.management.domain.CustomerDebit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CustomerDebit.
 *
 * @author Hibernate Tools
 * @see CustomerDebit
 */
public class CustomerDebitHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(CustomerDebitHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance CustomerDebit entity to persist
     */
    public void persist(final CustomerDebit transientInstance) {
        LOG.debug("persisting CustomerDebit instance");
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
     * @param persistentInstance CustomerDebit entity to remove
     */
    public void remove(final CustomerDebit persistentInstance) {
        LOG.debug("removing CustomerDebit instance");
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
     * @param detachedInstance CustomerDebit entity to merge
     * @return CustomerDebit
     */
    public CustomerDebit merge(final CustomerDebit detachedInstance) {
        LOG.debug("merging CustomerDebit instance");
        try {
            CustomerDebit result = entityManager.merge(detachedInstance);
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
     * @return CustomerDebit
     */
    public CustomerDebit findById(final int id) {
        LOG.debug("getting CustomerDebit instance with id: " + id);
        try {
            CustomerDebit instance = entityManager
                    .find(CustomerDebit.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
