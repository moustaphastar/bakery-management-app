package com.bakery.management.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final

import com.bakery.management.domain.AspNetUsers;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Home object for domain model class AspNetUsers.
 * @see com.bakery.management.domain.AspNetUsers
 * @author Hibernate Tools
 */

public class AspNetUsersHome {

	private static final Log log = LogFactory.getLog(AspNetUsersHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AspNetUsers transientInstance) {
		log.debug("persisting AspNetUsers instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AspNetUsers persistentInstance) {
		log.debug("removing AspNetUsers instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AspNetUsers merge(AspNetUsers detachedInstance) {
		log.debug("merging AspNetUsers instance");
		try {
			AspNetUsers result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AspNetUsers findById(Serializable id) {
		log.debug("getting AspNetUsers instance with id: " + id);
		try {
			AspNetUsers instance = entityManager.find(AspNetUsers.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
