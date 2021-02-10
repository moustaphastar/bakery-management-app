package com.bakery.management.dao;

import com.bakery.management.domain.CashTransaction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AccountTransaction.
 *
 * @author Hibernate Tools
 * @see CashTransaction
 */
public class CashAccountTransactionHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(CashAccountTransactionHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance CashTransaction entity to persist
     */
    public void persist(final CashTransaction transientInstance) {
        LOG.debug("persisting CashAccountTransaction instance");
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
     * @param persistentInstance CashTransaction entity to remove
     */
    public void remove(final CashTransaction persistentInstance) {
        LOG.debug("removing CashAccountTransaction instance");
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
     * @param detachedInstance CashTransaction entity to merge
     * @return CashTransaction
     */
    public CashTransaction merge(final CashTransaction detachedInstance) {
        LOG.debug("merging CashAccountTransaction instance");
        try {
            CashTransaction result = entityManager.merge(detachedInstance);
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
     * @return CashTransaction
     */
    public CashTransaction findById(final int id) {
        LOG.debug("getting CashAccountTransaction instance with id: " + id);
        try {
            CashTransaction instance = entityManager
                    .find(CashTransaction.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
