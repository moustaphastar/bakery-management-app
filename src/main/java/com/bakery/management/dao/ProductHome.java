package com.bakery.management.dao;

import com.bakery.management.domain.Product;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Product.
 *
 * @author Hibernate Tools
 * @see Product
 */
public class ProductHome {

	private static final Log log = LogFactory.getLog(ProductHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Product transientInstance) {
		log.debug("persisting Product instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Product persistentInstance) {
		log.debug("removing Product instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Product merge(Product detachedInstance) {
		log.debug("merging Product instance");
		try {
			Product result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Product findById(String id) {
		log.debug("getting Product instance with id: " + id);
		try {
			Product instance = entityManager.find(Product.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
