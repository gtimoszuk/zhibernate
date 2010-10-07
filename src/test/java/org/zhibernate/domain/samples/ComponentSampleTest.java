package org.zhibernate.domain.samples;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhibernate.util.HibernateUtil;

public class ComponentSampleTest {
	
	private static final Logger log = LoggerFactory.getLogger(ComponentSampleTest.class);

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
	public void compomentChildTest() {
		CompomentChild compomentChild = new CompomentChild("childString", "anotherString");
		ComponentSample componentSample = new ComponentSample("someString", compomentChild);
		session.save(componentSample);
		
	}
}
