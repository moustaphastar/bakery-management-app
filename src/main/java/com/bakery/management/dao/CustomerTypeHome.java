package com.bakery.management.dao;

import com.bakery.management.domain.CustomerCategory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CustomerCategory.
 *
 * @author Hibernate Tools
 * @see CustomerCategory
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
     * @param transientInstance CustomerCategory entity to persist
     */
    public void persist(final CustomerCategory transientInstance) {
        LOG.debug("persisting CustomerCategory instance");
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
     * @param persistentInstance CustomerCategory entity to remove
     */
    public void remove(final CustomerCategory persistentInstance) {
        LOG.debug("removing CustomerCategory instance");
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
     * @param detachedInstance CustomerCategory entity to merge
     * @return CustomerCategory
     */
    public CustomerCategory merge(final CustomerCategory detachedInstance) {
        LOG.debug("merging CustomerCategory instance");
        try {
            CustomerCategory result = entityManager.merge(detachedInstance);
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
     * @return CustomerCategory
     */
    public CustomerCategory findById(final int id) {
        LOG.debug("getting CustomerCategory instance with id: " + id);
        try {
            CustomerCategory instance = entityManager
                    .find(CustomerCategory.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
