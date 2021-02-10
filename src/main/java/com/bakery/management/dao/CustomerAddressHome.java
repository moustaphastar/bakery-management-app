package com.bakery.management.dao;

import com.bakery.management.domain.CustomerAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CustomerAddress.
 *
 * @author Hibernate Tools
 * @see CustomerAddress
 */
@Repository
public class CustomerAddressHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(CustomerAddressHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance CustomerAddress entity to persist
     */
    public void persist(final CustomerAddress transientInstance) {
        LOG.debug("persisting CustomerAddress instance");
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
     * @param persistentInstance CustomerAddress entity to remove
     */
    public void remove(final CustomerAddress persistentInstance) {
        LOG.debug("removing CustomerAddress instance");
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
     * @param detachedInstance CustomerAddress entity to merge
     * @return CustomerAddress
     */
    public CustomerAddress merge(final CustomerAddress detachedInstance) {
        LOG.debug("merging CustomerAddress instance");
        try {
            CustomerAddress result = entityManager.merge(detachedInstance);
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
     * @return CustomerAddress
     */
    public CustomerAddress findById(final int id) {
        LOG.debug("getting CustomerAddress instance with id: " + id);
        try {
            CustomerAddress instance = entityManager
                    .find(CustomerAddress.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
