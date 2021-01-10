package com.bakery.management.db.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bakery.management.db.entity.CashAccount;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Account.
 * @see CashAccount
 * @author Hibernate Tools
 */

public class CashAccountHome {

	private static final Log log = LogFactory.getLog(CashAccountHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CashAccount transientInstance) {
		log.debug("persisting CashAccount instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CashAccount persistentInstance) {
		log.debug("removing CashAccount instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CashAccount merge(CashAccount detachedInstance) {
		log.debug("merging CashAccount instance");
		try {
			CashAccount result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CashAccount findById(int id) {
		log.debug("getting CashAccount instance with id: " + id);
		try {
			CashAccount instance = entityManager.find(CashAccount.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
