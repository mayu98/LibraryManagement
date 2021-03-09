package com.mph.lab.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mph.lab.entity.IssueReturn;
import com.mph.lab.entity.Member;
import com.mph.lab.service.MemberServiceInterface;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class MemberRestController {
	@Autowired
 MemberServiceInterface memberService;
	
	Member member;
   
@PostMapping("/register")
	public  Member registerMember(@RequestBody Member member)
	{	
		memberService.register(member);
		return member;
	}

@GetMapping("/login/{memberId}/{password}")
public  ResponseEntity<Member> login(@PathVariable("memberId") int memberId
		,@PathVariable("password") String password)
{
	Member member=memberService.login(memberId,password);
	System.out.println(member);
	if (member == null)
	{
		return new ResponseEntity<Member> (HttpStatus.NO_CONTENT);	
	}	
	return new ResponseEntity<Member> (member,HttpStatus.OK);
}

@GetMapping("/getAllMembers")
public ResponseEntity<List<Member>> getAllMembers()
{
	List<Member> memList=memberService.getAllMembers();
	return new ResponseEntity<List<Member>>(memList,HttpStatus.OK);
}
@PutMapping("/updateMember")
public ResponseEntity<List<Member>> updateMember(@RequestBody Member member)
{
	//member.setMemberId(memId);	
	List<Member> memList= memberService.updateMember(member);
	return new ResponseEntity<List<Member>>(memList,HttpStatus.OK);
}
@DeleteMapping("/deleteMember/{memId}")
public  List<Member> deleteEmp(@PathVariable("memId") int memId)
{
	return memberService.cancleMemberShip(memId);
}

@GetMapping("/getMember/{memId}")
public  ResponseEntity<List<Member>> getAmember(@PathVariable("memId") int memberId)
{
	List<Member> memList=memberService.getMember(memberId);
	System.out.println(memList);
	return new ResponseEntity<List<Member>>(memList,HttpStatus.OK);
	
}












}
