package org.bms.service;

import java.util.List;

import org.bms.entity.ReaderType;

/**
 * @Description: ReaderTypeService
 * @author: Andrew 
 * @date:   2017-06-18
 */
public interface ReaderTypeService {
	/**
	 * @Title: add   
	 * @Description: 添加读者类型
	 * @param: @param readerType      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean add (ReaderType readerType);
	/**
	 * @Title: 删除读者类型   
	 * @Description: TODO   
	 * @param: @param id      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del (String id);
	/**
	 * @Title: update   
	 * @Description: 更新读者类型  
	 * @param: @param user      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update (ReaderType readerType);
	/**
	 * @Title: findAll   
	 * @Description: findAll
	 * @param: @return      
	 * @return: List<ReaderType>      
	 * @throws
	 */
	List<ReaderType> findAll ();
	
}
