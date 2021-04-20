package com.bakery.management.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.domain.DocumentShipment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class DocumentShipment.
 * @see com.bakery.management.domain.DocumentShipment
 * @author Hibernate Tools
 */

public class DocumentShipmentHome {

	private static final Log log = LogFactory.getLog(DocumentShipmentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DocumentShipment transientInstance) {
		log.debug("persisting DocumentShipment instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DocumentShipment persistentInstance) {
		log.debug("removing DocumentShipment instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DocumentShipment merge(DocumentShipment detachedInstance) {
		log.debug("merging DocumentShipment instance");
		try {
			DocumentShipment result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DocumentShipment findById(int id) {
		log.debug("getting DocumentShipment instance with id: " + id);
		try {
			DocumentShipment instance = entityManager.find(DocumentShipment.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
