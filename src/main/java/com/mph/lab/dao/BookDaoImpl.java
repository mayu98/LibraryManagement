package com.mph.lab.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.lab.entity.Books;
@Repository
public class BookDaoImpl  implements BookDao {
	
	@Autowired
	SessionFactory sessionFactory;

	
	public BookDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public void addBook(Books books) {
		System.out.println("BOOOOOOOOOOOOOOK" + books);
		getSession().save(books);
		System.out.println("books Saved in Database..");
		
	}

	@Override
	public List<Books> getAllBooks() {
	Query query=getSession().createQuery("select be from Books be ");
	List<Books> bookList=query.list();
		
		return bookList;
	}

	@Override
	public List<Books> updateBook(Books books) {
		Query query = getSession().createQuery("update Books set bookName=:bookName,author=:author,"
				+ "bookCount=:bookCount where bookId=:bookId");
		query.setParameter("bookName", books.getBookName());
		query.setParameter("author", books.getAuthor());
		query.setParameter("bookCount", books.getBookCount());
		query.setParameter("bookId", books.getBookId());
		query.executeUpdate();
		
		
		return  getAllBooks();
	}

	@Override
	public List<Books> deleteBook(String bookId) {
		Query query = getSession().createQuery("delete from Books where bookId=:bookId");
		query.setParameter("bookId", bookId);
		query.executeUpdate();
	
		return getAllBooks();
	}

	@Override
	public List<Books> getAbook(String bookId) {
		Criteria c = getSession().createCriteria(Books.class);
		c.add(Restrictions.eq("bookId",bookId));
		List<Books> bookList=c.list();			
			return  bookList;
	}
	
	
	

}
