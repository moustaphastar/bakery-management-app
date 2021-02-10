package com.bakery.management.dao;

import com.bakery.management.domain.AspNetUsers;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Home object for domain model class AspNetUsers.
 *
 * @author Hibernate Tools
 * @see AspNetUsers
 */
public class AspNetUsersHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(AspNetUsersHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance AspNetUsers entity to persist
     */
    public void persist(final AspNetUsers transientInstance) {
        LOG.debug("persisting AspNetUsers instance");
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
     * @param persistentInstance AspNetUsers entity to remove
     */
    public void remove(final AspNetUsers persistentInstance) {
        LOG.debug("removing AspNetUsers instance");
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
     * @param detachedInstance AspNetUsers entity to merge
     * @return AspNetUsers
     */
    public AspNetUsers merge(final AspNetUsers detachedInstance) {
        LOG.debug("merging AspNetUsers instance");
        try {
            AspNetUsers result = entityManager.merge(detachedInstance);
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
     * @return AspNetUsers
     */
    public AspNetUsers findById(final Serializable id) {
        LOG.debug("getting AspNetUsers instance with id: " + id);
        try {
            AspNetUsers instance = entityManager.find(AspNetUsers.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
