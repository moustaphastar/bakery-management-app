package com.bakery.management.dao;

import com.bakery.management.domain.Invoice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Invoice.
 *
 * @author Hibernate Tools
 * @see Invoice
 */
public class DocumentInvoiceHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(DocumentInvoiceHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Invoice entity to persist
     */
    public void persist(final Invoice transientInstance) {
        LOG.debug("persisting Invoice instance");
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
     * @param persistentInstance Invoice entity to remove
     */
    public void remove(final Invoice persistentInstance) {
        LOG.debug("removing Invoice instance");
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
     * @param detachedInstance Invoice entity to merge
     * @return Invoice
     */
    public Invoice merge(final Invoice detachedInstance) {
        LOG.debug("merging Invoice instance");
        try {
            Invoice result = entityManager.merge(detachedInstance);
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
     * @return Invoice
     */
    public Invoice findById(final String id) {
        LOG.debug("getting Invoice instance with id: " + id);
        try {
            Invoice instance = entityManager.find(Invoice.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
