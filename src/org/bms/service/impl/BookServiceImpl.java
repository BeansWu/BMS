package org.bms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.bms.dao.BookDao;
import org.bms.entity.Book;
import org.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: BookServiceImpl
 * @author: Andrew
 * @date: 2017-06-18
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	@Transactional(readOnly = true)
	@Override
	public List<Book> findAll() {
		return bookDao.findAll();
	}

	@Transactional
	@Override
	public Boolean saveOrUpdate(Book book) {
		if (book.getId() == null) {
			return bookDao.add(book);
		} else {
			return bookDao.update(book);
		}
	}

	@Transactional
	@Override
	public Boolean del(String id) {
		return bookDao.del(Integer.parseInt(id));
	}

	@Transactional(readOnly = true)
	@Override
	public Book findBook(String bookBasisType, String bookBasis) {
		switch (bookBasisType) {
		case "book-bar-code": {
			return bookDao.findByBarCode(bookBasis);
		}
		case "book-name": {
			return bookDao.findByName(bookBasis);
		}
		default:
			return null;
		}
	}

	@Transactional(readOnly = true)
	@Override
	public List<Book> findBooksHasBorrow(String readerBarCode) {
		return bookDao.findByReaderBarCode(readerBarCode);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Book> findByBasis(String basis, String basisType) {
		switch(basisType) {
		case "bar-code": {
			Book book = bookDao.findByBarCode(basis);
			List<Book> temp = new ArrayList<Book>();
			temp.add(book);
			return temp;
		}
		case "type": {
			return bookDao.findByTypeName(basis);
		}
		case "name": {
			Book book = bookDao.findByName(basis);
			List<Book> temp = new ArrayList<Book>();
			temp.add(book);
			return temp;
		}
		case "author": {
			return bookDao.findByAuthor(basis);
		}
		case "press": {
			return bookDao.findByPress(basis);
		}
		case "bookrack": {
			return bookDao.findByBookrack(basis);
		}
		default: return null;
	}
	}

}
