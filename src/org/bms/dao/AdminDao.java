package org.bms.dao;

import java.util.List;

import org.bms.entity.Admin;

/**
 * @Description: AdminDao
 * @author: Andrew 
 * @date:   2017-06-03
 */
public interface AdminDao {
	/**
	 * @Title: findAll   
	 * @Description: 找到所有管理员
	 * @param: @return      
	 * @return: List<Admin>      
	 * @throws
	 */
	List<Admin> findAll();
	/**
	 * @Title: del   
	 * @Description: 删除管理员
	 * @param: @param id      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del(Integer id);
	/**
	 * @Title: add   
	 * @Description: 添加管理员 
	 * @param: @param admin      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean add(Admin admin);
	/**
	 * @Title: update   
	 * @Description: 更新管理员信息
	 * @param: @param admin      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update(Admin admin);
	/**
	 * @Title: findByName   
	 * @Description: 根据名称查找管理员
	 * @param: @param name
	 * @param: @return      
	 * @return: Admin      
	 * @throws
	 */
	Admin findByName(String name);
}
