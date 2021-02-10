package com.bakery.management.dao;

import com.bakery.management.domain.CashAccount;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Account.
 *
 * @author Hibernate Tools
 * @see CashAccount
 */
public class CashAccountHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(CashAccountHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance CashAccount entity to persist
     */
    public void persist(final CashAccount transientInstance) {
        LOG.debug("persisting CashAccount instance");
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
     * @param persistentInstance CashAccount entity to remove
     */
    public void remove(final CashAccount persistentInstance) {
        LOG.debug("removing CashAccount instance");
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
     * @param detachedInstance CashAccount entity to merge
     * @return CashAccount
     */
    public CashAccount merge(final CashAccount detachedInstance) {
        LOG.debug("merging CashAccount instance");
        try {
            CashAccount result = entityManager.merge(detachedInstance);
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
     * @return CashAccount
     */
    public CashAccount findById(final int id) {
        LOG.debug("getting CashAccount instance with id: " + id);
        try {
            CashAccount instance = entityManager.find(CashAccount.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
