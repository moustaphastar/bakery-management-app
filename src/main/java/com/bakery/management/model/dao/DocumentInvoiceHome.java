package com.bakery.management.model.dao;
// Generated 19 Ara 2020 06:40:20 by Hibernate Tools 5.2.12.Final


import com.bakery.management.model.entity.DocumentInvoice;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class DocumentInvoice.
 * @see com.bakery.management.model.entity.DocumentInvoice
 * @author Hibernate Tools
 */

public class DocumentInvoiceHome {

	private static final Log log = LogFactory.getLog(DocumentInvoiceHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(DocumentInvoice transientInstance) {
		log.debug("persisting DocumentInvoice instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(DocumentInvoice persistentInstance) {
		log.debug("removing DocumentInvoice instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public DocumentInvoice merge(DocumentInvoice detachedInstance) {
		log.debug("merging DocumentInvoice instance");
		try {
			DocumentInvoice result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public DocumentInvoice findById(String id) {
		log.debug("getting DocumentInvoice instance with id: " + id);
		try {
			DocumentInvoice instance = entityManager.find(DocumentInvoice.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
