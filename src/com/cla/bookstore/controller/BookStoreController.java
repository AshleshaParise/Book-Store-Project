package com.cla.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cla.bookstore.dao.BookDAO;
import com.cla.bookstore.entity.BookStore;
import com.cla.bookstore.service.BookService;

@Controller
@RequestMapping("/book")
public class BookStoreController {
	
	//inject book service
	//@Autowired
	//private BookService bookservice; 
	
	@Autowired
	private BookDAO bookdao;
	
	@GetMapping("/listbook")
	public String listBook(Model theModel) {
		
		//get book from bookservice
		List<BookStore> theBook=bookdao.getBooks();
		
		//add book to the model
		theModel.addAttribute("bookstores",theBook);
		return "list-book";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		BookStore tempbook=new BookStore();
		theModel.addAttribute("addbookstore",tempbook);
		return "addNewBook";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("addbookstore") BookStore bookstore) {
		bookdao.saveBook(bookstore);
		return "redirect:/book/listbook";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookid") int tempid,Model theModel){
		
		//get book from database
		BookStore tempbook=bookdao.getBookUpdate(tempid);
	
		//set book as a model attribute to pre-populated the form
		theModel.addAttribute("addbookstore",tempbook);
		
		//send over to form
		return "addNewBook";
	}
	
	@GetMapping("/delete")
	public String deleteBook(@RequestParam("bookid") int tempid){
		
		//delete book 
		bookdao.deleteBook(tempid);
		return "redirect:/book/listbook";
	}
	
}

