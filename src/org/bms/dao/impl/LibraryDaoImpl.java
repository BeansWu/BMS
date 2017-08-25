package org.bms.dao.impl;

import org.bms.dao.LibraryDao;
import org.bms.dao.common.BaseDao;
import org.bms.entity.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Description: LibraryDaoImpl
 * @author: Andrew
 * @date: 2017-06-01
 */
@Repository("libraryDao")
public class LibraryDaoImpl implements LibraryDao {

	@Autowired
	BaseDao baseDao;

	@Override
	public Boolean add(Library library) {
		return baseDao.add(library);
	}

	@Override
	public Boolean update(Library library) {
		return baseDao.update(library);
	}

	@Override
	public Library find() {
		return baseDao.queryForBean("from Library l");
	}

}
