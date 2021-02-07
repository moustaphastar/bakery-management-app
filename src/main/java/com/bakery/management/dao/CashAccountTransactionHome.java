package com.bakery.management.dao;

import com.bakery.management.domain.CashTransaction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AccountTransaction.
 * @see CashTransaction
 * @author Hibernate Tools
 */
public class CashAccountTransactionHome {

	private static final Log log = LogFactory.getLog(CashAccountTransactionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CashTransaction transientInstance) {
		log.debug("persisting CashAccountTransaction instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CashTransaction persistentInstance) {
		log.debug("removing CashAccountTransaction instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CashTransaction merge(CashTransaction detachedInstance) {
		log.debug("merging CashAccountTransaction instance");
		try {
			CashTransaction result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CashTransaction findById(int id) {
		log.debug("getting CashAccountTransaction instance with id: " + id);
		try {
			CashTransaction instance = entityManager.find(CashTransaction.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
