package org.bms.dao.test;

import java.util.List;

import org.bms.dao.BookrackDao;
import org.bms.entity.Bookrack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBookrackDao {

	static ClassPathXmlApplicationContext ctx = null;
	static BookrackDao bookrackDao = null;
	
	@Before
	public void before() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookrackDao = ctx.getBean(BookrackDao.class);
	}
	
	@Test
	public void testAddBookrack() {
		Bookrack bookrack1 = new Bookrack("A1");
		bookrackDao.add(bookrack1);
		Bookrack bookrack2 = new Bookrack("A2");
		bookrackDao.add(bookrack2);
		Bookrack bookrack3 = new Bookrack("A3");
		bookrackDao.add(bookrack3);
	}

	@Test
	public void testDel() {
		bookrackDao.del(1);
	}

	@Test
	public void testUpdateBookrack() {
		Bookrack bookrack = bookrackDao.findByPressmark("A4");
		bookrack.setPressmark("A3");
		bookrackDao.update(bookrack);
	}

	@Test
	public void testFindAll() {
		List<Bookrack> bookracks = bookrackDao.findAll();
		for (Bookrack br : bookracks) {
			System.out.println(br);
		}
	}

	@After
	public void after() {
		ctx.close();
	}
}
