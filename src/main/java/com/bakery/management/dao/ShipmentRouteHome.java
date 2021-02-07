package com.bakery.management.dao;

import com.bakery.management.domain.ShipmentRoute;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ShipmentRoute.
 *
 * @author Hibernate Tools
 * @see ShipmentRoute
 */
public class ShipmentRouteHome {

	private static final Log log = LogFactory.getLog(ShipmentRouteHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ShipmentRoute transientInstance) {
		log.debug("persisting ShipmentRoute instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ShipmentRoute persistentInstance) {
		log.debug("removing ShipmentRoute instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ShipmentRoute merge(ShipmentRoute detachedInstance) {
		log.debug("merging ShipmentRoute instance");
		try {
			ShipmentRoute result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShipmentRoute findById(int id) {
		log.debug("getting ShipmentRoute instance with id: " + id);
		try {
			ShipmentRoute instance = entityManager.find(ShipmentRoute.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
