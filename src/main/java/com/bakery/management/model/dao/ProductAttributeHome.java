package com.bakery.management.model.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.model.entity.ProductAttribute;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ProductAttribute.
 * @see com.bakery.management.model.entity.ProductAttribute
 * @author Hibernate Tools
 */

public class ProductAttributeHome {

	private static final Log log = LogFactory.getLog(ProductAttributeHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ProductAttribute transientInstance) {
		log.debug("persisting ProductAttribute instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ProductAttribute persistentInstance) {
		log.debug("removing ProductAttribute instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ProductAttribute merge(ProductAttribute detachedInstance) {
		log.debug("merging ProductAttribute instance");
		try {
			ProductAttribute result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ProductAttribute findById(int id) {
		log.debug("getting ProductAttribute instance with id: " + id);
		try {
			ProductAttribute instance = entityManager.find(ProductAttribute.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
