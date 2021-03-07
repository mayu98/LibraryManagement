package com.mph.lab.service;

import java.util.List;

import com.mph.lab.entity.Books;
import com.mph.lab.entity.Member;

public interface BookService {
	

	public void addBook(Books books);
	public List<Books> getAllBooks();
	public List<Books> updateBook(Books books);
	public List<Books> deleteBook(String bookId);
	public List<Books> getAbook(String bookId);
	public List<?> allIssuedBooks();

	 public Member adminLogin(String password);
	 
		public List<Books> getAvailableBooks();

}
