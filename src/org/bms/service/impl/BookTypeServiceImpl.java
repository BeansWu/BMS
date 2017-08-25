package org.bms.service.impl;

import java.util.List;

import org.bms.dao.BookTypeDao;
import org.bms.entity.BookType;
import org.bms.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @Description: BookTypeServiceImpl
 * @author: Andrew 
 * @date:   2017-06-18
 */
@Service("bookTypeService")
public class BookTypeServiceImpl implements BookTypeService {

	@Autowired
	private BookTypeDao bookTypeDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<BookType> findAll() {
		return bookTypeDao.findAll();
	}
	@Transactional
	@Override
	public Boolean add(BookType bookType) {
		return bookTypeDao.add(bookType);
	}
	@Transactional
	@Override
	public Boolean del(String id) {
		return bookTypeDao.del(Integer.parseInt(id));
	}
	@Transactional
	@Override
	public Boolean update(BookType bookType) {
		return bookTypeDao.update(bookType);
	}

}
