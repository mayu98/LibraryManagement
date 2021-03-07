package com.mph.lab.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import com.mph.lab.entity.IssueReturn;
import com.mph.lab.entity.Member;

@Repository
public class IssueReturnDaoImpl implements IssueReturnDao {

	@Autowired
	SessionFactory sessionFactory;

	public IssueReturnDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Session getSession() {

		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public List<IssueReturn> issueBook(IssueReturn issueReturn) {	
			try {
				System.out.println("hello from issue book");
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
				Calendar c = Calendar.getInstance();
				Date issueDate = new Date();
				c.setTime(issueDate); // Now use today date.
				c.add(Calendar.DATE, 7); // Adding 7 days
				Date returnDate = sdf1.parse(sdf1.format(c.getTime()));
				issueReturn.setIssueDate(issueDate);
				issueReturn.setReturnDate(returnDate);
				getSession().save(issueReturn);	
				System.out.println("hello from issue  book after save");
				 updateBookCountWhenIssue(issueReturn.getBookId());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return	getAll();
		
	}

	public void updateBookCountWhenIssue(String bookId) {
		Query query = getSession().createQuery("update Books set bookCount=bookCount-1 where bookId=:bookId");
		query.setParameter("bookId", bookId);
		query.executeUpdate();
		
	}

	@Override
	public List<IssueReturn> returnBook(IssueReturn issueReturn) {
		Query query = getSession().createQuery("delete from IssueReturn where bookId=:bookId and memberId=:memberId");
		query.setParameter("bookId", issueReturn.getBookId());
		query.setParameter("memberId", issueReturn.getMemberId());
		query.executeUpdate();
		 updateBookCountWhenReturn(issueReturn.getBookId());
		 return getAll();
		 
	}

	public String updateBookCountWhenReturn(String bookId) {
		Query query = getSession().createQuery("update Books set bookCount=bookCount+1 where bookId=:bookId");
		query.setParameter("bookId", bookId);
		query.executeUpdate();
		return "Book "+ bookId+"Returned Successfully";
	}
      @Override
	public boolean checkAlreadyIssued(IssueReturn issueReturn) {
		Criteria c = getSession().createCriteria(IssueReturn.class);
		Criterion criterion = Restrictions.eq("memberId", issueReturn.getMemberId());
		Criterion criterion2 = Restrictions.eq("bookId", issueReturn.getBookId());
		Criterion criterion3 = Restrictions.and(criterion, criterion2);
		c.add(criterion3);
		if (c.list().isEmpty()) 
		{
			return true;
		}
		return false;

	}
       public List<IssueReturn> getAll(){
    		Query query = getSession().createQuery("select me from IssueReturn me");
    		List<IssueReturn> issueReturnList=query.list();    	   
		return issueReturnList;
    	   
       }

	@Override
	public List<Books> myIssuedBooks(int memberId) {		
		SQLQuery sqlQuery=getSession().createSQLQuery("select distinct b.bookId,b.bookName,b.author "
				+ " from  lmsbook b INNER JOIN LabIssueReturn ir ON  ir.bookId=b.bookid  and  ir.memberId=:memberId");
		sqlQuery.setParameter("memberId", memberId);
		sqlQuery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		return sqlQuery.list();
	}
      
      

}
