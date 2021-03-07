package com.mph.lab.dao;

import java.util.List;

import com.mph.lab.entity.IssueReturn;
import com.mph.lab.entity.Member;

public interface MemberDao {
	public void register(Member member);
	
	
	public List<Member> updateMember(Member member);
	public List<Member> getAllMembers();

	public List<Member> cancleMemberShip(int memId);
	public List<Member> getMember(int memberId);
	

	 public Member login(int memberId, String password);

	
}
