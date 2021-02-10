package com.bakery.management.dao;

import com.bakery.management.domain.CustomerType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CustomerType.
 *
 * @author Hibernate Tools
 * @see CustomerType
 */
public class CustomerTypeHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(CustomerTypeHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance CustomerType entity to persist
     */
    public void persist(final CustomerType transientInstance) {
        LOG.debug("persisting CustomerType instance");
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
     * @param persistentInstance CustomerType entity to remove
     */
    public void remove(final CustomerType persistentInstance) {
        LOG.debug("removing CustomerType instance");
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
     * @param detachedInstance CustomerType entity to merge
     * @return CustomerType
     */
    public CustomerType merge(final CustomerType detachedInstance) {
        LOG.debug("merging CustomerType instance");
        try {
            CustomerType result = entityManager.merge(detachedInstance);
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
     * @return CustomerType
     */
    public CustomerType findById(final int id) {
        LOG.debug("getting CustomerType instance with id: " + id);
        try {
            CustomerType instance = entityManager
                    .find(CustomerType.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
