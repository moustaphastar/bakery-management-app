package com.bakery.management.dao;

import com.bakery.management.domain.MerchantAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class MerchantAddress.
 *
 * @author Hibernate Tools
 * @see MerchantAddress
 */
@Repository
public class MerchantAddressHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(MerchantAddressHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance MerchantAddress entity to persist
     */
    public void persist(final MerchantAddress transientInstance) {
        LOG.debug("persisting MerchantAddress instance");
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
     * @param persistentInstance MerchantAddress entity to remove
     */
    public void remove(final MerchantAddress persistentInstance) {
        LOG.debug("removing MerchantAddress instance");
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
     * @param detachedInstance MerchantAddress entity to merge
     * @return MerchantAddress
     */
    public MerchantAddress merge(final MerchantAddress detachedInstance) {
        LOG.debug("merging MerchantAddress instance");
        try {
            MerchantAddress result = entityManager.merge(detachedInstance);
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
     * @return MerchantAddress
     */
    public MerchantAddress findById(final int id) {
        LOG.debug("getting MerchantAddress instance with id: " + id);
        try {
            MerchantAddress instance = entityManager
                    .find(MerchantAddress.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
