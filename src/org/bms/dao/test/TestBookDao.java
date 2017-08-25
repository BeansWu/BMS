package org.bms.dao.test;

import java.util.List;

import org.bms.dao.BookDao;
import org.bms.dao.BookNumberDao;
import org.bms.dao.BookTypeDao;
import org.bms.dao.BookrackDao;
import org.bms.entity.Book;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBookDao {
	
	static ClassPathXmlApplicationContext ctx = null;
	static BookDao bookDao = null;
	static BookrackDao bookrackDao = null;
	static BookTypeDao bookTypeDao = null;
	static BookNumberDao bookNumberDao = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookDao = ctx.getBean(BookDao.class);
		bookrackDao = ctx.getBean(BookrackDao.class);
		bookTypeDao = ctx.getBean(BookTypeDao.class);
		bookNumberDao = ctx.getBean(BookNumberDao.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Test
	public void testAdd() {
//		Bookrack bookrack = bookrackDao.findByPressmark("A1");
//		BookType bookType = bookTypeDao.findByNumber("A01");
//		BookNumber ISBN = bookNumberDao.findByISBN("222222");
//		Book b1 = new Book(bookrack, bookType, ISBN, "Java:从入门到放弃", "Andrew", "11111", 500, "Mike");
//		Book b2 = new Book(bookrack, bookType, ISBN, "Java:从入门到精通", "Andrew", "11111", 500, "Mike");
//		bookDao.add(b1);
//		bookDao.add(b2);
	}

	@Test
	public void testDel() {
		bookDao.del(1);
	}

	@Test
	public void testUpdate() {
		Book b = bookDao.findByBarCode("20176916159");
		b.setReader(null);
		bookDao.update(b);
	}

	@Test
	public void testFindByReaderBarCode() {
		List<Book> books = bookDao.findByReaderBarCode("201706052045");
		System.out.println(books.size());
	}

}
