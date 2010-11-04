package org.zhibernate.domain.samples.events;

import org.hibernate.HibernateException;
import org.hibernate.event.LoadEvent;
import org.hibernate.event.LoadEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomLoadListener implements LoadEventListener {
	
	private static final Logger log = LoggerFactory.getLogger(CustomLoadListener.class);


	private static final long serialVersionUID = -4858086168073342795L;


	@Override
	public void onLoad(LoadEvent event, LoadType loadType)
			throws HibernateException {
		log.info("onLoad event");
		log.info("EVENT: " + event.toString() );
		
		
	}

}
