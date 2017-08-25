package org.bms.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.bms.dao.BorrowRecordDao;
import org.bms.dao.common.BaseDao;
import org.bms.entity.Book;
import org.bms.entity.BorrowRecord;
import org.bms.entity.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 * @Description: BorrowRecordDaoImpl
 * @author: Andrew 
 * @date:   2017-06-10
 */
@Repository("borrowRecordDao")
public class BorrowRecordDaoImpl implements BorrowRecordDao {

	@Autowired
	private BaseDao baseDao;
	
	@Transactional
	@Override
	public void save(BorrowRecord borrowRecord) {
		baseDao.add(borrowRecord);
	}
	@Transactional
	@Override
	public void update(Book book, Reader reader, Timestamp borrowDate, Timestamp returnDate) {
		BorrowRecord borrowRecord = baseDao.queryForBean("from BorrowRecord br "
				+ "where br.book = ? and br.reader = ? and br.borrowDate = ? and br.returnDate = ?", book, reader, borrowDate, returnDate);
		borrowRecord.setHasReturn(true);
		baseDao.update(borrowRecord);
	}
	@Transactional(readOnly = true)
	@Override
	public List<BorrowRecord> findAll() {
		return baseDao.query("from BorrowRecord br");
	}
	@Transactional(readOnly = true)
	@Override
	public List<BorrowRecord> findByBookBarCode(String bookBarCode) {
		return baseDao.query("from BorrowRecord br where br.book.barCode = ?", bookBarCode);
	}
	@Transactional(readOnly = true)
	@Override
	public List<BorrowRecord> findByBookName(String bookName) {
		return baseDao.query("from BorrowRecord br where br.book.name = ?", bookName);
	}
	@Transactional(readOnly = true)
	@Override
	public List<BorrowRecord> findByReaderBarCode(String readerBarCode) {
		return baseDao.query("from BorrowRecord br where br.reader.barCode = ?", readerBarCode);
	}
	@Transactional(readOnly = true)
	@Override
	public List<BorrowRecord> findByReaderName(String readerName) {
		return baseDao.query("from BorrowRecord br where br.reader.name = ?", readerName);
	}

}
