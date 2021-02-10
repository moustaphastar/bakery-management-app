package com.bakery.management.dao;

import com.bakery.management.domain.Address;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Address.
 *
 * @author Hibernate Tools
 * @see Address
 */
@Repository
public class AddressHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(AddressHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Address entity to persist
     */
    public void persist(final Address transientInstance) {
        LOG.debug("persisting Address instance");
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
     * @param persistentInstance Address entity to remove
     */
    public void remove(final Address persistentInstance) {
        LOG.debug("removing Address instance");
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
     * @param detachedInstance Address entity to merge
     * @return Address
     */
    public Address merge(final Address detachedInstance) {
        LOG.debug("merging Address instance");
        try {
            Address result = entityManager.merge(detachedInstance);
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
     * @return Address
     */
    public Address findById(final int id) {
        LOG.debug("getting Address instance with id: " + id);
        try {
            Address instance = entityManager.find(Address.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
