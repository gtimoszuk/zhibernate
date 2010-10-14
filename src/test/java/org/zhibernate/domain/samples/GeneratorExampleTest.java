package org.zhibernate.domain.samples;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhibernate.util.HibernateUtil;

public class GeneratorExampleTest {

	private static final Logger log = LoggerFactory.getLogger(GeneratorExampleTest.class);

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
	public void test1() {
		GeneratorExample ge1 = new GeneratorExample("1");
		log.info("first id = " + session.save(ge1).toString());
		GeneratorExample ge2 = new GeneratorExample("2");
		session.save(ge2);
		GeneratorExample ge3 = new GeneratorExample("3");
		session.save(ge3);
		GeneratorExample ge4 = new GeneratorExample("4");
		log.info("last id = " + session.save(ge4));
		
	}
}
