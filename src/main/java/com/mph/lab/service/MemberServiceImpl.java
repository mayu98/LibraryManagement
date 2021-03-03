package com.mph.lab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mph.lab.dao.MemberDao;
import com.mph.lab.entity.Member;

@Service
@Transactional
public class MemberServiceImpl  implements MemberServiceInterface{
	@Autowired
	MemberDao memberDao;

	@Override
	public void register(Member member) {
		memberDao.register(member);
		
		
	}

	@Override
	public String login(Member member) {
		
		return memberDao.login(member);
	}

	@Override
	public List<Member> getAllMembers() {
		
		return memberDao.getAllMembers();
	}

	@Override
	public List<Member> updateMember(Member member) {

		return memberDao.updateMember(member);
	}

	@Override
	public List<Member> cancleMemberShip(int memId) {
	
		return memberDao.cancleMemberShip(memId);
	}

	@Override
	public List<Member> getMember(int memberId) {
		
		return memberDao.getMember(memberId);
	}

}
