package com.mph.lab.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IssueReturn")
public class IssueReturn {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private Date issueDate;
	@Column(nullable = false)
	private Date returnDate;
	@Column
	private String bookId;
	@Column
	private int memberId;

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

	public String getBook() {
		return bookId;
	}

	public void setBook(String book) {
		this.bookId = book;
	}

	public int getMember() {
		return memberId;
	}

	public void setMember(int member) {
		this.memberId = member;
	}

	@Override
	public String toString() {
		return "IssueReturn [id=" + id + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", bookId="
				+ bookId + ", memberId=" + memberId + "]";
	}
	

}
