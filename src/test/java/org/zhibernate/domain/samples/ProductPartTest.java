package org.zhibernate.domain.samples;

import java.util.Set;

import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zhibernate.util.HibernateUtil;

public class ProductPartTest {

	private static final Logger log = LoggerFactory.getLogger(ProductPartTest.class);
	static Long part1Id;
	static Long part2Id;
	
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
	public void makeMulti2() {
		Part part1 = new Part("part1");
		part1Id = (Long) session.save(part1);
		Part part2 = new Part("part2");
		part2Id = (Long) session.save(part2);
		Product p1 = new Product("prod1");
		Long p1Id = (Long) session.save(p1);
		Product p2 = new Product("prod2");
		Long p2Id = (Long) session.save(p2);
		
		Product p1Saved = (Product) session.get(Product.class, p1Id);
		Part savedPart1 = (Part) session.get(Part.class, part1Id);
		Part savedPart2 = (Part) session.get(Part.class, part2Id);
		p1Saved.getMultiParts().add(savedPart1);
		p1Saved.getMultiParts().add(savedPart2);
		session.save(p1Saved);
		Part part1WithProduct = (Part) session.get(Part.class, part1Id);
		Set<Product> part1Products = (Set<Product>) ((Part) session.get(Part.class, part1Id)).getProducts();
		log.info(part1Products.toString());
	}
	
	
	@Test
	public void getMulti() {
		Part part1WithProduct = (Part) session.get(Part.class, part1Id);
		Set<Product> part1Products = (Set<Product>) ((Part) session.get(Part.class, part1Id)).getProducts();
		log.info(part1Products.toString());
		
	}

	
}
