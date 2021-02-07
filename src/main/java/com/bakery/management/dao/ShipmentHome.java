package com.bakery.management.dao;

import com.bakery.management.domain.Shipment;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Shipment.
 *
 * @author Hibernate Tools
 * @see Shipment
 */
public class ShipmentHome {

	private static final Log log = LogFactory.getLog(ShipmentHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Shipment transientInstance) {
		log.debug("persisting Shipment instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Shipment persistentInstance) {
		log.debug("removing Shipment instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Shipment merge(Shipment detachedInstance) {
		log.debug("merging Shipment instance");
		try {
			Shipment result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Shipment findById(int id) {
		log.debug("getting Shipment instance with id: " + id);
		try {
			Shipment instance = entityManager.find(Shipment.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}