package com.bakery.management.dao;

import com.bakery.management.domain.AspNetUserTokens;
import com.bakery.management.domain.AspNetUserTokensId;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AspNetUserTokens.
 *
 * @author Hibernate Tools
 * @see AspNetUserTokens
 */
public class AspNetUserTokensHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(AspNetUserTokensHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance AspNetUserTokens entity to persist
     */
    public void persist(final AspNetUserTokens transientInstance) {
        LOG.debug("persisting AspNetUserTokens instance");
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
     * @param persistentInstance AspNetUserTokens entity to remove
     */
    public void remove(final AspNetUserTokens persistentInstance) {
        LOG.debug("removing AspNetUserTokens instance");
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
     * @param detachedInstance AspNetUserTokens entity to merge
     * @return AspNetUserTokens
     */
    public AspNetUserTokens merge(final AspNetUserTokens detachedInstance) {
        LOG.debug("merging AspNetUserTokens instance");
        try {
            AspNetUserTokens result = entityManager.merge(detachedInstance);
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
     * @return AspNetUserTokens
     */
    public AspNetUserTokens findById(final AspNetUserTokensId id) {
        LOG.debug("getting AspNetUserTokens instance with id: " + id);
        try {
            AspNetUserTokens instance = entityManager
                    .find(AspNetUserTokens.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
