package org.bms.service;

import java.util.List;

import org.bms.entity.BookNumber;

/**
 * @Description: BookNumberService
 * @author: Andrew 
 * @date:   2017-06-18
 */
public interface BookNumberService {
	/**
	 * @Title: findAll   
	 * @Description: 查找所有 ISBN 信息
	 * @param: @return      
	 * @return: List<BookNumber>      
	 * @throws
	 */
	List<BookNumber> findAll();
}
