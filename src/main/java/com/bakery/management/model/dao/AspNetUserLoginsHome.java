package com.bakery.management.model.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.model.entity.AspNetUserLogins;
import com.bakery.management.model.entity.AspNetUserLoginsId;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AspNetUserLogins.
 * @see com.bakery.management.model.entity.AspNetUserLogins
 * @author Hibernate Tools
 */

public class AspNetUserLoginsHome {

	private static final Log log = LogFactory.getLog(AspNetUserLoginsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AspNetUserLogins transientInstance) {
		log.debug("persisting AspNetUserLogins instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AspNetUserLogins persistentInstance) {
		log.debug("removing AspNetUserLogins instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AspNetUserLogins merge(AspNetUserLogins detachedInstance) {
		log.debug("merging AspNetUserLogins instance");
		try {
			AspNetUserLogins result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AspNetUserLogins findById(AspNetUserLoginsId id) {
		log.debug("getting AspNetUserLogins instance with id: " + id);
		try {
			AspNetUserLogins instance = entityManager.find(AspNetUserLogins.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
