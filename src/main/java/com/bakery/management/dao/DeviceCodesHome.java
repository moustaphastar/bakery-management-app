package com.bakery.management.dao;

import com.bakery.management.domain.DeviceCodes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Home object for domain model class DeviceCodes.
 *
 * @author Hibernate Tools
 * @see DeviceCodes
 */
public class DeviceCodesHome {

	private static final Log log = LogFactory.getLog(DeviceCodesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DeviceCodes transientInstance) {
		log.debug("persisting DeviceCodes instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DeviceCodes persistentInstance) {
		log.debug("removing DeviceCodes instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DeviceCodes merge(DeviceCodes detachedInstance) {
		log.debug("merging DeviceCodes instance");
		try {
			DeviceCodes result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DeviceCodes findById(Serializable id) {
		log.debug("getting DeviceCodes instance with id: " + id);
		try {
			DeviceCodes instance = entityManager.find(DeviceCodes.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}