package org.zhibernate.domain;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhibernate.util.HibernateUtil;

public class EventTest {
	private static final Logger log = LoggerFactory.getLogger(EventTest.class);

	static Session session;

	@Before
	public void before() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
	}

	@After
	public void after() {
		session.getTransaction().commit();

	}

	@AfterClass
	public static void afterClass() {
		HibernateUtil.getSessionFactory().close();
	}

	@Test
	public void simpleInsert() {
		Event theEvent = new Event();
		theEvent.setTitle("title");
		theEvent.setDate(Calendar.getInstance().getTime());
		session.save(theEvent);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void simpleSelect() {
		List<Event> result = session.createQuery("from Event").list();
		log.info(result.toString());
	}

}
