package org.bms.service;

import org.bms.entity.Library;

/**
 * @Description: LibraryService
 * @author: Andrew 
 * @date:   2017-06-18
 */
public interface LibraryService {
	/**
	 * @Title: update   
	 * @Description: 更新图书馆信息
	 * @param: @param library
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update (Library library);
	/**
	 * @Title: find   
	 * @Description: 查询图书馆信息
	 * @param: @return      
	 * @return: Library      
	 * @throws
	 */
	Library find ();
}
