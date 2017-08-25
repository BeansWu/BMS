package org.bms.service;

import java.util.List;

import org.bms.entity.Book;
import org.bms.entity.Reader;

/**
 * @Description: ReaderService
 * @author: Andrew 
 * @date:   2017-06-18
 */
public interface ReaderService {
	/**
	 * @Title: findAll   
	 * @Description: 查找所有读者信息 
	 * @param: @return      
	 * @return: List<Reader>      
	 * @throws
	 */
	List<Reader> findAll();
	/**
	 * @Title: saveOrUpdate   
	 * @Description:  添加或者更新读者信息
	 * @param: @param reader
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean saveOrUpdate(Reader reader);
	/**
	 * @Title: del   
	 * @Description:  根据 id 删除读者
	 * @param: @param id
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del(String id);
	/**
	 * @Title: findByBarCode   
	 * @Description: 根据读者条形码查找读者
	 * @param: @param readerBarCode
	 * @param: @return      
	 * @return: Reader      
	 * @throws
	 */
	Reader findByBarCode(String readerBarCode);
	/**
	 * @Title: borrow   
	 * @Description:  借阅图书
	 * @param: @param book
	 * @param: @param reader
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean borrow(Book book, Reader reader);
	/**
	 * @Title: remand   
	 * @Description: 归还图书
	 * @param: @param bookId
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean remand(String bookId);
}
