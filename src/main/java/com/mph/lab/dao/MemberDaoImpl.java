package com.mph.lab.dao;

import java.util.Iterator;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.mph.lab.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public void register(Member member) {
		getSession().saveOrUpdate(member);
		System.out.println("saved in databse.....");

	}

	@Override
	public String login(Member member) {
		String memberName = null;
		Criteria c = getSession().createCriteria(Member.class);
		Criterion criterion = Restrictions.eq("memberId", member.getMemberId());
		Criterion criterion2 = Restrictions.eq("password", member.getPassword());
		Criterion criterion3 = Restrictions.and(criterion, criterion2);
		c.add(criterion3);
		List mem = c.list();
		System.out.println(mem);
		for (Iterator i = mem.iterator(); i.hasNext();) {
			Member member1 = (Member) i.next();
			memberName = member1.getName();
		}
		System.out.println(memberName.toUpperCase());
		return memberName.toUpperCase();
	}

	@Override
	public List<Member> updateMember(Member member) {
		Query query = getSession()
				.createQuery("update Member set name=:name,email=:email,phoneNumber=:phoneNumber where memberId=:memberId");
		query.setParameter("name", member.getName());
		query.setParameter("email", member.getEmail());
		query.setParameter("phoneNumber", member.getPhoneNumber());
		query.setParameter("memberId",member.getMemberId());
		int i = query.executeUpdate();		
		return getAllMembers();
	}

	@Override
	public List<Member> getAllMembers() {
		
		Query query = getSession().createQuery("select me from Member me");
		List<Member> memList=query.list();
				
		return  memList;
	}

	@Override
	public List<Member> cancleMemberShip(int memId) {
		Query query = getSession().createQuery("delete from Member where memberId=:memberId");
		query.setParameter("memberId", memId);
		query.executeUpdate();
		return getAllMembers();
	}
	
	
	
	

}
