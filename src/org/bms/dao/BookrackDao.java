package org.bms.dao;

import java.util.List;

import org.bms.entity.Bookrack;

public interface BookrackDao {
	/**
	 * @Title: add   
	 * @Description: 添加书架
	 * @param: @param bookrack      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean add (Bookrack bookrack);
	/**
	 * @Title: del   
	 * @Description: 根据书架编号删除书籍
	 * @param: @param id      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del (Integer id);
	/**
	 * @Title: update   
	 * @Description: 更新书架信息  
	 * @param: @param bookrack      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update (Bookrack bookrack);
	/**
	 * @Title: findByISBN   
	 * @Description: 根据 书架编号查找书架
	 * @param: @param ISBN
	 * @return: Book
	 * @throws
	 */
	Bookrack findByPressmark (String pressmark);
	/**
	 * @Title: findAll   
	 * @Description: findAll   
	 * @param: @return      
	 * @return: List<Bookrack>      
	 * @throws
	 */
	List<Bookrack> findAll ();
}
