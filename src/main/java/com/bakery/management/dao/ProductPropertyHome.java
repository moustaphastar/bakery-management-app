package com.bakery.management.dao;

import com.bakery.management.domain.ProductProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ProductProperty.
 *
 * @author Hibernate Tools
 * @see ProductProperty
 */
public class ProductPropertyHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(ProductPropertyHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance ProductProperty entity to persist
     */
    public void persist(final ProductProperty transientInstance) {
        LOG.debug("persisting ProductProperty instance");
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
     * @param persistentInstance ProductProperty entity to remove
     */
    public void remove(final ProductProperty persistentInstance) {
        LOG.debug("removing ProductProperty instance");
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
     * @param detachedInstance ProductProperty entity to merge
     * @return ProductProperty
     */
    public ProductProperty merge(final ProductProperty detachedInstance) {
        LOG.debug("merging ProductProperty instance");
        try {
            ProductProperty result = entityManager.merge(detachedInstance);
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
     * @return ProductProperty
     */
    public ProductProperty findById(final int id) {
        LOG.debug("getting ProductProperty instance with id: " + id);
        try {
            ProductProperty instance = entityManager
                    .find(ProductProperty.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
