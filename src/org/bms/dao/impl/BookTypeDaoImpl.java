package org.bms.dao.impl;

import java.util.List;

import org.bms.dao.BookTypeDao;
import org.bms.dao.common.BaseDao;
import org.bms.entity.BookType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @Description: BookTypeDaoImpl 
 * @author: Andrew 
 * @date:   2017-05-23
 */
@Repository("bookTypeDao")
public class BookTypeDaoImpl implements BookTypeDao {

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Boolean add(BookType bookType) {
		return baseDao.add(bookType);
	}
	@Override
	public Boolean del(Integer id) {
		return baseDao.delete("delete from BookType bt where bt.id = ?", id);
	}
	@Override
	public Boolean update(BookType bookType) {
		return baseDao.update(bookType);
	}
	@Override
	public BookType findByNumber(String number) {
		return baseDao.queryForBean("from BookType bt where bt.number = ?", number);
	}
	@Override
	public List<BookType> findAll() {
		return baseDao.query("from BookType bt");
	}
}
