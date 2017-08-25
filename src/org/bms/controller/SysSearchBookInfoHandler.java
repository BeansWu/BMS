package org.bms.controller;

import java.util.List;

import org.bms.entity.Book;
import org.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 系统查询-图书信息查询
 * @author: Andrew
 * @date: 2017-06-10
 */
@Controller
@RequestMapping(value = "/admin/sys-search/book-info-search")
public class SysSearchBookInfoHandler {

	@Autowired
	private BookService bookService;

	@ResponseBody
	@RequestMapping(value = "/find-all")
	public List<Book> findAll() {
		return bookService.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/find-by-basis")
	public List<Book> findByBasis(String basis, String basisType) {
		return bookService.findByBasis(basis, basisType);
	}
}
