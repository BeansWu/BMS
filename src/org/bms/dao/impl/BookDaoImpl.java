package org.bms.dao.impl;

import java.util.List;

import org.bms.dao.BookDao;
import org.bms.dao.common.BaseDao;
import org.bms.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @Description: BookDaoImpl
 * @author: Andrew 
 * @date:   2017-05-23
 */
@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Boolean add(Book book) {
		return baseDao.add(book);
	}
	@Override
	public Boolean del(Integer id) {
		return baseDao.delete("delete from Book b where b.id = ?", id);
	}
	@Override
	public Boolean update(Book book) {
		return baseDao.update(book);
	}
	@Override
	public List<Book> findAll() {
		return baseDao.query("from Book b");
	}
	@Override
	public Book findByBarCode(String barCode) {
		return baseDao.queryForBean("from Book b where b.barCode = ?", barCode);
	}
	@Override
	public Book findByName(String name) {
		return baseDao.queryForBean("from Book b where b.name = ?", name);
	}
	@Override
	public List<Book> findByReaderBarCode(String readerBarCode) {
		return baseDao.query("from Book b where b.reader.barCode = ?", readerBarCode);
	}
	@Override
	public List<Book> findByTypeName(String bookTypeName) {
		return baseDao.query("from Book b where b.bookType.name = ?", bookTypeName);
	}
	@Override
	public List<Book> findByAuthor(String author) {
		return baseDao.query("from Book b where b.author = ?", author);
	}
	@Override
	public List<Book> findByPress(String press) {
		return baseDao.query("from Book b where b.bookNumber.press = ?", press);
	}
	@Override
	public List<Book> findByBookrack(String pressmark) {
		return baseDao.query("from Book b where b.bookrack.pressmark = ?", pressmark);
	}
	@Override
	public Book findById(Integer bookId) {
		return baseDao.queryForBean("from Book b where b.id = ?", bookId);
	}
}
