package com.bakery.management.dao;

import com.bakery.management.domain.AspNetUserTokens;
import com.bakery.management.domain.AspNetUserTokensId;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AspNetUserTokens.
 *
 * @author Hibernate Tools
 * @see AspNetUserTokens
 */
public class AspNetUserTokensHome {

	private static final Log log = LogFactory.getLog(AspNetUserTokensHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AspNetUserTokens transientInstance) {
		log.debug("persisting AspNetUserTokens instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AspNetUserTokens persistentInstance) {
		log.debug("removing AspNetUserTokens instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AspNetUserTokens merge(AspNetUserTokens detachedInstance) {
		log.debug("merging AspNetUserTokens instance");
		try {
			AspNetUserTokens result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AspNetUserTokens findById(AspNetUserTokensId id) {
		log.debug("getting AspNetUserTokens instance with id: " + id);
		try {
			AspNetUserTokens instance = entityManager.find(AspNetUserTokens.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
