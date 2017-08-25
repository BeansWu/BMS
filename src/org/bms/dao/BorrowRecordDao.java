package org.bms.dao;

import java.sql.Timestamp;
import java.util.List;

import org.bms.entity.Book;
import org.bms.entity.BorrowRecord;
import org.bms.entity.Reader;

/**
 * @Description: BorrowRecordDao
 * @author: Andrew 
 * @date:   2017-06-10
 */
public interface BorrowRecordDao {
	/**
	 * @Title: save   
	 * @Description: 添加借阅记录
	 * @param: @param borrowRecord      
	 * @return: void      
	 * @throws
	 */
	void save(BorrowRecord borrowRecord);
	/**
	 * @Title: update   
	 * @Description: 更新借阅记录(归还图书)
	 * @param: @param book
	 * @param: @param reader
	 * @param: @param borrowDate
	 * @param: @param returnDate      
	 * @return: void      
	 * @throws
	 */
	void update(Book book, Reader reader, Timestamp borrowDate, Timestamp returnDate);
	/**
	 * @Title: findAll   
	 * @Description: findAll
	 * @param: @return      
	 * @return: List<BorrowRecord>        
	 * @throws
	 */
	List<BorrowRecord> findAll();
	/**
	 * @Title: findByBookBarCode   
	 * @Description: 根据图书条形码查找
	 * @param: @param bookBarCode
	 * @param: @return      
	 * @return: List<BorrowRecord>      
	 * @throws
	 */
	List<BorrowRecord> findByBookBarCode(String bookBarCode);
	/**
	 * @Title: findByBookName   
	 * @Description: 根据图书名称查找
	 * @param: @param bookName
	 * @param: @return      
	 * @return: List<BorrowRecord>      
	 * @throws
	 */
	List<BorrowRecord> findByBookName(String bookName);
	/**
	 * @Title: findByReaderBarCode   
	 * @Description: 根据读者条形码查找
	 * @param: @param readerBarCode
	 * @param: @return      
	 * @return: List<BorrowRecord>      
	 * @throws
	 */
	List<BorrowRecord> findByReaderBarCode(String readerBarCode);
	/**
	 * @Title: findByReaderName   
	 * @Description: 根据读者名称查找
	 * @param: @param readerName
	 * @param: @return      
	 * @return: List<BorrowRecord>      
	 * @throws
	 */
	List<BorrowRecord> findByReaderName(String readerName);
}
