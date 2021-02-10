package com.bakery.management.dao;

import com.bakery.management.domain.DeviceCodes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Home object for domain model class DeviceCodes.
 *
 * @author Hibernate Tools
 * @see DeviceCodes
 */
public class DeviceCodesHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory
            .getLog(DeviceCodesHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance DeviceCodes entity to persist
     */
    public void persist(final DeviceCodes transientInstance) {
        LOG.debug("persisting DeviceCodes instance");
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
     * @param persistentInstance DeviceCodes entity to remove
     */
    public void remove(final DeviceCodes persistentInstance) {
        LOG.debug("removing DeviceCodes instance");
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
     * @param detachedInstance DeviceCodes entity to merge
     * @return DeviceCodes
     */
    public DeviceCodes merge(final DeviceCodes detachedInstance) {
        LOG.debug("merging DeviceCodes instance");
        try {
            DeviceCodes result = entityManager.merge(detachedInstance);
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
     * @return DeviceCodes
     */
    public DeviceCodes findById(final Serializable id) {
        LOG.debug("getting DeviceCodes instance with id: " + id);
        try {
            DeviceCodes instance = entityManager
                    .find(DeviceCodes.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
