package com.bakery.management.dao;

import com.bakery.management.domain.Merchant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Merchant.
 *
 * @author Hibernate Tools
 * @see Merchant
 */
public class MerchantHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(MerchantHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Merchant entity to persist
     */
    public void persist(final Merchant transientInstance) {
        LOG.debug("persisting Merchant instance");
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
     * @param persistentInstance Merchant entity to remove
     */
    public void remove(final Merchant persistentInstance) {
        LOG.debug("removing Merchant instance");
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
     * @param detachedInstance Merchant entity to merge
     * @return Merchant
     */
    public Merchant merge(final Merchant detachedInstance) {
        LOG.debug("merging Merchant instance");
        try {
            Merchant result = entityManager.merge(detachedInstance);
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
     * @return Merchant
     */
    public Merchant findById(final String id) {
        LOG.debug("getting Merchant instance with id: " + id);
        try {
            Merchant instance = entityManager.find(Merchant.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
