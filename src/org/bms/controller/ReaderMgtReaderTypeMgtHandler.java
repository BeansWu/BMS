package org.bms.controller;

import java.util.List;

import org.bms.entity.ReaderType;
import org.bms.service.ReaderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 读者管理-读者类型管理
 * @author: Andrew
 * @date: 2017-06-05
 */
@Controller
@RequestMapping(value = "/admin/reader-mgt/reader-type-mgt/")
public class ReaderMgtReaderTypeMgtHandler {

	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";

	@Autowired
	private ReaderTypeService readerTypeService;

	@ResponseBody
	@RequestMapping(value = "/find-all")
	public List<ReaderType> findAll() {
		return readerTypeService.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@RequestBody ReaderType readerType) {
		if (readerTypeService.add(readerType)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/del")
	public String del(String id) {
		if (readerTypeService.del(id)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}

	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@RequestBody ReaderType readerType) {
		if (readerTypeService.update(readerType)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
}
