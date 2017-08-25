package org.bms.dao.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bms.dao.LibraryDao;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLibraryDao {
	static ClassPathXmlApplicationContext ctx = null;
	static LibraryDao libraryDao = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		libraryDao = ctx.getBean(LibraryDao.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		ctx.close();
	}

	@Test
	public void test() {
//		Library library = new Library("霍格沃兹", "苏格兰爱丁堡", new Date(), "9又4分之3站台");
//		libraryDao.add(library);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
	}

}
