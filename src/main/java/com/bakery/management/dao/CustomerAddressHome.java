package com.bakery.management.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.domain.CustomerAddress;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CustomerAddress.
 * @see com.bakery.management.domain.CustomerAddress
 * @author Hibernate Tools
 */

public class CustomerAddressHome {

	private static final Log log = LogFactory.getLog(CustomerAddressHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CustomerAddress transientInstance) {
		log.debug("persisting CustomerAddress instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CustomerAddress persistentInstance) {
		log.debug("removing CustomerAddress instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CustomerAddress merge(CustomerAddress detachedInstance) {
		log.debug("merging CustomerAddress instance");
		try {
			CustomerAddress result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustomerAddress findById(int id) {
		log.debug("getting CustomerAddress instance with id: " + id);
		try {
			CustomerAddress instance = entityManager.find(CustomerAddress.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
