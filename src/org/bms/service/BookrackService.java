package org.bms.service;

import java.util.List;

import org.bms.entity.Bookrack;

/**
 * @Description: BookrackService
 * @author: Andrew 
 * @date:   2017-06-18
 */
public interface BookrackService {
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
	Boolean del (String id);
	/**
	 * @Title: update   
	 * @Description: 更新书架信息  
	 * @param: @param bookrack      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update (Bookrack bookrack);
	/**
	 * @Title: findAll   
	 * @Description: findAll   
	 * @param: @return      
	 * @return: List<Bookrack>      
	 * @throws
	 */
	List<Bookrack> findAll ();
}
