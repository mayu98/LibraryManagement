package com.mph.lab.dao;




import java.util.List;

import com.mph.lab.entity.Books;
import com.mph.lab.entity.IssueReturn;

public  interface  IssueReturnDao {
	
	
	public List<IssueReturn> issueBook(IssueReturn issueReturn);
	public List<IssueReturn>  returnBook(IssueReturn issueReturn);
	boolean checkAlreadyIssued(IssueReturn issueReturn);	
	
	public List<Books> myIssuedBooks(int memberId);
	
	
	
}
