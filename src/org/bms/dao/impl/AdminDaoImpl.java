package org.bms.dao.impl;

import java.util.List;

import org.bms.dao.AdminDao;
import org.bms.dao.common.BaseDao;
import org.bms.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @Description: AdminDaoImpl
 * @author: Andrew 
 * @date:   2017-06-03
 */
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {

	@Autowired
	BaseDao baseDao;
	
	@Override
	public List<Admin> findAll() {
		return baseDao.query("from Admin");
	}

	@Override
	public Boolean del(Integer id) {
		return baseDao.delete("delete from Admin a where a.id = ?", id);
	}

	@Override
	public Boolean add(Admin admin) {
		return baseDao.add(admin);
	}

	@Override
	public Boolean update(Admin admin) {
		String hql = "update Admin a "
				+ "set a.sysSet = ?, a.bookMgt = ?, a.readerMgt = ?, a.bookBorrowAndReturn = ?, a.sysSearch = ? "
				+ "where a.id = ?";
		return baseDao.update(hql, admin.getSysSet(), admin.getBookMgt(), admin.getReaderMgt(), admin.getBookBorrowAndReturn(), admin.getSysSearch(), admin.getId());
	}

	@Override
	public Admin findByName(String name) {
		return baseDao.queryForBean("from Admin a where a.name = ?", name);
	}
}
