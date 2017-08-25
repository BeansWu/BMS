package org.bms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bms.entity.Admin;
import org.bms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 管理员登陆
 * @author: Andrew 
 * @date:   2017-06-19
 */
@Controller
@RequestMapping(value = "/admin/login")
public class AdminLoginHandler {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private AdminService adminService;
	
	@ResponseBody
	@RequestMapping(value = "/info-verify", method = RequestMethod.POST)
	public String infoVerify(String name, String password, HttpServletRequest request) {
		Admin admin = adminService.loginInfoVerify(name, password);
		if (admin != null) {
			request.getSession().setAttribute("adminId", admin.getId());
			request.getSession().setAttribute("adminLevel", admin.getAdminLevel().toString());
			
			Map<String, Boolean> roles = new HashMap<String, Boolean>();
			roles.put("sysSet", admin.getSysSet());
			roles.put("readerMgt", admin.getReaderMgt());
			roles.put("bookMgt", admin.getBookMgt());
			roles.put("bookBorrowAndReturn", admin.getBookBorrowAndReturn());
			roles.put("sysSearch", admin.getSysSearch());
			request.getSession().setAttribute("roles", roles);
			
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/query-roles")
	public HashMap<String, Boolean> queryRoles(HttpServletRequest request) {
		return (HashMap<String, Boolean>) request.getSession().getAttribute("roles");
	}
	
	@ResponseBody
	@RequestMapping(value = "/query-admin-level")
	public String queryAdminLevel(HttpServletRequest request) {
		return (String) request.getSession().getAttribute("adminLevel");
	}
}
