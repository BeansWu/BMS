package org.bms.controller;

import org.bms.entity.Library;
import org.bms.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 系统设置-图书馆信息 Controller
 * @author: Andrew
 * @date: 2017-06-03
 */
@Controller
@RequestMapping(value = "/admin/sys-set/library")
public class SysSetLibraryInfoHandler {

	private static String SUCCESS = "{\"result\":\"success\"}";
	private static String FAILURE = "{\"result\":\"failure\"}";

	@Autowired
	private LibraryService libraryService;

	@ResponseBody
	@RequestMapping(value = "/get-library-info")
	public Library find() {
		return libraryService.find();
	}

	@ResponseBody
	@RequestMapping(value = "/update-library-info", method = RequestMethod.POST)
	public String update(@RequestBody Library newLibraryInfo) {
		if (libraryService.update(newLibraryInfo)) {
			return SUCCESS;
		} else {
			return FAILURE;
		}
	}
}
