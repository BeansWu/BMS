package org.bms.service.impl;

import java.util.List;

import org.bms.dao.ReaderTypeDao;
import org.bms.entity.ReaderType;
import org.bms.service.ReaderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: ReaderTypeServiceImpl
 * @author: Andrew
 * @date: 2017-06-18
 */
@Service("readerTypeService")
public class ReaderTypeServiceImpl implements ReaderTypeService {

	@Autowired
	private ReaderTypeDao readerTypeDao;

	@Transactional
	@Override
	public Boolean add(ReaderType readerType) {
		return readerTypeDao.add(readerType);
	}

	@Transactional
	@Override
	public Boolean del(String id) {
		return readerTypeDao.del(Integer.parseInt(id));
	}

	@Transactional
	@Override
	public Boolean update(ReaderType readerType) {
		return readerTypeDao.update(readerType);
	}

	@Transactional(readOnly = true)
	@Override
	public List<ReaderType> findAll() {
		return readerTypeDao.findAll();
	}

}
