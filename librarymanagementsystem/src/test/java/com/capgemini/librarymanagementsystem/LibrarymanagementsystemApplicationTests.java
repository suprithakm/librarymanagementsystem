package com.capgemini.librarymanagementsystem;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dao.CommonDAO;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;
import com.capgemini.librarymanagementsystem.dao.StudentDAO;

@SpringBootTest
class LibrarymanagementsystemApplicationTests {
	
	@Autowired
	private AdminDAO admin;
	
	@Autowired
	private LibrarianDAO lib;
	
	@Autowired
	private StudentDAO student;
	
	@Autowired
	private CommonDAO common;
	
//	@Test
//	void testDel() {
//		boolean check = admin.deleteUser("102");
//		assertTrue(check);
//	}
//
//	@Test
//	void testAdd() {
//		Users user=new Users();
//		user.setEmailId("richi@gmail.com");
//		user.setPassword("std12345");
//		user.setType("student");
//		user.setUserId("103");
//		user.setUserName("Richi");
//		boolean check=admin.addUser(user);
//		assertTrue(check);
//	}
//	
//	@Test
//	void testUpdate() {
//		Users user=new Users();
//		user.setEmailId("sinchana@gmail.com");
//		user.setPassword("std12345");
//		user.setType("student");
//		user.setUserId("103");
//		user.setUserName("Sinchana");
//		boolean check=admin.updateUser(user);
//		assertTrue(check);
//	}
//	
//	@Test
//	void testShowAllUser() {
//		List<Users> userList=admin.showAllUser();
//		assertNotNull(userList);
//	}
//	
//	@Test
//	void testSearchUser() {
//		Users user=admin.searchUser("103");
//		assertNotNull(user);
//	}
//	
//	@Test
//	public void testDelBook() {
//	boolean check=lib.deleteBooks("102");
//	assertTrue(check);
//	}
	
//	@Test
//	void testAddBook() {
//		BooksInventory book=new BooksInventory();
//		book.setAuthor1("Ram vilas");
//		book.setAuthor2("Kumar j");
//		book.setBookId("125");
//		book.setBookName("How to read a book");
//		book.setImage("data:image/jpeg;base64");
//		book.setPublisher("MNO");
//		Date dt;
//		try {
//			dt=new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-12");
//			book.setYearOfPublication(dt);
//		}catch(ParseException e) {
//			e.printStackTrace();
//		}	
//		boolean check=lib.addBooks(book);
//		assertTrue(check);
//	}
	
	
//	@Test
//	void testUpdateBook() {
//	BooksInventory book=new BooksInventory();
//		book.setAuthor1("Ram vilas");
//		book.setAuthor2("Kumar j");
//		book.setBookId("125");
//		book.setBookName("Life changes everytime");
//		book.setImage("data:image/jpeg;base64");
//		book.setPublisher("MNO");
//		Date dt;
//		try {
//			dt=new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-12");
//			book.setYearOfPublication(dt);
//		}catch(ParseException e) {
//			e.printStackTrace();
//		}	
//		boolean check=lib.updateBooks(book);
//		assertTrue(check);
//	}
	
//	@Test
//	void testShowAllIssuedBooks() {
//		List<BooksTransaction> bookList=lib.showAllIssuedBooks("101");
//		assertNotNull(bookList);
//	}
//	
//	@Test
//	void testShowAllIssueBooks() {
//		List<BooksTransaction> bookList=lib.showAllIssuedBooks();
//		assertNotNull(bookList);
//	}
	
//	@Test
//	void testAcceptRequest() {
//		BooksTransaction book=lib.acceptRequest("161");
//		assertNotNull(book);
//	}
	
//	@Test
//	void testShowAllRequests() {
//		List<BooksRegistration> book=lib.showAllRequests();
//		assertNotNull(book);
//	}
//	
//	@Test
//	void testReturnBook() {
//		Date dt;
//		BooksTransaction book=null;
//		try {
//			dt=new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-12");
//			 book=lib.returnBook("161", dt);
//		}catch(ParseException e) {
//			e.printStackTrace();
//		}	
//		assertNotNull(book);
//	}
	
//	@Test
//	void testRequestBook() {
//		BooksInventory book=new BooksInventory();
//		book.setAuthor1("Ram vilas");
//		book.setAuthor2("Kumar j");
//		book.setBookId("125");
//		book.setBookName("How to read a book");
//		book.setImage("data:image/jpeg;base64");
//		book.setPublisher("MNO");
//		Date dt;
//		try {
//			dt=new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-12");
//			book.setYearOfPublication(dt);
//		}catch(ParseException e) {
//			e.printStackTrace();
//		}	
//		BooksRegistration books=student.requestBook(book, "102");
//		assertNotNull(books);
//	}
	
//	@Test
//	void testCancelRequest() {
//		boolean check=student.cancelRequest("302", "103");
//		assertTrue(check);
//	}
//	
//	@Test
//	void testLogin() {
//		Users user=common.login("101", "admin12345");
//		assertNotNull(user);
//	}
//	
//	@Test
//	void testShowAllBooks() {
//		List<BooksInventory> books=common.showAllBooks();
//		assertNotNull(books);
//	}

//	@Test
//	void testSearchBooks() {
//		List<BooksInventory> books=common.searchBooks("How to read a book");
//		assertNotNull(books);
//	}
}
