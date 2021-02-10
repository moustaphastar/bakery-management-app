package com.bakery.management.dao;

import com.bakery.management.domain.Job;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Job.
 *
 * @author Hibernate Tools
 * @see Job
 */
public class JobHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(JobHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Job entity to persist
     */
    public void persist(final Job transientInstance) {
        LOG.debug("persisting Job instance");
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
     * @param persistentInstance Job entity to remove
     */
    public void remove(final Job persistentInstance) {
        LOG.debug("removing Job instance");
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
     * @param detachedInstance Job entity to merge
     * @return Job
     */
    public Job merge(final Job detachedInstance) {
        LOG.debug("merging Job instance");
        try {
            Job result = entityManager.merge(detachedInstance);
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
     * @return Job
     */
    public Job findById(final int id) {
        LOG.debug("getting Job instance with id: " + id);
        try {
            Job instance = entityManager.find(Job.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
