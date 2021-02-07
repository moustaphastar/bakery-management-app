package com.bakery.management.dao;

import com.bakery.management.domain.DriverCustomer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class DriverCustomer.
 *
 * @author Hibernate Tools
 * @see DriverCustomer
 */
public class VehicleDriverCustomerHome {

	private static final Log log = LogFactory.getLog(VehicleDriverCustomerHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DriverCustomer transientInstance) {
		log.debug("persisting DriverCustomer instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DriverCustomer persistentInstance) {
		log.debug("removing DriverCustomer instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DriverCustomer merge(DriverCustomer detachedInstance) {
		log.debug("merging DriverCustomer instance");
		try {
			DriverCustomer result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DriverCustomer findById(int id) {
		log.debug("getting DriverCustomer instance with id: " + id);
		try {
			DriverCustomer instance = entityManager.find(DriverCustomer.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
