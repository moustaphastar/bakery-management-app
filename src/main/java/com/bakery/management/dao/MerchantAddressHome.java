package com.bakery.management.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.domain.MerchantAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class MerchantAddress.
 * @see com.bakery.management.domain.MerchantAddress
 * @author Hibernate Tools
 */

public class MerchantAddressHome {

	private static final Log log = LogFactory.getLog(MerchantAddressHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(MerchantAddress transientInstance) {
		log.debug("persisting MerchantAddress instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(MerchantAddress persistentInstance) {
		log.debug("removing MerchantAddress instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public MerchantAddress merge(MerchantAddress detachedInstance) {
		log.debug("merging MerchantAddress instance");
		try {
			MerchantAddress result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public MerchantAddress findById(int id) {
		log.debug("getting MerchantAddress instance with id: " + id);
		try {
			MerchantAddress instance = entityManager.find(MerchantAddress.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
