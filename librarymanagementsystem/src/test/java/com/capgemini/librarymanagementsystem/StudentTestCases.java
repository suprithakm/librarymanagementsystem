package com.capgemini.librarymanagementsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.dao.StudentDAO;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

@SpringBootTest
public class StudentTestCases {

	@Autowired
	private StudentDAO student;
	
	@Test
	void testRequestBook() {
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
		BooksRegistration books=student.requestBook(book, "102");
		assertNotNull(books);
	}
	
	@Test
	void testCancelRequest() {
		boolean check=false;
		try {
			check = student.cancelRequest("302", "103");
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}
}
