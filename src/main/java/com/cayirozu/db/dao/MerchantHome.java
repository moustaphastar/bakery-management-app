package com.cayirozu.db.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cayirozu.db.entity.Merchant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Merchant.
 * @see com.cayirozu.db.entity.Merchant
 * @author Hibernate Tools
 */

public class MerchantHome {

	private static final Log log = LogFactory.getLog(MerchantHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Merchant transientInstance) {
		log.debug("persisting Merchant instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Merchant persistentInstance) {
		log.debug("removing Merchant instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Merchant merge(Merchant detachedInstance) {
		log.debug("merging Merchant instance");
		try {
			Merchant result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Merchant findById(String id) {
		log.debug("getting Merchant instance with id: " + id);
		try {
			Merchant instance = entityManager.find(Merchant.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
