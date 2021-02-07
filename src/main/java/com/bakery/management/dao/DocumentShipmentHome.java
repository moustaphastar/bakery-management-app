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

    private static final Log log = LogFactory.getLog(DocumentShipmentHome.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(DispatchNote transientInstance) {
        log.debug("persisting DispatchNote instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void remove(DispatchNote persistentInstance) {
        log.debug("removing DispatchNote instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        } catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }

    public DispatchNote merge(DispatchNote detachedInstance) {
        log.debug("merging DispatchNote instance");
        try {
            DispatchNote result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public DispatchNote findById(int id) {
        log.debug("getting DispatchNote instance with id: " + id);
        try {
            DispatchNote instance = entityManager.find(DispatchNote.class, id);
            log.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}
