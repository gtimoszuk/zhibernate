package org.zhibernate.domain;

import java.util.Calendar;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhibernate.util.HibernateUtil;

public class PersonTest {

	private static final Logger log = LoggerFactory.getLogger(PersonTest.class);

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
	public void simpleAddEvent() {
		//XXX gti DB lookup hard code
		Event e = (Event) session.get(Event.class, 37L);
		Person p = new Person();
		p.getEvents().add(e);
		session.save(p);
	}
	
	 
	@Test
	public void simpleAddEvent2() {
		//XXX gti DB lookup hard code
		Event e = new Event("event");
		Long eId = (Long) session.save(e);
		Event e2 = (Event) session.get(Event.class, eId);
		Person p = new Person();
		p.getEvents().add(e2);
		session.save(p);
	}
	
	@Test
	public void simpleGetAddr() {
		Person aPerson = (Person) session.get(Person.class, 38L);
		log.info(aPerson.toString());
	}
	
	@Test
	public void simpleAddAddr(){
		Person aPerson = (Person) session.get(Person.class, 38L);
		aPerson.getEmailAddresses().add("emailAddress " + Calendar.getInstance().getTime().toString());
		session.save(aPerson);
	}
	
	

}
