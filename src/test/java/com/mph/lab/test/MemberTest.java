package com.mph.lab.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mph.lab.entity.Member;

public class MemberTest {
	private static Member member;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		member = new Member(101, "1234", "Adi", "adi@gmail.com", "323569563");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetMember() {
		assertEquals(101, member.getMemberId());
		assertEquals("1234", member.getPassword());
		assertEquals("Adi", member.getName());
		assertEquals("adi@gmail.com", member.getEmail());
		assertEquals("323569563", member.getPhoneNumber());
	}

}
