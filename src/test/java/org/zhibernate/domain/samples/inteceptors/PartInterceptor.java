package org.zhibernate.domain.samples.inteceptors;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.EmptyInterceptor;
import org.hibernate.Transaction;
import org.hibernate.type.Type;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhibernate.domain.samples.Part;

public class PartInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 9059896586755454359L;

	private static final Logger log = LoggerFactory
			.getLogger(PartInterceptor.class);

	private int updates;
	private int creates;
	private int loads;

	public void onDelete(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		// do nothing
		log.info("onDelete");
	}

	public boolean onFlushDirty(Object entity, Serializable id,
			Object[] currentState, Object[] previousState,
			String[] propertyNames, Type[] types) {
		log.info("onFlushDirty");
		if (entity instanceof Part) {
			updates++;
			for (int i = 0; i < propertyNames.length; i++) {
				if ("lastUpdateTimestamp".equals(propertyNames[i])) {
					currentState[i] = new Date();
					return true;
				}
			}
		}
		return false;
	}

	public boolean onLoad(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		log.info("onLoad");
		if (entity instanceof Part) {
			loads++;
		}
		return false;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state,
			String[] propertyNames, Type[] types) {
		log.info("onSave");

		if (entity instanceof Part) {
			creates++;
			for (int i = 0; i < propertyNames.length; i++) {
				if ("createTimestamp".equals(propertyNames[i])) {
					state[i] = new Date();
					return true;
				}
			}
		}
		return false;
	}

	public void afterTransactionCompletion(Transaction tx) {
		log.info("afterTransactionCompletion");
		if (tx.wasCommitted()) {
			log.info("Creations: " + creates + ", Updates: " + updates,
					"Loads: " + loads);
		}
		updates = 0;
		creates = 0;
		loads = 0;
	}

}
