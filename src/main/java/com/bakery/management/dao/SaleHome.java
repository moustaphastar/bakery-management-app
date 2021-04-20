package com.bakery.management.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.domain.Sale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Sale.
 * @see com.bakery.management.domain.Sale
 * @author Hibernate Tools
 */

public class SaleHome {

	private static final Log log = LogFactory.getLog(SaleHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Sale transientInstance) {
		log.debug("persisting Sale instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Sale persistentInstance) {
		log.debug("removing Sale instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Sale merge(Sale detachedInstance) {
		log.debug("merging Sale instance");
		try {
			Sale result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Sale findById(int id) {
		log.debug("getting Sale instance with id: " + id);
		try {
			Sale instance = entityManager.find(Sale.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
