package com.mph.lab.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.mph.lab.entity.Books;

public class BookTest {
	private static Books book;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		book = new Books("b00", "Sample", "Test", 10);
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
	public void testGetBookById() {

		assertEquals("b00", book.getBookId());
	}
	@Test
	public void testGetBookByName() {
		assertEquals("Sample", book.getBookName());
	}
	@Test
	public void testGetBookByAuthor() {
		assertEquals("Test", book.getAuthor());
	}
	@Test
	public void testGetBookByBookCount() {
		assertEquals(10, book.getBookCount());
	}
}
