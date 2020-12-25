package com.cayirozu.db.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cayirozu.db.entity.EmployeeLeave;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class EmployeeLeave.
 * @see com.cayirozu.db.entity.EmployeeLeave
 * @author Hibernate Tools
 */

public class EmployeeLeaveHome {

	private static final Log log = LogFactory.getLog(EmployeeLeaveHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(EmployeeLeave transientInstance) {
		log.debug("persisting EmployeeLeave instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(EmployeeLeave persistentInstance) {
		log.debug("removing EmployeeLeave instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public EmployeeLeave merge(EmployeeLeave detachedInstance) {
		log.debug("merging EmployeeLeave instance");
		try {
			EmployeeLeave result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public EmployeeLeave findById(int id) {
		log.debug("getting EmployeeLeave instance with id: " + id);
		try {
			EmployeeLeave instance = entityManager.find(EmployeeLeave.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
