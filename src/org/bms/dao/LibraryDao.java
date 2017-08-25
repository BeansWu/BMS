package org.bms.dao;

import org.bms.entity.Library;

/**
 * @Description: LibraryDao
 * @author: Andrew 
 * @date:   2017-06-01
 */
public interface LibraryDao {
	/**
	 * @Title: add   
	 * @Description: 添加图书馆信息  
	 * @param: @param library      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean add (Library library);
	/**
	 * @Title: update   
	 * @Description: 更新图书馆信息 
	 * @param: @param library      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update (Library library);
	/**
	 * @Title: find   
	 * @Description: 查找图书馆信息 
	 * @param: @return      
	 * @return: Library      
	 * @throws
	 */
	Library find ();
}
