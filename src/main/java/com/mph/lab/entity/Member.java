package com.mph.lab.entity;



import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LabMember")
public class Member {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int memberId;
	
@Column(nullable = false)
	private String password;

@Column(nullable = false)
	private String name;

@Column(nullable = false)
	private String email;

@Column(nullable = false)
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
