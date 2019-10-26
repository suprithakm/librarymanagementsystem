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
import com.capgemini.librarymanagementsystem.service.AdminService;
import com.capgemini.librarymanagementsystem.service.CommonService;
import com.capgemini.librarymanagementsystem.utility.Response;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*",allowCredentials="true")
public class AdminController {

	@Autowired
	CommonService common;
	
	@Autowired
	AdminService admin;
	
	@GetMapping("login/{userId}/{password}")
	public Users login(@PathVariable(name="userId") String userId,@PathVariable(name="password") String password) {
		Users users=common.login(userId, password);
		return users;
	}//end of login
	
	@PostMapping("addUser")
	public boolean addUser(@RequestBody Users user) {
		if(admin.addUser(user)) {
			return true;
		}else {
			return false;
		}
	}//end of addUser
	
	
	
	@PutMapping("updateUser")
	public boolean updateUser(@RequestBody Users user) {
		if(admin.updateUser(user)) {
			return true;
		}else {
			return false;
		}		
	}//end of updateUser
	
	
	@DeleteMapping("deleteUser/{userId}")
	public boolean deleteUser(@PathVariable(name="userId") String userId) {
		if(admin.deleteUser(userId)) {
			return true;
		}else {
			return false;
		}
		
	}//end of delete User
	
	@GetMapping("searchBooks")
	@ResponseBody
	public List<BooksInventory> searchBook(String bookName) {
		List<BooksInventory> bookList=common.searchBooks(bookName);
		return bookList;
	}//end of searchBooks


	@GetMapping("showAllBooks")
	@ResponseBody
	public List<BooksInventory> showAllBooks() {
		List<BooksInventory> bookList=common.showAllBooks();
		return bookList;
	}//end of showAllBooks
	
	@GetMapping("showAllUser")
	@ResponseBody
	public List<Users> showAllStd() {
		List<Users> usersList=admin.showAllUser();
		return usersList;
	}//end of showAllUser
	
	
	@GetMapping("searchUser")
	@ResponseBody
	public Users searchUser(String userId) {
		Users users=admin.searchUser(userId);
		return users;
	}//end of searchUserById
	
	
}//end of AdminController
