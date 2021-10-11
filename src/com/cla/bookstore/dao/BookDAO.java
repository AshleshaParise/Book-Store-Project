package com.cla.bookstore.dao;

import java.util.List;

import com.cla.bookstore.entity.BookStore;

public interface BookDAO {
	public List<BookStore> getBooks();

	public void saveBook(BookStore bookstore);

	public BookStore getBookUpdate(int tempid);

	public void deleteBook(int tempid);

}
