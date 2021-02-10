package com.bakery.management.dao;

import com.bakery.management.domain.AspNetUserClaims;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AspNetUserClaims.
 *
 * @author Hibernate Tools
 * @see AspNetUserClaims
 */
public class AspNetUserClaimsHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(AspNetUserClaimsHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance AspNetUserClaims entity to persist
     */
    public void persist(final AspNetUserClaims transientInstance) {
        LOG.debug("persisting AspNetUserClaims instance");
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
     * @param persistentInstance AspNetUserClaims entity to remove
     */
    public void remove(final AspNetUserClaims persistentInstance) {
        LOG.debug("removing AspNetUserClaims instance");
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
     * @param detachedInstance AspNetUserClaims entity to merge
     * @return AspNetUserClaims
     */
    public AspNetUserClaims merge(final AspNetUserClaims detachedInstance) {
        LOG.debug("merging AspNetUserClaims instance");
        try {
            AspNetUserClaims result = entityManager.merge(detachedInstance);
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
     * @return AspNetUserClaims
     */
    public AspNetUserClaims findById(final int id) {
        LOG.debug("getting AspNetUserClaims instance with id: " + id);
        try {
            AspNetUserClaims instance = entityManager
                    .find(AspNetUserClaims.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
