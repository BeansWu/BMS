package org.bms.dao.test;

import org.bms.dao.BookDao;
import org.bms.dao.BorrowRecordDao;
import org.bms.dao.ReaderDao;
import org.bms.entity.Book;
import org.bms.entity.Reader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBorrowRecordDao {

	static ClassPathXmlApplicationContext ctx = null;
	static BorrowRecordDao borrowRecordDao = null;
	static BookDao bookDao = null;
	static ReaderDao readerDao = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		borrowRecordDao = ctx.getBean(BorrowRecordDao.class);
		bookDao = ctx.getBean(BookDao.class);
		readerDao = ctx.getBean(ReaderDao.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Test
	public void testSave() {
		Book book = bookDao.findByBarCode("20176916059");
		Reader reader = readerDao.findByBarCode("201706052045");
//		BorrowRecord borrowRecord = new BorrowRecord(book, reader, book.getBorrowDate(), book.getReturnDate());
//		borrowRecordDao.save(borrowRecord);
	}

	@Test
	public void testUpdate() {
		Book book = bookDao.findByBarCode("20176916059");
		Reader reader = readerDao.findByBarCode("201706052045");
//		borrowRecordDao.update(book, reader, book.getBorrowDate(), book.getReturnDate());
	}

	@Test
	public void testFindAll() {
		System.out.println(borrowRecordDao.findAll().size());
	}

	@Test
	public void testFindByBookBarCode() {
		System.out.println(borrowRecordDao.findByBookBarCode("20176916059").size());
	}

	@Test
	public void testFindByBookName() {
		System.out.println(borrowRecordDao.findByBookName("Java:从入门到放弃").size());
	}

	@Test
	public void testFindByReaderBarCode() {
		System.out.println(borrowRecordDao.findByReaderBarCode("201706052045").size());
	}

	@Test
	public void testFindByReaderName() {
		System.out.println(borrowRecordDao.findByReaderName("Andrew").size());
	}

}
