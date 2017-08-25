package org.bms.service.impl;

import java.util.List;

import org.bms.dao.BookrackDao;
import org.bms.entity.Bookrack;
import org.bms.service.BookrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @Description: BookrackServiceImpl
 * @author: Andrew 
 * @date:   2017-06-18
 */
@Service("bookrackService")
public class BookrackServiceImpl implements BookrackService {

	@Autowired
	private BookrackDao bookrackDao;
	
	@Transactional
	@Override
	public Boolean add(Bookrack bookrack) {
		return bookrackDao.add(bookrack);
	}
	@Transactional
	@Override
	public Boolean del(String id) {
		return bookrackDao.del(Integer.parseInt(id));
	}
	@Transactional
	@Override
	public Boolean update(Bookrack bookrack) {
		return bookrackDao.update(bookrack);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Bookrack> findAll() {
		return bookrackDao.findAll();
	}

}
