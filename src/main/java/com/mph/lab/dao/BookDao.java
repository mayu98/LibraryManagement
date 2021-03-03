package com.mph.lab.dao;

import java.util.List;

import com.mph.lab.entity.Books;

public interface BookDao {
	
	public void addBook(Books books);
	public List<Books> getAllBooks();
	public List<Books> updateBook(Books books);
	public List<Books> deleteBook(String bookId);
	public List<Books> getAbook(String bookId);

}
