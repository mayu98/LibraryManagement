package com.mph.lab.service;

import java.util.List;

import com.mph.lab.entity.Member;

public interface LabServiceInterface {
	public void register(Member member);
	public String login(Member member);
	public List<Member> getAllMembers() ;
	public List<Member> updateMember(Member member) ;
	public List<Member> cancleMemberShip(int memId);

}
