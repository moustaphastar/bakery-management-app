package com.cayirozu.db.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cayirozu.db.entity.MerchantType;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class MerchantType.
 * @see com.cayirozu.db.entity.MerchantType
 * @author Hibernate Tools
 */

public class MerchantTypeHome {

	private static final Log log = LogFactory.getLog(MerchantTypeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MerchantType transientInstance) {
		log.debug("persisting MerchantType instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MerchantType persistentInstance) {
		log.debug("removing MerchantType instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MerchantType merge(MerchantType detachedInstance) {
		log.debug("merging MerchantType instance");
		try {
			MerchantType result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MerchantType findById(int id) {
		log.debug("getting MerchantType instance with id: " + id);
		try {
			MerchantType instance = entityManager.find(MerchantType.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
