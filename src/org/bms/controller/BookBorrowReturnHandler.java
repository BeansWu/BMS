package org.bms.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.bms.entity.Book;
import org.bms.entity.Reader;
import org.bms.service.BookService;
import org.bms.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: 图书借还
 * @author: Andrew 
 * @date:   2017-06-08
 */
@Controller
@RequestMapping(value = "/admin/book-borrow-return")
public class BookBorrowReturnHandler {

	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private ReaderService readerService;
	@Autowired
	private BookService bookService;
	
	@ResponseBody
	@RequestMapping(value = "/find-reader", method = RequestMethod.POST)
	public Reader findReader(String readerBarCode) {
		return readerService.findByBarCode(readerBarCode);
	}
	
	@ResponseBody
	@RequestMapping(value = "/find-book", method = RequestMethod.POST)
	public Book findBook(String bookBasicType, String bookBasic) {
		return bookService.findBook(bookBasicType, bookBasic);
	}
	
	@ResponseBody
	@RequestMapping(value = "/borrow", method = RequestMethod.POST)
	public String borrow(@RequestBody Map<String, String> jsonArray) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Reader reader = mapper.readValue(jsonArray.get("reader"), Reader.class);
		Book book = mapper.readValue(jsonArray.get("book"), Book.class);
		
		if (readerService.borrow(book, reader)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/find-books-has-borrow", method = RequestMethod.POST)
	public List<Book> findBooksHasBorrow(String readerBarCode) {
		return bookService.findBooksHasBorrow(readerBarCode);
	}
	
	@ResponseBody
	@RequestMapping(value = "/remand", method = RequestMethod.POST)
	public String remand(String bookId) {
		if (readerService.remand(bookId)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
}
