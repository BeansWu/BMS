package org.bms.service;

import java.util.List;

import org.bms.entity.BorrowRecord;

/**
 * @Description: BorrowRecordService
 * @author: Andrew 
 * @date:   2017-06-19
 */
public interface BorrowRecordService {
	/**
	 * @Title: findAll   
	 * @Description: 查询所有图书借阅记录
	 * @param: @return      
	 * @return: List<BorrowRecord>      
	 * @throws
	 */
	List<BorrowRecord> findAll();
	/**
	 * @Title: fuzzyQuery   
	 * @Description:  模糊查询
	 * @param: @param basis
	 * @param: @param borrowDateLowerBoundStr
	 * @param: @param borrowDateUpperBoundStr
	 * @param: @param basisType
	 * @param: @return      
	 * @return: List<BorrowRecord>      
	 * @throws
	 */
	List<BorrowRecord> fuzzyQuery(String basis, String borrowDateLowerBoundStr, String borrowDateUpperBoundStr, String basisType);
}
