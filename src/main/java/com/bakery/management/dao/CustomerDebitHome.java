package com.bakery.management.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.domain.CustomerDebit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CustomerDebit.
 * @see com.bakery.management.domain.CustomerDebit
 * @author Hibernate Tools
 */

public class CustomerDebitHome {

	private static final Log log = LogFactory.getLog(CustomerDebitHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CustomerDebit transientInstance) {
		log.debug("persisting CustomerDebit instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CustomerDebit persistentInstance) {
		log.debug("removing CustomerDebit instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CustomerDebit merge(CustomerDebit detachedInstance) {
		log.debug("merging CustomerDebit instance");
		try {
			CustomerDebit result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustomerDebit findById(int id) {
		log.debug("getting CustomerDebit instance with id: " + id);
		try {
			CustomerDebit instance = entityManager.find(CustomerDebit.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
