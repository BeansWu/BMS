package org.bms.controller;

import java.util.List;

import org.bms.entity.BookType;
import org.bms.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 图书管理-图书类型管理
 * @author: Andrew 
 * @date:   2017-06-05
 */
@Controller
@RequestMapping(value = "/admin/book-mgt/book-type-mgt/")
public class BookMgtBookTypeMgtHandler {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private BookTypeService bookTypeService;
	
	@ResponseBody
	@RequestMapping(value = "/find-all")
	public List<BookType> findAll() {
		return bookTypeService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody BookType bookType) {
		if (bookTypeService.add(bookType)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/del")
	public String del(String id) {
		if (bookTypeService.del(id)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestBody BookType bookType) {
		if (bookTypeService.update(bookType)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
}
