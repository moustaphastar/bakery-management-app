package com.bakery.management.dao;

import com.bakery.management.domain.ProductCategory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ProductCategory.
 *
 * @author Hibernate Tools
 * @see ProductCategory
 */
public class ProductCategoryHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(ProductCategoryHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance ProductCategory entity to persist
     */
    public void persist(final ProductCategory transientInstance) {
        LOG.debug("persisting ProductCategory instance");
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
     * @param persistentInstance ProductCategory entity to remove
     */
    public void remove(final ProductCategory persistentInstance) {
        LOG.debug("removing ProductCategory instance");
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
     * @param detachedInstance ProductCategory entity to merge
     * @return ProductCategory
     */
    public ProductCategory merge(final ProductCategory detachedInstance) {
        LOG.debug("merging ProductCategory instance");
        try {
            ProductCategory result = entityManager.merge(detachedInstance);
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
     * @return ProductCategory
     */
    public ProductCategory findById(final int id) {
        LOG.debug("getting ProductCategory instance with id: " + id);
        try {
            ProductCategory instance = entityManager
                    .find(ProductCategory.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
