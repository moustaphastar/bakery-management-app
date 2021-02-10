package com.bakery.management.dao;

import com.bakery.management.domain.DispatchNote;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class DispatchNote.
 *
 * @author Hibernate Tools
 * @see DispatchNote
 */
public class DocumentShipmentHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(DocumentShipmentHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance DispatchNote entity to persist
     */
    public void persist(final DispatchNote transientInstance) {
        LOG.debug("persisting DispatchNote instance");
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
     * @param persistentInstance DispatchNote entity to remove
     */
    public void remove(final DispatchNote persistentInstance) {
        LOG.debug("removing DispatchNote instance");
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
     * @param detachedInstance DispatchNote entity to merge
     * @return DispatchNote
     */
    public DispatchNote merge(final DispatchNote detachedInstance) {
        LOG.debug("merging DispatchNote instance");
        try {
            DispatchNote result = entityManager.merge(detachedInstance);
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
     * @return DispatchNote
     */
    public DispatchNote findById(final int id) {
        LOG.debug("getting DispatchNote instance with id: " + id);
        try {
            DispatchNote instance = entityManager.find(DispatchNote.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
