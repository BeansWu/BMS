package org.bms.service.impl;

import java.util.List;

import org.bms.dao.BookNumberDao;
import org.bms.entity.BookNumber;
import org.bms.service.BookNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: BookNumberServiceImpl
 * @author: Andrew 
 * @date:   2017-06-18
 */
@Service("bookNumberService")
public class BookNumberServiceImpl implements BookNumberService {

	@Autowired
	private BookNumberDao bookNumberDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<BookNumber> findAll() {
		return bookNumberDao.findAll();
	}

}
