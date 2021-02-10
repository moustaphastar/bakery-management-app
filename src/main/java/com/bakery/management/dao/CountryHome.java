package com.bakery.management.dao;

import com.bakery.management.domain.Country;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Country.
 *
 * @author Hibernate Tools
 * @see Country
 */
@Repository
public class CountryHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(CountryHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Country entity to persist
     */
    public void persist(final Country transientInstance) {
        LOG.debug("persisting Country instance");
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
     * @param persistentInstance Country entity to remove
     */
    public void remove(final Country persistentInstance) {
        LOG.debug("removing Country instance");
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
     * @param detachedInstance Country entity to merge
     * @return Country
     */
    public Country merge(final Country detachedInstance) {
        LOG.debug("merging Country instance");
        try {
            Country result = entityManager.merge(detachedInstance);
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
     * @return Country
     */
    public Country findById(final int id) {
        LOG.debug("getting Country instance with id: " + id);
        try {
            Country instance = entityManager
                    .find(Country.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
