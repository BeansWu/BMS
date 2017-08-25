package org.bms.dao.test;

import static org.junit.Assert.fail;

import java.util.List;

import org.bms.dao.BookDao;
import org.bms.dao.ReaderDao;
import org.bms.dao.ReaderTypeDao;
import org.bms.entity.Reader;
import org.bms.entity.ReaderType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestReaderDao {

	static ClassPathXmlApplicationContext ctx = null;
	static ReaderDao readerDao = null;
	static ReaderTypeDao readerTypeDao = null;
	static BookDao bookDao = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		readerDao = ctx.getBean(ReaderDao.class);
		readerTypeDao = ctx.getBean(ReaderTypeDao.class);
		bookDao = ctx.getBean(BookDao.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Test
	public void testAdd() {
		List<ReaderType> readerTypes = readerTypeDao.findAll();
		System.out.println(readerTypes.size());
		Reader reader = new Reader("20160606", "Andrew", readerTypes.get(0), "身份证", "110", "110", "1@qq.com");
		readerDao.add(reader);
	}

	@Test
	public void testDel() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		Reader reader = readerDao.findByBarCode("201706052045");
		System.out.println(reader);
	}

}
