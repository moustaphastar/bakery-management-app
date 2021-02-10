package com.bakery.management.dao;

import com.bakery.management.domain.EmployeeAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class EmployeeAddress.
 *
 * @author Hibernate Tools
 * @see EmployeeAddress
 */
@Repository
public class EmployeeAddressHome {

    /***
     * Static final field for logging utility.
     */
    private static final Log LOG = LogFactory.getLog(EmployeeAddressHome.class);

    /***
     * EntityManager field to apply data operations.
     */
    @PersistenceContext
    private EntityManager entityManager;

    /***
     * Persist entity to database.
     * @param transientInstance EmployeeAddress entity to persist
     */
    public void persist(final EmployeeAddress transientInstance) {
        LOG.debug("persisting EmployeeAddress instance");
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
     * @param persistentInstance EmployeeAddress entity to remove
     */
    public void remove(final EmployeeAddress persistentInstance) {
        LOG.debug("removing EmployeeAddress instance");
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
     * @param detachedInstance EmployeeAddress entity to merge
     * @return EmployeeAddress
     */
    public EmployeeAddress merge(final EmployeeAddress detachedInstance) {
        LOG.debug("merging EmployeeAddress instance");
        try {
            EmployeeAddress result = entityManager.merge(detachedInstance);
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
     * @return EmployeeAddress
     */
    public EmployeeAddress findById(final int id) {
        LOG.debug("getting EmployeeAddress instance with id: " + id);
        try {
            EmployeeAddress instance = entityManager
                    .find(EmployeeAddress.class, id);
            LOG.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            LOG.error("get failed", re);
            throw re;
        }
    }
}
