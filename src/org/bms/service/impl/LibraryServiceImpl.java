package org.bms.service.impl;

import org.bms.dao.LibraryDao;
import org.bms.entity.Library;
import org.bms.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * @Description: LibraryServiceImpl
 * @author: Andrew 
 * @date:   2017-06-18
 */
@Service("libraryService")
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryDao libraryDao;
	
	@Transactional
	@Override
	public Boolean update(Library library) {
		return libraryDao.update(library);
	}
	@Transactional(readOnly = true)
	@Override
	public Library find() {
		return libraryDao.find();
	}

}
