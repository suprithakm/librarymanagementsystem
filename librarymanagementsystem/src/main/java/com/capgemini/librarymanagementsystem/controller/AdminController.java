package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.CommonService;
import com.capgemini.librarymanagementsystem.utility.Response;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*",allowCredentials="true")
public class AdminController {

	@Autowired
	private CommonService common;
	
	@Autowired
	private AdminService admin;
	
	@GetMapping("login/{userId}/{password}")
	public Users login(@PathVariable(name="userId") String userId,@PathVariable(name="password") String password) {
		Users users=null;
		try {
			users = common.login(userId, password);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return users;
	}//end of login
	
	@PostMapping("addUser")
	public boolean addUser(@RequestBody Users user) {
		try {
			if(admin.addUser(user)) {
				return true;
			}
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return false;
	}//end of addUser
	
	
	
	@PutMapping("updateUser")
	public boolean updateUser(@RequestBody Users user) {
		try {
			if(admin.updateUser(user)) {
				return true;
			}
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}		
		return false;
	}//end of updateUser
	
	
	@DeleteMapping("deleteUser/{userId}")
	public boolean deleteUser(@PathVariable(name="userId") String userId) {
		try {
			if(admin.deleteUser(userId)) {
				return true;
			}
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return false;
	}//end of delete User
	
	@GetMapping("searchBooks")
	public List<BooksInventory> searchBook(String bookName) {
		List<BooksInventory> bookList=null;
		try {
			bookList = common.searchBooks(bookName);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return bookList;
	}//end of searchBooks


	@GetMapping("showAllBooks")
	public List<BooksInventory> showAllBooks() {
		List<BooksInventory> bookList=null; 
		try {
			bookList=common.showAllBooks();
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return bookList;
	}//end of showAllBooks
	
	@GetMapping("showAllUser")
	public List<Users> showAllStd() {
		List<Users> usersList=null;
		try {
			usersList=admin.showAllUser();
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return usersList;
	}//end of showAllUser
	

	
}//end of AdminController
