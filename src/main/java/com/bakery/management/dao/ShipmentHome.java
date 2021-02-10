package com.bakery.management.dao;

import com.bakery.management.domain.Shipment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Shipment.
 *
 * @author Hibernate Tools
 * @see Shipment
 */
public class ShipmentHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(ShipmentHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance Shipment entity to persist
     */
    public void persist(final Shipment transientInstance) {
        LOG.debug("persisting Shipment instance");
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
     * @param persistentInstance Shipment entity to remove
     */
    public void remove(final Shipment persistentInstance) {
        LOG.debug("removing Shipment instance");
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
     * @param detachedInstance Shipment entity to merge
     * @return Shipment
     */
    public Shipment merge(final Shipment detachedInstance) {
        LOG.debug("merging Shipment instance");
        try {
            Shipment result = entityManager.merge(detachedInstance);
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
     * @return Shipment
     */
    public Shipment findById(final int id) {
        LOG.debug("getting Shipment instance with id: " + id);
        try {
            Shipment instance = entityManager.find(Shipment.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
