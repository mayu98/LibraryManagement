package com.mph.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mph.lab.entity.Books;
import com.mph.lab.entity.IssueReturn;
import com.mph.lab.service.IssueReturnService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IssueReturnRestController {

	@Autowired
	IssueReturnService issueReturnService;

	@PostMapping("/issueBook")
	public ResponseEntity<List<IssueReturn>> issueBook(@RequestBody IssueReturn issueReturn) {
		System.out.println("Controller" + issueReturn);
	List<IssueReturn> 	result=issueReturnService.issueBook(issueReturn);
		return new ResponseEntity<List<IssueReturn>>(result,HttpStatus.OK);
	}

	@PostMapping("/returnbook")
	public ResponseEntity<List<IssueReturn>> returnBook(@RequestBody IssueReturn issueReturn) {
		System.out.println("Controller" + issueReturn);		
		List<IssueReturn> result=issueReturnService.returnBook(issueReturn);
		return new ResponseEntity<List<IssueReturn>>(result,HttpStatus.OK);
	}
	
	@PostMapping("/checkAlreadyIssued")
	public boolean checkAlreadyIssued(@RequestBody IssueReturn issueReturn)
	{		
		return issueReturnService.checkAlreadyIssued(issueReturn);		
	}
	
	@GetMapping("/myIssuedBooks/{memberId}")
	public ResponseEntity<List<Books>> myIssuedBooks(@PathVariable("memberId") int memberId)
	{
		List li=issueReturnService.myIssuedBooks(memberId);
		System.out.println(li);			
		return new ResponseEntity<List<Books>>(li,HttpStatus.OK);
	}
	
	

}
