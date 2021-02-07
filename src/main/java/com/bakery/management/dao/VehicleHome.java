package com.bakery.management.dao;

import com.bakery.management.domain.Vehicle;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Vehicle.
 *
 * @author Hibernate Tools
 * @see Vehicle
 */
public class VehicleHome {

	private static final Log log = LogFactory.getLog(VehicleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Vehicle transientInstance) {
		log.debug("persisting Vehicle instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Vehicle persistentInstance) {
		log.debug("removing Vehicle instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Vehicle merge(Vehicle detachedInstance) {
		log.debug("merging Vehicle instance");
		try {
			Vehicle result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vehicle findById(int id) {
		log.debug("getting Vehicle instance with id: " + id);
		try {
			Vehicle instance = entityManager.find(Vehicle.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
