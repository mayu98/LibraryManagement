package com.mph.lab.entity;

import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "LABISSUERETURN")
public class IssueReturn {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private Date issueDate;
	
	@Column(nullable = false)
	private Date returnDate;
	
	@Column(nullable = false)
	private String bookId;
	
	@Column(nullable = false)
	private int memberId;
	
	public IssueReturn() {}

	public IssueReturn(Date issueDate, Date returnDate, String bookId, int memberId) {
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.bookId = bookId;
		this.memberId = memberId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBook(String bookId) {
		this.bookId = bookId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "IssueReturn [id=" + id + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", bookId="
				+ bookId + ", memberId=" + memberId + "]";
	}
	

}
