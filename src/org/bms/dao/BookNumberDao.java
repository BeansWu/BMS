package org.bms.dao;

import java.util.List;

import org.bms.entity.BookNumber;

/**
 * @Description: ISBNDao
 * @author: Andrew 
 * @date:   2017-05-23
 */
public interface BookNumberDao {
	/**
	 * @Title: add   
	 * @Description: 添加 ISBN
	 * @param: @param BookNumber      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean add (BookNumber bookNumber);
	/**
	 * @Title: findAll   
	 * @Description: findAll 
	 * @param: @return      
	 * @return: List<BookNumber>      
	 * @throws
	 */
	List<BookNumber> findAll ();
}
