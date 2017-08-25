package org.bms.dao.test;

import java.util.List;

import org.bms.dao.BookNumberDao;
import org.bms.entity.BookNumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestISBNDao {

	static ClassPathXmlApplicationContext ctx = null;
	static BookNumberDao bookNumberDao = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookNumberDao = ctx.getBean(BookNumberDao.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Test
	public void testAddISBN() {
		BookNumber i1 = new BookNumber("123456", "电子工业出版社");
		BookNumber i2 = new BookNumber("654321", "清华大学出版社");
		BookNumber i3 = new BookNumber("111111", "福建师范大学出版社");
		bookNumberDao.add(i1);
		bookNumberDao.add(i2);
		bookNumberDao.add(i3);
	}

	@Test
	public void testDel() {
//		bookNumberDao.del("123456");
	}

	@Test
	public void testUpdateISBN() {
//		BookNumber i = bookNumberDao.findByISBN("111111");
//		i.setInterSBN("222222");
//		bookNumberDao.update(i);
	}

	@Test
	public void testFindAll() {
		List<BookNumber> list = bookNumberDao.findAll();
		for (BookNumber i : list) {
			System.out.println(i);
		}
	}

}
