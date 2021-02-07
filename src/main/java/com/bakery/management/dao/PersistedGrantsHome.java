package com.bakery.management.dao;

import com.bakery.management.domain.PersistedGrants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Home object for domain model class PersistedGrants.
 *
 * @author Hibernate Tools
 * @see PersistedGrants
 */
public class PersistedGrantsHome {

	private static final Log log = LogFactory.getLog(PersistedGrantsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PersistedGrants transientInstance) {
		log.debug("persisting PersistedGrants instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PersistedGrants persistentInstance) {
		log.debug("removing PersistedGrants instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PersistedGrants merge(PersistedGrants detachedInstance) {
		log.debug("merging PersistedGrants instance");
		try {
			PersistedGrants result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PersistedGrants findById(Serializable id) {
		log.debug("getting PersistedGrants instance with id: " + id);
		try {
			PersistedGrants instance = entityManager.find(PersistedGrants.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
