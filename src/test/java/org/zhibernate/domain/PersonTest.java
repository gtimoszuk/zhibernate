package org.zhibernate.domain;

import java.util.Calendar;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhibernate.util.HibernateUtil;

public class PersonTest {

	private static final Logger log = LoggerFactory.getLogger(PersonTest.class);

	static Session session;

	Long e2Id;
	Long eId;

	@Before
	public void before() {
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();

		Event e = new Event("event");
		eId = (Long) session.save(e);

		Event e2 = new Event("event");
		e2Id = (Long) session.save(e2);

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
	public void simpleAddEvent() {
		Event e = (Event) session.get(Event.class, eId);
		Person p = new Person();
		p.getEvents().add(e);
		session.save(p);
	}

	@Test
	public void simpleAddEvent2() {
		Event e = (Event) session.get(Event.class, eId);
		Event e2 = (Event) session.get(Event.class, e2Id);
		Person p = new Person();
		p.getEvents().add(e2);
		p.getEvents().add(e);

		session.save(p);
	}

	@Test
	public void simpleGetAddr() {
		// prepare
		Person p = new Person();
		Long pId = (Long) session.save(p);

		// test
		Person aPerson = (Person) session.get(Person.class, pId);
		log.info(aPerson.toString());
	}

	@Test
	public void simpleAddAddr() {
		// prepare
		Person p = new Person();
		Long pId = (Long) session.save(p);

		// test
		Person aPerson = (Person) session.get(Person.class, pId);
		aPerson.getEmailAddresses().add("emailAddress " + Calendar.getInstance().getTime().toString());
		session.save(aPerson);
	}

}
