package com.cla.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cla.bookstore.dao.BookDAO;
import com.cla.bookstore.entity.BookStore;

@Service
public class BookServiceImplementation implements BookService {
	
    //inject BookStore Dao
	@Autowired
	private BookDAO bookdao;
	
	
	@Override	
	@Transactional
	public List<BookStore> getBooks() {
		// TODO Auto-generated method stub
		return bookdao.getBooks();
	}


	@Override
	@Transactional
	public void saveBook(BookStore bookstore) {
		bookdao.saveBook(bookstore);		
		
	}
	
	
	

}
