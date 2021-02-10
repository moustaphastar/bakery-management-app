package com.bakery.management.dao;

import com.bakery.management.domain.City;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class City.
 *
 * @author Hibernate Tools
 * @see City
 */
public class CityHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(CityHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance City entity to persist
     */
    public void persist(final City transientInstance) {
        LOG.debug("persisting City instance");
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
     * @param persistentInstance City entity to remove
     */
    public void remove(final City persistentInstance) {
        LOG.debug("removing City instance");
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
     * @param detachedInstance City entity to merge
     * @return City
     */
    public City merge(final City detachedInstance) {
        LOG.debug("merging City instance");
        try {
            City result = entityManager.merge(detachedInstance);
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
     * @return City
     */
    public City findById(final int id) {
        LOG.debug("getting City instance with id: " + id);
        try {
            City instance = entityManager.find(City.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
