package com.bakery.management.dao;

import com.bakery.management.domain.MerchantCategory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class MerchantCategory.
 *
 * @author Hibernate Tools
 * @see MerchantCategory
 */
public class MerchantTypeHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(MerchantTypeHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance MerchantCategory entity to persist
     */
    public void persist(final MerchantCategory transientInstance) {
        LOG.debug("persisting MerchantCategory instance");
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
     * @param persistentInstance MerchantCategory entity to remove
     */
    public void remove(final MerchantCategory persistentInstance) {
        LOG.debug("removing MerchantCategory instance");
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
     * @param detachedInstance MerchantCategory entity to merge
     * @return MerchantCategory
     */
    public MerchantCategory merge(final MerchantCategory detachedInstance) {
        LOG.debug("merging MerchantCategory instance");
        try {
            MerchantCategory result = entityManager.merge(detachedInstance);
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
     * @return MerchantCategory
     */
    public MerchantCategory findById(final int id) {
        LOG.debug("getting MerchantCategory instance with id: " + id);
        try {
            MerchantCategory instance = entityManager.find(MerchantCategory.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
