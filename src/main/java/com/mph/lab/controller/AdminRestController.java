package com.mph.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mph.lab.entity.Books;
import com.mph.lab.service.BookService;

@RestController
public class AdminRestController {
	
	@Autowired
	BookService bookService;
	
	@PostMapping("/addBook")
	public Books addBook(@RequestBody Books books)
	{
		System.out.println("Booook connnnnntttttooolller " + books);
		bookService.addBook(books);
		
		return books;
	}
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<Books>> getAllBooks()
	{
		List<Books> bookList=bookService.getAllBooks();
		return new ResponseEntity<List<Books>>(bookList,HttpStatus.OK);	
	}
	@PutMapping("/updateBook/{bookId}")
	public ResponseEntity<List<Books>> updateMember(@RequestBody Books books,@PathVariable("bookId") String bookId)
	{
		books.setBookId(bookId);	
		List<Books> bookList= bookService.updateBook(books);
		return new ResponseEntity<List<Books>>(bookList,HttpStatus.OK);
	}
	@DeleteMapping("/deletebook/{bookId}")
	public  List<Books> deleteEmp(@PathVariable("bookId") String bookId)
	{
		return bookService.deleteBook(bookId);
	}
	@GetMapping("/getaBook/{bookId}")
	public  ResponseEntity<List<Books>> getaBook(@PathVariable("bookId") String bookId)	
	{
			List<Books> bookList=bookService.getAbook(bookId);
		return  new ResponseEntity<List<Books>>(bookList,HttpStatus.OK) ;
		
	}
	
	
	

}
