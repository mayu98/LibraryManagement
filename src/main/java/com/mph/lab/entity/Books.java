package com.mph.lab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LmsBook")
public class Books {
	@Id
	private String bookId;	
	@Column
	private String bookName;
	@Column
	private String  author;
		@Column
	private int  bookCount ;
	  public Books() {
		  
		  
	  }
	public Books(String bookId, String bookName, String author, int bookCount) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.bookCount = bookCount;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getBookCount() {
		return bookCount;
	}
	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", bookCount=" + bookCount
				+ "]";
	}
	  

}
