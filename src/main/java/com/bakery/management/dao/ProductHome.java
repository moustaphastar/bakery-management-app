package com.bakery.management.dao;

import com.bakery.management.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Product.
 *
 * @author Hibernate Tools
 * @see Product
 */
public class ProductHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(ProductHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Product entity to persist
     */
    public void persist(final Product transientInstance) {
        LOG.debug("persisting Product instance");
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
     * @param persistentInstance Product entity to remove
     */
    public void remove(final Product persistentInstance) {
        LOG.debug("removing Product instance");
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
     * @param detachedInstance Product entity to merge
     * @return Product
     */
    public Product merge(final Product detachedInstance) {
        LOG.debug("merging Product instance");
        try {
            Product result = entityManager.merge(detachedInstance);
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
     * @return Product
     */
    public Product findById(final String id) {
        LOG.debug("getting Product instance with id: " + id);
        try {
            Product instance = entityManager.find(Product.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
