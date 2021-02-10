package com.bakery.management.dao;

import com.bakery.management.domain.AspNetUserLogins;
import com.bakery.management.domain.AspNetUserLoginsId;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AspNetUserLogins.
 *
 * @author Hibernate Tools
 * @see AspNetUserLogins
 */
public class AspNetUserLoginsHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(AspNetUserLoginsHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance AspNetUserLogins entity to persist
     */
    public void persist(final AspNetUserLogins transientInstance) {
        LOG.debug("persisting AspNetUserLogins instance");
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
     * @param persistentInstance AspNetUserLogins entity to remove
     */
    public void remove(final AspNetUserLogins persistentInstance) {
        LOG.debug("removing AspNetUserLogins instance");
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
     * @param detachedInstance AspNetUserLogins entity to merge
     * @return AspNetUserLogins
     */
    public AspNetUserLogins merge(final AspNetUserLogins detachedInstance) {
        LOG.debug("merging AspNetUserLogins instance");
        try {
            AspNetUserLogins result = entityManager.merge(detachedInstance);
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
     * @return AspNetUserLogins
     */
    public AspNetUserLogins findById(final AspNetUserLoginsId id) {
        LOG.debug("getting AspNetUserLogins instance with id: " + id);
        try {
            AspNetUserLogins instance = entityManager
                    .find(AspNetUserLogins.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
