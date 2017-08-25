package org.bms.service;

import java.util.List;

import org.bms.entity.BookType;

/**
 * @Description: BookTypeService
 * @author: Andrew 
 * @date:   2017-06-18
 */
public interface BookTypeService {
	/**
	 * @Title: findAll   
	 * @Description:  查询所有图书类型
	 * @param: @return      
	 * @return: List<BookType>      
	 * @throws
	 */
	List<BookType> findAll();
	/**
	 * @Title: add   
	 * @Description:  添加图书类型
	 * @param: @param bookType
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean add(BookType bookType);
	/**
	 * @Title: del   
	 * @Description:  根据 id 删除图书类型
	 * @param: @param id
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del(String id);
	/**
	 * @Title: update   
	 * @Description:  更新图书类型信息
	 * @param: @param bookType
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update(BookType bookType);
}
