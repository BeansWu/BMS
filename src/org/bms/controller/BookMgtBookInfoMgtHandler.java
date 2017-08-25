package org.bms.controller;

import java.util.List;

import org.bms.entity.Book;
import org.bms.entity.BookNumber;
import org.bms.service.BookNumberService;
import org.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 图书管理-图书信息管理
 * @author: Andrew 
 * @date:   2017-06-05
 */
@Controller
@RequestMapping(value = "/admin/book-mgt/book-info-mgt/")
public class BookMgtBookInfoMgtHandler {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private BookService bookService;
	@Autowired
	private BookNumberService bookNumberService;
	
	@ResponseBody
	@RequestMapping(value = "/find-all")
	public List<Book> findAll() {
		return bookService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(@RequestBody Book book) {
		if (bookService.saveOrUpdate(book)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/del")
	public String del(String id) {
		if (bookService.del(id)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/find-all-bookNumber")
	public List<BookNumber> findAllBookNumber() {
		return bookNumberService.findAll();
	}
}
