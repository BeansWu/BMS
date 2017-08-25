package org.bms.controller;

import java.io.IOException;
import java.util.List;

import org.bms.entity.Reader;
import org.bms.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @Description: 读者管理-读者信息管理
 * @author: Andrew 
 * @date:   2017-06-05
 */
@Controller
@RequestMapping(value = "/admin/reader-mgt/reader-info-mgt/")
public class ReaderMgtReaderInfoMgtHandler {
	
	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";
	
	@Autowired
	private ReaderService readerService;
	
	@ResponseBody
	@RequestMapping(value = "/find-all")
	public List<Reader> findAll() {
		return readerService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public String saveOrUpdate(@RequestBody Reader reader) throws JsonParseException, JsonMappingException, IOException {
		if (readerService.saveOrUpdate(reader)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/del")
	public String del(String id) {
		if (readerService.del(id)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
}
