package com.bakery.management.dao;

import com.bakery.management.domain.AspNetRoleClaims;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AspNetRoleClaims.
 *
 * @author Hibernate Tools
 * @see AspNetRoleClaims
 */
public class AspNetRoleClaimsHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(AspNetRoleClaimsHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance AspNetRoleClaims entity to persist
     */
    public void persist(final AspNetRoleClaims transientInstance) {
        LOG.debug("persisting AspNetRoleClaims instance");
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
     * @param persistentInstance AspNetRoleClaims entity to remove
     */
    public void remove(final AspNetRoleClaims persistentInstance) {
        LOG.debug("removing AspNetRoleClaims instance");
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
     * @param detachedInstance AspNetRoleClaims entity to merge
     * @return AspNetRoleClaims
     */
    public AspNetRoleClaims merge(final AspNetRoleClaims detachedInstance) {
        LOG.debug("merging AspNetRoleClaims instance");
        try {
            AspNetRoleClaims result = entityManager.merge(detachedInstance);
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
     * @return AspNetRoleClaims
     */
    public AspNetRoleClaims findById(final int id) {
        LOG.debug("getting AspNetRoleClaims instance with id: " + id);
        try {
            AspNetRoleClaims instance = entityManager
                    .find(AspNetRoleClaims.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
