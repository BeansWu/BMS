package org.bms.dao.impl;

import java.util.List;

import org.bms.dao.ReaderTypeDao;
import org.bms.dao.common.BaseDao;
import org.bms.entity.ReaderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Description: ReaderTypeDaoImpl
 * @author: Andrew
 * @date: 2017-06-05
 */
@Repository("readerTypeDao")
public class ReaderTypeDaoImpl implements ReaderTypeDao {

	@Autowired
	private BaseDao baseDao;

	@Override
	public Boolean add(ReaderType readerType) {
		return baseDao.add(readerType);
	}

	@Override
	public Boolean del(Integer id) {
		return baseDao.delete("delete from ReaderType rt where rt.id = ?", id);
	}

	@Override
	public Boolean update(ReaderType readerType) {
		return baseDao.update(readerType);
	}

	@Override
	public List<ReaderType> findAll() {
		return baseDao.query("from ReaderType rt");
	}

}
