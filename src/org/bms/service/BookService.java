package org.bms.service;

import java.util.List;

import org.bms.entity.Book;

/**
 * @Description: BookService
 * @author: Andrew 
 * @date:   2017-06-18
 */
public interface BookService {
	/**
	 * @Title: findAll   
	 * @Description: 查找所有书籍信息
	 * @param: @return      
	 * @return: List<Book>      
	 * @throws
	 */
	List<Book> findAll();
	/**
	 * @Title: saveOrUpdate   
	 * @Description: 添加或者更新图书信息
	 * @param: @param book
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean saveOrUpdate(Book book);
	/**
	 * @Title: del   
	 * @Description: 删除图书信息
	 * @param: @param id
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del(String id);
	/**
	 * @Title: findBook   
	 * @Description:  根据查询依据类型和查询依据查找图书
	 * @param: @param bookBasisType
	 * @param: @param bookBasis
	 * @param: @return      
	 * @return: Book      
	 * @throws
	 */
	Book findBook(String bookBasisType, String bookBasis);
	/**
	 * @Title: findBooksHasBorrow   
	 * @Description:  查询已借阅的图书-图书记录中的读者条形码存在
	 * @param: @param readerBarCode
	 * @param: @return      
	 * @return: List<Book>      
	 * @throws
	 */
	List<Book> findBooksHasBorrow(String readerBarCode);
	/**
	 * @Title: findByBasis   
	 * @Description:  根据查询依据类型及查询依据进行模糊查询
	 * @param: @param basis
	 * @param: @param basisType
	 * @param: @return      
	 * @return: List<Book>      
	 * @throws
	 */
	List<Book> findByBasis(String basis, String basisType);
}
