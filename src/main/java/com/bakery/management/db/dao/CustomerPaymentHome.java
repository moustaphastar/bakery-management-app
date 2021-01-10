package com.bakery.management.db.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bakery.management.db.entity.CustomerPayment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class CustomerPayment.
 * @see com.bakery.management.db.entity.CustomerPayment
 * @author Hibernate Tools
 */

public class CustomerPaymentHome {

	private static final Log log = LogFactory.getLog(CustomerPaymentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CustomerPayment transientInstance) {
		log.debug("persisting CustomerPayment instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CustomerPayment persistentInstance) {
		log.debug("removing CustomerPayment instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CustomerPayment merge(CustomerPayment detachedInstance) {
		log.debug("merging CustomerPayment instance");
		try {
			CustomerPayment result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustomerPayment findById(int id) {
		log.debug("getting CustomerPayment instance with id: " + id);
		try {
			CustomerPayment instance = entityManager.find(CustomerPayment.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
