package com.bakery.management.dao;

import com.bakery.management.domain.OrderItem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class OrderItem.
 *
 * @author Hibernate Tools
 * @see OrderItem
 */
public class SaleDetailHome {

    private static final Log log = LogFactory.getLog(SaleDetailHome.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(OrderItem transientInstance) {
        log.debug("persisting OrderItem instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void remove(OrderItem persistentInstance) {
        log.debug("removing OrderItem instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        } catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }

    public OrderItem merge(OrderItem detachedInstance) {
        log.debug("merging OrderItem instance");
        try {
            OrderItem result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public OrderItem findById(int id) {
        log.debug("getting OrderItem instance with id: " + id);
        try {
            OrderItem instance = entityManager.find(OrderItem.class, id);
            log.debug("get successful");
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}
