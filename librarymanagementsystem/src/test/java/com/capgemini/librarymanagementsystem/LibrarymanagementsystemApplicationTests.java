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
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

@SpringBootTest
class LibrarymanagementsystemApplicationTests {
	
	@Autowired
	private AdminDAO admin;
	
	


	@Test
	void testDel() {
		boolean check=false;
		try {
			check = admin.deleteUser("102");
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}

	@Test
	void testAdd() {
		Users user=new Users();
		user.setEmailId("richi@gmail.com");
		user.setPassword("std12345");
		user.setType("student");
		user.setUserId("103");
		user.setUserName("Richi");
		boolean check=false;
		try {
			check = admin.addUser(user);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}
	
	@Test
	void testUpdate() {
		Users user=new Users();
		user.setEmailId("sinchana@gmail.com");
		user.setPassword("std12345");
		user.setType("student");
		user.setUserId("103");
		user.setUserName("Sinchana");
		boolean check=false;
		try {
			check = admin.updateUser(user);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}
	
	@Test
	void testShowAllUser() {
		List<Users> userList=null;
		try {
			userList = admin.showAllUser();
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		assertNotNull(userList);
	}
	
	
	





}
