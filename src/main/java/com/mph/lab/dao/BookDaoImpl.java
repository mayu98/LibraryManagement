package com.mph.lab.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.lab.entity.Books;
import com.mph.lab.entity.Member;
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
	Query query=getSession().createQuery("select be from Books be ORDER BY  be.bookId ");
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

	@SuppressWarnings({ "rawtypes", "deprecation" })
	@Override
	public List allIssuedBooks() {
		SQLQuery sqlQuery=getSession().createSQLQuery("select DISTINCT  b.bookId,b.bookName,"
				+ "b.author,ir.memberId from LmsBook b INNER  JOIN LabIssueReturn ir ON ir.bookId=b.bookId ");
		sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		return sqlQuery.list();
	}

	@Override
	public Member  adminLogin(String password) {
		Criteria c = getSession().createCriteria(Member.class);
		// criterion = Restrictions.eq("memberId", member.getMemberId());
		Criterion criterion2 = Restrictions.eq("password", password);
		//Criterion criterion3 = Restrictions.and(criterion, criterion2);
		c.add(criterion2);
		return (Member) c.uniqueResult();
		
	}
	
	@Override
	public List<Books> getAvailableBooks(){
		Query query=getSession().createQuery("select be from Books be ORDER BY  be.bookId DESC ");
		List<Books> bookList=query.list();			
		return bookList;
	}
	
	

}
