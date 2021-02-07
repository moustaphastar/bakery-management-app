package com.bakery.management.dao;

import com.bakery.management.domain.AspNetRoles;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Home object for domain model class AspNetRoles.
 *
 * @author Hibernate Tools
 * @see AspNetRoles
 */
public class AspNetRolesHome {

	private static final Log log = LogFactory.getLog(AspNetRolesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AspNetRoles transientInstance) {
		log.debug("persisting AspNetRoles instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AspNetRoles persistentInstance) {
		log.debug("removing AspNetRoles instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AspNetRoles merge(AspNetRoles detachedInstance) {
		log.debug("merging AspNetRoles instance");
		try {
			AspNetRoles result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AspNetRoles findById(Serializable id) {
		log.debug("getting AspNetRoles instance with id: " + id);
		try {
			AspNetRoles instance = entityManager.find(AspNetRoles.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}