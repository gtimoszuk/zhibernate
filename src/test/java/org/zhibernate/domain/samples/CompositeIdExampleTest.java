package org.zhibernate.domain.samples;

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

public class CompositeIdExampleTest {
	private static final Logger log = LoggerFactory.getLogger(CompositeIdExampleTest.class);

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
	public void testAdd() {
		CompositeIdExample c1 = new CompositeIdExample("aa" + Calendar.getInstance().getTime().toString(), "aa");
		session.save(c1);
		CompositeIdExample c2 = new CompositeIdExample("aa" + Calendar.getInstance().getTime().toString(), "bb");
		session.save(c2);
	}

	@Ignore
	@Test(expected=org.hibernate.exception.ConstraintViolationException.class)
	public void testAddFailure() {
		CompositeIdExample c1 = new CompositeIdExample("aa", "aa");
		session.save(c1);
	}

	

	
}
