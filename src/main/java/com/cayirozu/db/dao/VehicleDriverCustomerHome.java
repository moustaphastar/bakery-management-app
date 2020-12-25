package com.cayirozu.db.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cayirozu.db.entity.VehicleDriverCustomer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class VehicleDriverCustomer.
 * @see com.cayirozu.db.entity.VehicleDriverCustomer
 * @author Hibernate Tools
 */

public class VehicleDriverCustomerHome {

	private static final Log log = LogFactory.getLog(VehicleDriverCustomerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(VehicleDriverCustomer transientInstance) {
		log.debug("persisting VehicleDriverCustomer instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(VehicleDriverCustomer persistentInstance) {
		log.debug("removing VehicleDriverCustomer instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public VehicleDriverCustomer merge(VehicleDriverCustomer detachedInstance) {
		log.debug("merging VehicleDriverCustomer instance");
		try {
			VehicleDriverCustomer result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public VehicleDriverCustomer findById(int id) {
		log.debug("getting VehicleDriverCustomer instance with id: " + id);
		try {
			VehicleDriverCustomer instance = entityManager.find(VehicleDriverCustomer.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
