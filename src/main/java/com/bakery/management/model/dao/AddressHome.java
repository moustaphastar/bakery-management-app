package com.bakery.management.model.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.model.entity.Address;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Address.
 * @see com.bakery.management.model.entity.Address
 * @author Hibernate Tools
 */

public class AddressHome {

	private static final Log log = LogFactory.getLog(AddressHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Address transientInstance) {
		log.debug("persisting Address instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Address persistentInstance) {
		log.debug("removing Address instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Address merge(Address detachedInstance) {
		log.debug("merging Address instance");
		try {
			Address result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Address findById(int id) {
		log.debug("getting Address instance with id: " + id);
		try {
			Address instance = entityManager.find(Address.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
