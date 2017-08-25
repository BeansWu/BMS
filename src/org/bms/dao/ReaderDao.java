package org.bms.dao;

import java.util.List;

import org.bms.entity.Reader;

/**
 * @Description: ReaderDao 
 * @author: Andrew 
 * @date:   2017-06-05
 */
public interface ReaderDao {
	/**
	 * @Title: add   
	 * @Description: 添加读者
	 * @param: @param reader      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean add (Reader reader);
	/**
	 * @Title: del   
	 * @Description: 删除读者
	 * @param: @param id      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del (Integer id);
	/**
	 * @Title: update   
	 * @Description: 更新读者信息
	 * @param: @param reader      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update (Reader reader);
	/**
	 * @Title: findAll   
	 * @Description: findAll
	 * @param: @return      
	 * @return: List<Reader>      
	 * @throws
	 */
	List<Reader> findAll ();
	/**
	 * @Title: findByBarCode   
	 * @Description: 通过 barCode 查找读者
	 * @param: @param barCode
	 * @param: @return      
	 * @return: Reader      
	 * @throws
	 */
	Reader findByBarCode (String barCode);
}
