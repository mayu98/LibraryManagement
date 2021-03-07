package com.mph.lab.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.lab.entity.IssueReturn;
import com.mph.lab.entity.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	SessionFactory sessionFactory;
	String memberName = null;
	 int memberId;

	public MemberDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected Session getSession() {
		return (Session) sessionFactory.getCurrentSession();
	}

	@Override
	public void register(Member member) {
		getSession().saveOrUpdate(member);
		System.out.println("saved in databse.....");

	}

	@Override
	public Member login(int memberId,String password) {
		
		Criteria c = getSession().createCriteria(Member.class);
		Criterion criterion = Restrictions.eq("memberId", memberId);		
		 Criterion criterion2 = Restrictions.eq("password", password);
		 Criterion criterion3 = Restrictions.and(criterion, criterion2);		
		c.add(criterion3);		 
		return (Member) c.uniqueResult();
		
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

	@SuppressWarnings("deprecation")
	@Override
	public List<Member> getMember(int memberId) {
		Criteria c = getSession().createCriteria(Member.class);
		c.add(Restrictions.eq("memberId", memberId));
		
		return c.list();
	}

	


	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
