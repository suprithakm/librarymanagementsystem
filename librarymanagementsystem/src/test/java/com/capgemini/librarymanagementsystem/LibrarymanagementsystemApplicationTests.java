package com.capgemini.librarymanagementsystem;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;

@SpringBootTest
class LibrarymanagementsystemApplicationTests {
	
	@Autowired
	private AdminDAO dao;
	
	@Autowired
	private LibrarianDAO lib;
	
	@Test
	void testDel() {
		boolean check = dao.deleteUser("102");
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
		boolean check=dao.addUser(user);
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
		boolean check=dao.updateUser(user);
		assertTrue(check);
	}
	
	@Test
	void testShowAllUser() {
		List<Users> userList=dao.showAllUser();
		assertNotNull(userList);
	}
	
	@Test
	void testSearchUser() {
		Users user=dao.searchUser("103");
		assertNotNull(user);
	}
	
	
	@Test
	public void testDelBook() {
	boolean check=lib.deleteBooks("102");
	assertTrue(check);
	}
}
