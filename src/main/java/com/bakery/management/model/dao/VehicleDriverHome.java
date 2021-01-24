package com.bakery.management.model.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.model.entity.VehicleDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class VehicleDriver.
 * @see com.bakery.management.model.entity.VehicleDriver
 * @author Hibernate Tools
 */

public class VehicleDriverHome {

	private static final Log log = LogFactory.getLog(VehicleDriverHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(VehicleDriver transientInstance) {
		log.debug("persisting VehicleDriver instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(VehicleDriver persistentInstance) {
		log.debug("removing VehicleDriver instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public VehicleDriver merge(VehicleDriver detachedInstance) {
		log.debug("merging VehicleDriver instance");
		try {
			VehicleDriver result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VehicleDriver findById(int id) {
		log.debug("getting VehicleDriver instance with id: " + id);
		try {
			VehicleDriver instance = entityManager.find(VehicleDriver.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
