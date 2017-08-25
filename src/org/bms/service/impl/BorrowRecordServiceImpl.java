package org.bms.service.impl;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import org.bms.dao.BorrowRecordDao;
import org.bms.entity.BorrowRecord;
import org.bms.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @Description: BorrowRecordServiceImpl
 * @author: Andrew 
 * @date:   2017-06-19
 */
@Service("borrowRecordService")
public class BorrowRecordServiceImpl implements BorrowRecordService {

	@Autowired
	private BorrowRecordDao borrowRecordDao;
	
	@Transactional(readOnly = true)
	@Override
	public List<BorrowRecord> findAll() {
		return borrowRecordDao.findAll();
	}

	@Transactional
	@Override
	public List<BorrowRecord> fuzzyQuery(String basis, String borrowDateLowerBoundStr, String borrowDateUpperBoundStr,
			String basisType) {
		List<BorrowRecord> list;
		if (basis != "") {
			switch(basisType) {
			case "book-bar-code": {
				list = filter(borrowRecordDao.findByBookBarCode(basis), borrowDateLowerBoundStr, borrowDateUpperBoundStr);
			};break;
			case "book-name":  {
				list = filter(borrowRecordDao.findByBookName(basis), borrowDateLowerBoundStr, borrowDateUpperBoundStr);
			};break;
			case "reader-bar-code":  {
				list = filter(borrowRecordDao.findByReaderBarCode(basis), borrowDateLowerBoundStr, borrowDateUpperBoundStr);
			};break;
			case "reader-name": {
				list = filter(borrowRecordDao.findByReaderName(basis), borrowDateLowerBoundStr, borrowDateUpperBoundStr);
			};break;
			default: {
				//这里写了也没有意义
				list = filter(borrowRecordDao.findAll(), borrowDateLowerBoundStr, borrowDateUpperBoundStr);
			}
			}
		} else {
			//没有填写查询依据，只通过借阅时间范围查询
			list = filter(borrowRecordDao.findAll(), borrowDateLowerBoundStr, borrowDateUpperBoundStr);
		}
		return list;
	}

	public List<BorrowRecord> filter(List<BorrowRecord> list, String borrowDateLowerBoundStr, String borrowDateUpperBoundStr) {
		Iterator<BorrowRecord> it = list.iterator();
		if (borrowDateLowerBoundStr != "" && borrowDateUpperBoundStr != "") {
			Timestamp borrowDateLowerBound = Timestamp.valueOf(borrowDateLowerBoundStr);
			Timestamp borrowDateUpperBound = Timestamp.valueOf(borrowDateUpperBoundStr);
			while (it.hasNext()) {
				BorrowRecord temp = it.next();
				if (temp.getBorrowDate().getTime() < borrowDateLowerBound.getTime() || temp.getBorrowDate().getTime() > borrowDateUpperBound.getTime()) {
					it.remove();
				}
			}
		} else if (borrowDateLowerBoundStr != "" && borrowDateUpperBoundStr == "") {
			Timestamp borrowDateLowerBound = Timestamp.valueOf(borrowDateLowerBoundStr);
			while (it.hasNext()) {
				BorrowRecord temp = it.next();
				if (temp.getBorrowDate().getTime() < borrowDateLowerBound.getTime()) {
					it.remove();
				}
			}
		} else if (borrowDateLowerBoundStr == "" && borrowDateUpperBoundStr != "") {
			Timestamp borrowDateUpperBound = Timestamp.valueOf(borrowDateUpperBoundStr);
			while (it.hasNext()) {
				BorrowRecord temp = it.next();
				if (temp.getBorrowDate().getTime() > borrowDateUpperBound.getTime()) {
					it.remove();
				}
			}
		}
		return list;
	}
}
