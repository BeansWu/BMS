package org.bms.dao.impl;

import java.util.List;

import org.bms.dao.BookNumberDao;
import org.bms.dao.common.BaseDao;
import org.bms.entity.BookNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @Description: ISBNDaoImpl
 * @author: Andrew 
 * @date:   2017-05-23
 */
@Repository("bookNumberDao")
public class BookNumberDaoImpl implements BookNumberDao {
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Boolean add(BookNumber bookNumber) {
		return baseDao.add(bookNumber);
	}
	
	@Override
	public List<BookNumber> findAll() {
		return baseDao.query("from BookNumber bn");
	}
}
