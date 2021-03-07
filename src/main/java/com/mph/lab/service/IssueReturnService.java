package com.mph.lab.service;

import java.util.List;

import com.mph.lab.entity.Books;
import com.mph.lab.entity.IssueReturn;

public interface IssueReturnService {
	

	public List<IssueReturn> issueBook(IssueReturn issueReturn);
	public List<IssueReturn>  returnBook(IssueReturn issueReturn);
	public List<Books> myIssuedBooks(int memberId);
	
	public boolean checkAlreadyIssued(IssueReturn issueReturn);
}
