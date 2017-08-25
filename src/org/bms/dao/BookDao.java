package org.bms.dao;

import java.util.List;

import org.bms.entity.Book;

/**
 * @Description: BookDao
 * @author: Andrew 
 * @date:   2017-05-23
 */
public interface BookDao {
	/**
	 * @Title: add   
	 * @Description: 添加书籍
	 * @param: @param book      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean add (Book book);
	/**
	 * @Title: del   
	 * @Description: 删除书籍
	 * @param: @param id      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean del (Integer id);
	/**
	 * @Title: update   
	 * @Description: 更新书籍信息  
	 * @param: @param book      
	 * @return: Boolean      
	 * @throws
	 */
	Boolean update (Book book);
	/**
	 * @Title: findByBarCode   
	 * @Description: 根据条形码查找图书
	 * @param: @param barCode      
	 * @return: Book      
	 * @throws
	 */
	Book findByBarCode (String barCode);
	/**
	 * @Title: findByName   
	 * @Description: 根据图书名称查找图书
	 * @param: @param name      
	 * @return: Book      
	 * @throws
	 */
	Book findByName (String name);
	/**
	 * @Title: findAll   
	 * @Description: findAll
	 * @param: @return      
	 * @return: List<Book>      
	 * @throws
	 */
	List<Book> findAll ();
	/**
	 * @Title: findByReaderBarCode   
	 * @Description:  根据 readerBarCode 查找已借阅图书
	 * @param: @param readerBarCode
	 * @param: @return      
	 * @return: List<Book>      
	 * @throws
	 */
	List<Book> findByReaderBarCode (String readerBarCode);
	/**
	 * @Title: findByBooktype   
	 * @Description: 根据图书类型名称查找书籍
	 * @param: @param bookTypeName
	 * @param: @return      
	 * @return: List<Book>      
	 * @throws
	 */
	List<Book> findByTypeName (String bookTypeName);
	/**
	 * @Title: findByAuthor   
	 * @Description: 根据作者查找书籍
	 * @param: @param bookTypeName
	 * @param: @return      
	 * @return: List<Book>      
	 * @throws
	 */
	List<Book> findByAuthor (String author);
	/**
	 * @Title: findByPress   
	 * @Description: 根据出版社查找书籍
	 * @param: @param bookTypeName
	 * @param: @return      
	 * @return: List<Book>      
	 * @throws
	 */
	List<Book> findByPress (String press);
	/**
	 * @Title: findByBookrack   
	 * @Description: 根据书架查找书籍
	 * @param: @param pressmark
	 * @param: @return      
	 * @return: List<Book>      
	 * @throws
	 */
	List<Book> findByBookrack (String pressmark);
	/**
	 * @Title: findById   
	 * @Description: 根据书号查找书籍
	 * @param: @param bookId
	 * @param: @return      
	 * @return: Book      
	 * @throws
	 */
	Book findById (Integer bookId);
}
