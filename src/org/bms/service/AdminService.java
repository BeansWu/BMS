package org.bms.service;

import java.util.List;

import org.bms.entity.Admin;

/**
 * @Description: AdminService
 * @author: Andrew 
 * @date:   2017-06-18
 */
public interface AdminService {
	/**
	 * @Title: findAll   
	 * @Description: 查询所有管理员
	 * @param: @return      
	 * @return: List<Admin>      
	 * @throws
	 */
	List<Admin> findAll();
	/**
	 * @Title: save   
	 * @Description: 添加管理员
	 * @param: @param admin      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean save(Admin admin);
	/**
	 * @Title: del   
	 * @Description: 删除管理员
	 * @param: @param id      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del(String id);
	/**
	 * @Title: update   
	 * @Description: 更新管理员信息
	 * @param: @param admin      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update(Admin admin);
	/**
	 * @Title: loginInfoVerify   
	 * @Description: 登陆信息验证
	 * @param: @param name
	 * @param: @param password
	 * @param: @return      
	 * @return: Admin      
	 * @throws
	 */
	Admin loginInfoVerify(String name, String password);
}
