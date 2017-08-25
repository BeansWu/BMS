package org.bms.service.impl;

import java.util.List;

import org.bms.dao.BookDao;
import org.bms.dao.BorrowRecordDao;
import org.bms.dao.ReaderDao;
import org.bms.entity.Book;
import org.bms.entity.BorrowRecord;
import org.bms.entity.Reader;
import org.bms.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: ReaderServiceImpl
 * @author: Andrew
 * @date: 2017-06-18
 */
@Service("readerService")
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	private ReaderDao readerDao;
	@Autowired
	private BookDao bookDao;
	@Autowired
	private BorrowRecordDao borrowRecordDao;

	@Transactional(readOnly = true)
	@Override
	public List<Reader> findAll() {
		return readerDao.findAll();
	}

	@Transactional
	@Override
	public Boolean saveOrUpdate(Reader reader) {
		if (reader.getId() == null) {
			return readerDao.add(reader);
		} else {
			return readerDao.update(reader);
		}
	}

	@Transactional
	@Override
	public Boolean del(String id) {
		return readerDao.del(Integer.parseInt(id));
	}

	@Transactional(readOnly = true)
	@Override
	public Reader findByBarCode(String readerBarCode) {
		return readerDao.findByBarCode(readerBarCode);
	}

	@Transactional
	@Override
	public Boolean borrow(Book book, Reader reader) {
		try {
			book.setReader(reader);
			bookDao.update(book);

			reader.setHasBorrow(reader.getHasBorrow() + 1);
			readerDao.update(reader);

			BorrowRecord borrowRecord = new BorrowRecord(book, reader, book.getBorrowDate(), book.getReturnDate());
			borrowRecordDao.save(borrowRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional
	@Override
	public Boolean remand(String bookId) {
		try {
			Book book = bookDao.findById(Integer.parseInt(bookId));
			Reader reader = book.getReader();

			reader.setHasBorrow(reader.getHasBorrow() - 1);
			readerDao.update(reader);

			borrowRecordDao.update(book, reader, book.getBorrowDate(), book.getReturnDate());

			book.setReader(null);
			book.setBorrowDate("");
			book.setReturnDate("");
			bookDao.update(book);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
