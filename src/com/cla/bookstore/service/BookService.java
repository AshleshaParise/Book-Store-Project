package com.cla.bookstore.service;

import java.util.List;

import com.cla.bookstore.entity.BookStore;

public interface BookService {

	public List<BookStore> getBooks();

	public void saveBook(BookStore bookstore);
}
