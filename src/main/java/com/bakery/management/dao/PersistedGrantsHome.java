package com.bakery.management.dao;

import com.bakery.management.domain.PersistedGrants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Home object for domain model class PersistedGrants.
 *
 * @author Hibernate Tools
 * @see PersistedGrants
 */
public class PersistedGrantsHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(PersistedGrantsHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance PersistedGrants entity to persist
     */
    public void persist(final PersistedGrants transientInstance) {
        LOG.debug("persisting PersistedGrants instance");
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
     * @param persistentInstance PersistedGrants entity to remove
     */
    public void remove(final PersistedGrants persistentInstance) {
        LOG.debug("removing PersistedGrants instance");
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
     * @param detachedInstance PersistedGrants entity to merge
     * @return PersistedGrants
     */
    public PersistedGrants merge(final PersistedGrants detachedInstance) {
        LOG.debug("merging PersistedGrants instance");
        try {
            PersistedGrants result = entityManager.merge(detachedInstance);
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
     * @return PersistedGrants
     */
    public PersistedGrants findById(final Serializable id) {
        LOG.debug("getting PersistedGrants instance with id: " + id);
        try {
            PersistedGrants instance = entityManager
                    .find(PersistedGrants.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
