package com.bakery.management.dao;

import com.bakery.management.domain.ShipmentRouteIndex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ShipmentRouteIndex.
 *
 * @author Hibernate Tools
 * @see ShipmentRouteIndex
 */
public class ShipmentRouteIndexHome {

	private static final Log log = LogFactory.getLog(ShipmentRouteIndexHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ShipmentRouteIndex transientInstance) {
		log.debug("persisting ShipmentRouteIndex instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ShipmentRouteIndex persistentInstance) {
		log.debug("removing ShipmentRouteIndex instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ShipmentRouteIndex merge(ShipmentRouteIndex detachedInstance) {
		log.debug("merging ShipmentRouteIndex instance");
		try {
			ShipmentRouteIndex result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShipmentRouteIndex findById(int id) {
		log.debug("getting ShipmentRouteIndex instance with id: " + id);
		try {
			ShipmentRouteIndex instance = entityManager.find(ShipmentRouteIndex.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
