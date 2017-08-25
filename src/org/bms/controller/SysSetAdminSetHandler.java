package org.bms.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.bms.entity.Admin;
import org.bms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 系统设置-管理员设置
 * @author: Andrew 
 * @date:   2017-06-03
 */
@Controller
@RequestMapping(value = "/super-admin/sys-set/admin-set")
public class SysSetAdminSetHandler {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private AdminService adminService;
	
	@ResponseBody
	@RequestMapping(value = "/find-all")
	public List<Admin> findAll(HttpServletRequest request) {
		List<Admin> list = adminService.findAll();
		Iterator<Admin> it = list.iterator();
		Integer adminId = (Integer) request.getSession().getAttribute("adminId");
		//当前登陆的管理员无法对自身进行管理员管理
		while (it.hasNext()) {
			Admin admin = it.next();
			if (admin.getId().equals(adminId)) {
				it.remove();
			}
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody Admin admin) {
		if (adminService.save(admin)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/del")
	public String del(String id) {
		if (adminService.del(id)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestBody Admin admin) {
		if (adminService.update(admin)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
}
