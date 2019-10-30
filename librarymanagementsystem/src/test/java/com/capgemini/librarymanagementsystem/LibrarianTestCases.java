package com.capgemini.librarymanagementsystem;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

@SpringBootTest
public class LibrarianTestCases {


	@Autowired
	private LibrarianDAO lib;

	@Test
	public void testDelBook() {
		boolean check=false;;
		try {
			check = lib.deleteBooks("102");
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}

	@Test
	void testAddBook() {
		BooksInventory book=new BooksInventory();
		book.setAuthor1("Ram vilas");
		book.setAuthor2("Kumar j");
		book.setBookId("125");
		book.setBookName("How to read a book");
		book.setImage("data:image/jpeg;base64");
		book.setPublisher("MNO");
		Date dt;
		try {
			dt=new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-12");
			book.setYearOfPublication(dt);
		}catch(ParseException e) {
			e.printStackTrace();
		}	
		boolean check=false;
		try {
			check = lib.addBooks(book);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}


	@Test
	void testUpdateBook() {
		BooksInventory book=new BooksInventory();
		book.setAuthor1("Ram vilas");
		book.setAuthor2("Kumar j");
		book.setBookId("125");
		book.setBookName("Life changes everytime");
		book.setImage("data:image/jpeg;base64");
		book.setPublisher("MNO");
		Date dt;
		try {
			dt=new SimpleDateFormat("yyyy-MM-dd").parse("2010-12-12");
			book.setYearOfPublication(dt);
		}catch(ParseException e) {
			e.printStackTrace();
		}	
		boolean check=false;;
		try {
			check = lib.updateBooks(book);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}

	@Test
	void testShowAllIssuedBooks() {
		List<BooksTransaction> bookList=null;
		try {
			bookList = lib.showAllIssuedBooks("101");
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertNotNull(bookList);
	}

	@Test
	void testShowAllIssueBooks() {
		List<BooksTransaction> bookList=null;
		try {
			bookList = lib.showAllIssuedBooks();
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertNotNull(bookList);
	}

	@Test
	void testAcceptRequest() {
		BooksTransaction book=lib.acceptRequest("161");
		assertNotNull(book);
	}

	@Test
	void testShowAllRequests() {
		List<BooksRegistration> book=null;
		try {
			book = lib.showAllRequests();
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertNotNull(book);
	}

	@Test
	void testReturnBook() {
		Date dt;
		BooksTransaction book=null;
		try {
			dt=new SimpleDateFormat("yyyy-MM-dd").parse("2019-12-12");
			book=lib.returnBook("161", dt);
		}catch(ParseException e) {
			e.printStackTrace();
		}catch(LibraryManagementException e) {
			e.printStackTrace();
		}
		assertNotNull(book);
	}

}
