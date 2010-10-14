package org.zhibernate.domain.samples;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhibernate.domain.samples.inheritance.Circle;
import org.zhibernate.domain.samples.inheritance.Rectangle;
import org.zhibernate.util.HibernateUtil;

public class ShapeTest {

	private static final Logger log = LoggerFactory.getLogger(ShapeTest.class);

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
	public void addCircle() {
		Circle c1 = new Circle(1.1);
		session.save(c1);
		log.info("c1 area: " + c1.calculateArea());
	}
	
	@Test
	public void addRectangle() {
		Rectangle r1 = new Rectangle(2.3, 3.4);
		session.save(r1);
		log.info("r1 area" + r1.calculateArea());
	}
}
