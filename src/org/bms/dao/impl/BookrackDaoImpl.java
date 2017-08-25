package org.bms.dao.impl;

import java.util.List;

import org.bms.dao.BookrackDao;
import org.bms.dao.common.BaseDao;
import org.bms.entity.Bookrack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Description: BookrackDaoImpl
 * @author: Andrew
 * @date: 2017-05-23
 */
@Repository("bookrackDao")
public class BookrackDaoImpl implements BookrackDao {

	@Autowired
	private BaseDao baseDao;

	@Override
	public Boolean add(Bookrack bookrack) {
		return baseDao.add(bookrack);
	}

	@Override
	public Boolean del(Integer id) {
		return baseDao.delete("delete from Bookrack br where br.id = ?", id);
	}

	@Override
	public Boolean update(Bookrack bookrack) {
		return baseDao.update(bookrack);
	}

	@Override
	public Bookrack findByPressmark(String pressmark) {
		return baseDao.queryForBean("from Bookrack br where br.pressmark = ?", pressmark);
	}

	@Override
	public List<Bookrack> findAll() {
		return baseDao.query("from Bookrack br");
	}

}
