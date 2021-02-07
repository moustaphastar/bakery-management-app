package com.bakery.management.dao;

import com.bakery.management.domain.District;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Province.
 * @see District
 * @author Hibernate Tools
 */
public class ProvinceHome {

	private static final Log log = LogFactory.getLog(ProvinceHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(District transientInstance) {
		log.debug("persisting Province instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(District persistentInstance) {
		log.debug("removing Province instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public District merge(District detachedInstance) {
		log.debug("merging Province instance");
		try {
			District result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public District findById(int id) {
		log.debug("getting Province instance with id: " + id);
		try {
			District instance = entityManager.find(District.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
