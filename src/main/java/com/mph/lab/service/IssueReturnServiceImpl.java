package com.mph.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.lab.dao.IssueReturnDao;
import com.mph.lab.entity.Books;
import com.mph.lab.entity.IssueReturn;

@Service
@Transactional(transactionManager = "transactionManager")
public class IssueReturnServiceImpl  implements IssueReturnService{
	
	@Autowired
	IssueReturnDao issueReturnDao;

	@Override
	public List<IssueReturn> issueBook(IssueReturn issueReturn) {
		
		return issueReturnDao.issueBook(issueReturn);
	}

	@Override
	public List<IssueReturn>returnBook(IssueReturn issueReturn) {
	
		return issueReturnDao.returnBook(issueReturn);
	}

	@Override
	public boolean checkAlreadyIssued(IssueReturn issueReturn) {
		
		return issueReturnDao.checkAlreadyIssued(issueReturn);
	}


	@Override
	public List<Books> myIssuedBooks(int memberId) {
		
		return issueReturnDao.myIssuedBooks(memberId);
	}

}
