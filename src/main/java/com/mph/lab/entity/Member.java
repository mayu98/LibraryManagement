package com.mph.lab.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LabMember")
public class Member {
	@Id
	@Column
	private int memberId;
@Column
	private String password;
@Column
	private String name;
@Column
	private String email;
@Column
	private String phoneNumber;

	public Member() {
	}

	public Member(int memberId, String password, String name, String email, String phoneNumber) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setMemberPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPassword=" + password + ", name=" + name + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
