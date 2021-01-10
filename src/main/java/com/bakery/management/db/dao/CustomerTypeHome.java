package com.bakery.management.db.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bakery.management.db.entity.CustomerType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CustomerType.
 * @see com.bakery.management.db.entity.CustomerType
 * @author Hibernate Tools
 */

public class CustomerTypeHome {

	private static final Log log = LogFactory.getLog(CustomerTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CustomerType transientInstance) {
		log.debug("persisting CustomerType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CustomerType persistentInstance) {
		log.debug("removing CustomerType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CustomerType merge(CustomerType detachedInstance) {
		log.debug("merging CustomerType instance");
		try {
			CustomerType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustomerType findById(int id) {
		log.debug("getting CustomerType instance with id: " + id);
		try {
			CustomerType instance = entityManager.find(CustomerType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
