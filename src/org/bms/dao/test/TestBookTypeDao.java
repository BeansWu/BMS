package org.bms.dao.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.bms.dao.BookTypeDao;
import org.bms.entity.BookType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBookTypeDao {

	static ClassPathXmlApplicationContext ctx = null;
	static BookTypeDao bookTypeDao = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookTypeDao = ctx.getBean(BookTypeDao.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Test
	public void testAddBookType() {
		BookType bt1 = new BookType("学习", 30);
		BookType bt2 = new BookType("奇幻", 30);
		BookType bt3 = new BookType("武侠", 30);
		bookTypeDao.add(bt1);
		bookTypeDao.add(bt2);
		bookTypeDao.add(bt3);
	}

	@Test
	public void testDel() {
		bookTypeDao.del(1);
	}

	@Test
	public void testUpdateBookType() {
		BookType bt = bookTypeDao.findByNumber("A01");
		bt.setName("编程");
		bookTypeDao.update(bt);
	}

	@Test
	public void testFindByNumber() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		List<BookType> list = bookTypeDao.findAll();
		for (BookType bt : list) {
			System.out.println(bt);
		}
	}

}
