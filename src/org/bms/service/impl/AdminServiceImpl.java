package org.bms.service.impl;

import java.util.List;

import org.bms.dao.AdminDao;
import org.bms.entity.Admin;
import org.bms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @Description: AdminServiceImpl
 * @author: Andrew 
 * @date:   2017-06-18
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	@Transactional
	@Override
	public Boolean save(Admin admin) {
		return adminDao.add(admin);
	}
	
	@Transactional
	@Override
	public Boolean del(String id) {
		return adminDao.del(Integer.parseInt(id));
	}

	@Transactional
	@Override
	public Boolean update(Admin admin) {
		return adminDao.update(admin);
	}

	@Transactional(readOnly = true)
	@Override
	public Admin loginInfoVerify(String name, String password) {
		Admin admin = adminDao.findByName(name);
		if (admin != null) {
			if (password.equals(admin.getPassword())) {
				return admin;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
