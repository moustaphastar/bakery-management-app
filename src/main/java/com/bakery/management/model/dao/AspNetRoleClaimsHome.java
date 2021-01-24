package com.bakery.management.model.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.model.entity.AspNetRoleClaims;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AspNetRoleClaims.
 * @see com.bakery.management.model.entity.AspNetRoleClaims
 * @author Hibernate Tools
 */

public class AspNetRoleClaimsHome {

	private static final Log log = LogFactory.getLog(AspNetRoleClaimsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AspNetRoleClaims transientInstance) {
		log.debug("persisting AspNetRoleClaims instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AspNetRoleClaims persistentInstance) {
		log.debug("removing AspNetRoleClaims instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AspNetRoleClaims merge(AspNetRoleClaims detachedInstance) {
		log.debug("merging AspNetRoleClaims instance");
		try {
			AspNetRoleClaims result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AspNetRoleClaims findById(int id) {
		log.debug("getting AspNetRoleClaims instance with id: " + id);
		try {
			AspNetRoleClaims instance = entityManager.find(AspNetRoleClaims.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
