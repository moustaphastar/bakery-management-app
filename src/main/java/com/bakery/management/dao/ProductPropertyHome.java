package com.bakery.management.dao;

import com.bakery.management.domain.ProductProperty;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ProductProperty.
 *
 * @author Hibernate Tools
 * @see ProductProperty
 */
public class ProductPropertyHome {

	private static final Log log = LogFactory.getLog(ProductPropertyHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProductProperty transientInstance) {
		log.debug("persisting ProductProperty instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProductProperty persistentInstance) {
		log.debug("removing ProductProperty instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProductProperty merge(ProductProperty detachedInstance) {
		log.debug("merging ProductProperty instance");
		try {
			ProductProperty result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductProperty findById(int id) {
		log.debug("getting ProductProperty instance with id: " + id);
		try {
			ProductProperty instance = entityManager.find(ProductProperty.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
