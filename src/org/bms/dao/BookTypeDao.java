package org.bms.dao;

import java.util.List;

import org.bms.entity.BookType;

/**
 * @Description: BookTypeDao 
 * @author: Andrew 
 * @date:   2017-05-23
 */
public interface BookTypeDao{
	/**
	 * @Title: add   
	 * @Description: 添加书籍类型 
	 * @param: @param bookType      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean add (BookType bookType);
	/**
	 * @Title: del   
	 * @Description: 删除书籍类型
	 * @param: @param id      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del (Integer id);
	/**
	 * @Title: update   
	 * @Description: 更新书籍类型
	 * @param: @param bookType      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update (BookType bookType);
	/**
	 * @Title: findByNumber
	 * @Description: 根据编号查找书籍类型
	 * @param: @param number      
	 * @return: BookType      
	 * @throws
	 */
	BookType findByNumber (String number);
	/**
	 * @Title: findAll   
	 * @Description: findAll 
	 * @param:       
	 * @return: void      
	 * @throws
	 */
	List<BookType> findAll ();
}
