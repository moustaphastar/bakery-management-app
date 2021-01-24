package com.bakery.management.model.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.model.entity.ShipmentLoad;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ShipmentLoad.
 * @see com.bakery.management.model.entity.ShipmentLoad
 * @author Hibernate Tools
 */

public class ShipmentLoadHome {

	private static final Log log = LogFactory.getLog(ShipmentLoadHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ShipmentLoad transientInstance) {
		log.debug("persisting ShipmentLoad instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ShipmentLoad persistentInstance) {
		log.debug("removing ShipmentLoad instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ShipmentLoad merge(ShipmentLoad detachedInstance) {
		log.debug("merging ShipmentLoad instance");
		try {
			ShipmentLoad result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ShipmentLoad findById(int id) {
		log.debug("getting ShipmentLoad instance with id: " + id);
		try {
			ShipmentLoad instance = entityManager.find(ShipmentLoad.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
