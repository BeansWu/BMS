package org.bms.controller;

import java.util.List;

import org.bms.entity.BorrowRecord;
import org.bms.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: 系统查询-图书信息查询
 * @author: Andrew
 * @date: 2017-06-10
 */
@Controller
@RequestMapping(value = "/admin/sys-search/borrow-record-search")
public class SysSearchBorrowRecordHandler {

	@Autowired
	private BorrowRecordService borrowRecordService;

	@ResponseBody
	@RequestMapping(value = "/find-all")
	public List<BorrowRecord> findAll() {
		return borrowRecordService.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public List<BorrowRecord> find(String basis, String borrowDateLowerBoundStr, String borrowDateUpperBoundStr,
			String basisType) {
		return borrowRecordService.fuzzyQuery(basis, borrowDateLowerBoundStr, borrowDateUpperBoundStr, basisType);
	}
}
