package org.bms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 管理员登出
 * @author: Andrew 
 * @date:   2017-06-19
 */
@Controller
@RequestMapping(value = "/admin/logout")
public class AdminLogoutHandler {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@ResponseBody
	@RequestMapping(value = "/logout-verify")
	public String logout(HttpServletRequest request) {
		try{
			request.getSession().removeAttribute("adminId");
			request.getSession().removeAttribute("adminLevel");
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return FAILURE;
		}
	}
}
