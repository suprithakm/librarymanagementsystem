package com.capgemini.librarymanagementsystem;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.CommonDAO;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

@SpringBootTest
public class CommonTestCases {

	
	
	@Autowired
	private CommonDAO common;
	
	@Test
	void testSearchBooks() {
		List<BooksInventory> books=null;
		try {
			books = common.searchBooks("How to read a book");
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertNotNull(books);
	}
	
	
	@Test
	void testLogin() {
		Users user=null;
		try {
			user = common.login("101", "admin12345");
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertNotNull(user);
	}
	
	@Test
	void testShowAllBooks() {
		List<BooksInventory> books=null;
		try {
			books = common.showAllBooks();
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertNotNull(books);
	}
}
