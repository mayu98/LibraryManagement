package com.mph.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.lab.dao.BookDao;
import com.mph.lab.entity.Books;
import com.mph.lab.entity.Member;

@Service
@Transactional(transactionManager = "transactionManager")
public class BookServiceImpl  implements BookService{
	
 @Autowired
	BookDao bookDao;
 
	@Override
	public void addBook(Books books) {
		bookDao.addBook(books);
		
	}
	@Override
	public List<Books> getAllBooks() {
		
		return bookDao.getAllBooks();
	}

	@Override
	public List<Books> updateBook(Books books) {
	
		return bookDao.updateBook(books);
	}

	@Override
	public List<Books> deleteBook(String bookId) {
	
		return bookDao.deleteBook(bookId);
	}

	@Override
	public List<Books> getAbook(String bookId) {
	
		return bookDao.getAbook(bookId);
	}
	@Override
	public List allIssuedBooks() {
	
		return bookDao.allIssuedBooks();
	}
	@Override
	public Member adminLogin(String password) {
		return bookDao.adminLogin(password);
		
	}
	@Override
	public List<Books> getAvailableBooks() {
		
		return bookDao.getAvailableBooks();
	}

}
