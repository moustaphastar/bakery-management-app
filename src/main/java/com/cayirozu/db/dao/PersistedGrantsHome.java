package com.cayirozu.db.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cayirozu.db.entity.PersistedGrants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class PersistedGrants.
 * @see com.cayirozu.db.entity.PersistedGrants
 * @author Hibernate Tools
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
