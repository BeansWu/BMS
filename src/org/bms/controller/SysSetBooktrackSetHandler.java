package org.bms.controller;

import java.util.List;

import org.bms.entity.Bookrack;
import org.bms.service.BookrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 系统设置-书架设置
 * @author: Andrew 
 * @date:   2017-06-05
 */
@Controller
@RequestMapping(value = "/admin/sys-set/bookrack-set")
public class SysSetBooktrackSetHandler {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private BookrackService bookrackService;
	
	@ResponseBody
	@RequestMapping(value = "/find-all")
	public List<Bookrack> findAll() {
		return bookrackService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody Bookrack bookrack) {
		if (bookrackService.add(bookrack)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/del")
	public String del(String id) {
		if (bookrackService.del(id)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestBody Bookrack bookrack) {
		if (bookrackService.update(bookrack)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
}
