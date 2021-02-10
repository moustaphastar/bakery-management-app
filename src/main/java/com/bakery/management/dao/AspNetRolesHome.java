package com.bakery.management.dao;

import com.bakery.management.domain.AspNetRoles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Home object for domain model class AspNetRoles.
 *
 * @author Hibernate Tools
 * @see AspNetRoles
 */
public class AspNetRolesHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(AspNetRolesHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance AspNetRoles entity to persist
     */
    public void persist(final AspNetRoles transientInstance) {
        LOG.debug("persisting AspNetRoles instance");
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
     * @param persistentInstance AspNetRoles entity to remove
     */
    public void remove(final AspNetRoles persistentInstance) {
        LOG.debug("removing AspNetRoles instance");
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
     * @param detachedInstance AspNetRoles entity to merge
     * @return AspNetRoles
     */
    public AspNetRoles merge(final AspNetRoles detachedInstance) {
        LOG.debug("merging AspNetRoles instance");
        try {
            AspNetRoles result = entityManager.merge(detachedInstance);
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
     * @return AspNetRoles
     */
    public AspNetRoles findById(final Serializable id) {
        LOG.debug("getting AspNetRoles instance with id: " + id);
        try {
            AspNetRoles instance = entityManager.find(AspNetRoles.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
