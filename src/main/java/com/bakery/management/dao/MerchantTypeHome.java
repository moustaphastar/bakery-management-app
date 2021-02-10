package com.bakery.management.dao;

import com.bakery.management.domain.MerchantType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class MerchantType.
 *
 * @author Hibernate Tools
 * @see MerchantType
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
     * @param transientInstance MerchantType entity to persist
     */
    public void persist(final MerchantType transientInstance) {
        LOG.debug("persisting MerchantType instance");
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
     * @param persistentInstance MerchantType entity to remove
     */
    public void remove(final MerchantType persistentInstance) {
        LOG.debug("removing MerchantType instance");
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
     * @param detachedInstance MerchantType entity to merge
     * @return MerchantType
     */
    public MerchantType merge(final MerchantType detachedInstance) {
        LOG.debug("merging MerchantType instance");
        try {
            MerchantType result = entityManager.merge(detachedInstance);
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
     * @return MerchantType
     */
    public MerchantType findById(final int id) {
        LOG.debug("getting MerchantType instance with id: " + id);
        try {
            MerchantType instance = entityManager.find(MerchantType.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
