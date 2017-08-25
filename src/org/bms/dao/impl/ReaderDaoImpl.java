package org.bms.dao.impl;

import java.util.List;

import org.bms.dao.ReaderDao;
import org.bms.dao.common.BaseDao;
import org.bms.entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @Description: ReaderDaoImpl
 * @author: Andrew 
 * @date:   2017-06-05
 */
@Repository("readerDao")
public class ReaderDaoImpl implements ReaderDao {

	@Autowired
	private BaseDao baseDao;
	
	@Override
	public Boolean add(Reader reader) {
		return baseDao.add(reader);
	}
	@Override
	public Boolean del(Integer id) {
		return baseDao.delete("delete from Reader r where r.id = ?", id);
	}
	@Override
	public Boolean update(Reader reader) {
		return baseDao.update(reader);
	}
	@Override
	public List<Reader> findAll() {
		return baseDao.query("from Reader r");
	}
	@Override
	public Reader findByBarCode(String barCode) {
		return baseDao.queryForBean("from Reader r where r.barCode = ?", barCode);
	}
}
