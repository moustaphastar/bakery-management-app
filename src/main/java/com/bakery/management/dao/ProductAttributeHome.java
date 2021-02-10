package com.bakery.management.dao;

import com.bakery.management.domain.ProductAttribute;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ProductAttribute.
 *
 * @author Hibernate Tools
 * @see ProductAttribute
 */
public class ProductAttributeHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(ProductAttributeHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance ProductAttribute entity to persist
     */
    public void persist(final ProductAttribute transientInstance) {
        LOG.debug("persisting ProductAttribute instance");
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
     * @param persistentInstance ProductAttribute entity to remove
     */
    public void remove(final ProductAttribute persistentInstance) {
        LOG.debug("removing ProductAttribute instance");
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
     * @param detachedInstance ProductAttribute entity to merge
     * @return ProductAttribute
     */
    public ProductAttribute merge(final ProductAttribute detachedInstance) {
        LOG.debug("merging ProductAttribute instance");
        try {
            ProductAttribute result = entityManager.merge(detachedInstance);
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
     * @return ProductAttribute
     */
    public ProductAttribute findById(final int id) {
        LOG.debug("getting ProductAttribute instance with id: " + id);
        try {
            ProductAttribute instance = entityManager
                    .find(ProductAttribute.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
