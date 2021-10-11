package com.cla.bookstore.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cla.bookstore.entity.BookStore;

@Repository
public class BookDAImpl implements BookDAO {
	
	//injecting session factory
	@Autowired
	private SessionFactory sessionFactory;
		
	
	@Override
	@Transactional
	public List<BookStore> getBooks() {
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//create query
		Query<BookStore> theQuery= currentSession.createQuery("from BookStore order by bookname",
				BookStore.class);
		
		
		//execute query and get result list
		List<BookStore> bookstores=theQuery.getResultList();
			
		
		//return the result
		return bookstores;
		
	}


	@Override
	@Transactional
	public void saveBook(BookStore bookstore) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(bookstore);

	}


	@Override
	@Transactional
	public BookStore getBookUpdate(int tempid) {
		
		//Retrieve the data from database using id 
		Session session=sessionFactory.getCurrentSession();
		
		BookStore tempBook=session.get(BookStore.class,tempid);
		
		return tempBook;
	}


	@Override
	@Transactional
	public void deleteBook(int tempid) {
		
		Session session=sessionFactory.getCurrentSession();
		Query tempQuery=session.createQuery("delete from BookStore where bid=:bookid");
		tempQuery.setParameter("bookid", tempid);
		tempQuery.executeUpdate();
	}
}
/*
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
 */
