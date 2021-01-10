package com.bakery.management.db.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bakery.management.db.entity.SaleDetail;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class SaleDetail.
 * @see com.bakery.management.db.entity.SaleDetail
 * @author Hibernate Tools
 */

public class SaleDetailHome {

	private static final Log log = LogFactory.getLog(SaleDetailHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SaleDetail transientInstance) {
		log.debug("persisting SaleDetail instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SaleDetail persistentInstance) {
		log.debug("removing SaleDetail instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SaleDetail merge(SaleDetail detachedInstance) {
		log.debug("merging SaleDetail instance");
		try {
			SaleDetail result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SaleDetail findById(int id) {
		log.debug("getting SaleDetail instance with id: " + id);
		try {
			SaleDetail instance = entityManager.find(SaleDetail.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
