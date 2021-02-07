package com.bakery.management.dao;

import com.bakery.management.domain.CustomerDiscount;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CustomerDiscount.
 *
 * @author Hibernate Tools
 * @see CustomerDiscount
 */
public class CustomerDiscountHome {

	private static final Log log = LogFactory.getLog(CustomerDiscountHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CustomerDiscount transientInstance) {
		log.debug("persisting CustomerDiscount instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CustomerDiscount persistentInstance) {
		log.debug("removing CustomerDiscount instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CustomerDiscount merge(CustomerDiscount detachedInstance) {
		log.debug("merging CustomerDiscount instance");
		try {
			CustomerDiscount result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CustomerDiscount findById(int id) {
		log.debug("getting CustomerDiscount instance with id: " + id);
		try {
			CustomerDiscount instance = entityManager.find(CustomerDiscount.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
