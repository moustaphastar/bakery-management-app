package com.bakery.management.dao;

import com.bakery.management.domain.City;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class City.
 *
 * @author Hibernate Tools
 * @see City
 */
public class CityHome {

	private static final Log log = LogFactory.getLog(CityHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(City transientInstance) {
		log.debug("persisting City instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(City persistentInstance) {
		log.debug("removing City instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public City merge(City detachedInstance) {
		log.debug("merging City instance");
		try {
			City result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public City findById(int id) {
		log.debug("getting City instance with id: " + id);
		try {
			City instance = entityManager.find(City.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}