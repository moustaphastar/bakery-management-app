package com.bakery.management.dao;

import com.bakery.management.domain.EmployeeLeave;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class EmployeeLeave.
 *
 * @author Hibernate Tools
 * @see EmployeeLeave
 */
public class EmployeeLeaveHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(EmployeeLeaveHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance EmployeeLeave entity to persist
     */
    public void persist(final EmployeeLeave transientInstance) {
        LOG.debug("persisting EmployeeLeave instance");
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
     * @param persistentInstance EmployeeLeave entity to remove
     */
    public void remove(final EmployeeLeave persistentInstance) {
        LOG.debug("removing EmployeeLeave instance");
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
     * @param detachedInstance EmployeeLeave entity to merge
     * @return EmployeeLeave
     */
    public EmployeeLeave merge(final EmployeeLeave detachedInstance) {
        LOG.debug("merging EmployeeLeave instance");
        try {
            EmployeeLeave result = entityManager.merge(detachedInstance);
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
     * @return EmployeeLeave
     */
    public EmployeeLeave findById(final int id) {
        LOG.debug("getting EmployeeLeave instance with id: " + id);
        try {
            EmployeeLeave instance = entityManager
                    .find(EmployeeLeave.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
