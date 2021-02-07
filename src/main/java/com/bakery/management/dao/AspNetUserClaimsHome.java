package com.bakery.management.dao;

import com.bakery.management.domain.AspNetUserClaims;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AspNetUserClaims.
 *
 * @author Hibernate Tools
 * @see AspNetUserClaims
 */
public class AspNetUserClaimsHome {

	private static final Log log = LogFactory.getLog(AspNetUserClaimsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(AspNetUserClaims transientInstance) {
		log.debug("persisting AspNetUserClaims instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(AspNetUserClaims persistentInstance) {
		log.debug("removing AspNetUserClaims instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public AspNetUserClaims merge(AspNetUserClaims detachedInstance) {
		log.debug("merging AspNetUserClaims instance");
		try {
			AspNetUserClaims result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public AspNetUserClaims findById(int id) {
		log.debug("getting AspNetUserClaims instance with id: " + id);
		try {
			AspNetUserClaims instance = entityManager.find(AspNetUserClaims.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
