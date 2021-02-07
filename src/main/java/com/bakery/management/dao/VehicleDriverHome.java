package com.bakery.management.dao;

import com.bakery.management.domain.Driver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Driver.
 *
 * @author Hibernate Tools
 * @see Driver
 */
public class VehicleDriverHome {

	private static final Log log = LogFactory.getLog(VehicleDriverHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Driver transientInstance) {
		log.debug("persisting Driver instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Driver persistentInstance) {
		log.debug("removing Driver instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Driver merge(Driver detachedInstance) {
		log.debug("merging Driver instance");
		try {
			Driver result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Driver findById(int id) {
		log.debug("getting Driver instance with id: " + id);
		try {
			Driver instance = entityManager.find(Driver.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
