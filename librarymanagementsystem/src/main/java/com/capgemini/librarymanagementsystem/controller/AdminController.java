package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
public class AdminController {

	@Autowired
	CommonService common;
	
	@Autowired
	AdminService admin;
	
	@PostMapping("login")
	public Users login(String userId,String password) {
		Response response=new Response();
		Users users=common.login(userId, password);
		return users;
	}//end of login
	
	@PostMapping("addStudent")
	public Response addStudent(@RequestBody Users user) {
		Response response=new Response();
		if(admin.addStudent(user)) {
			response.setStatusCode(201);
			response.setMessage("success");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
		}return response;
		
	}//end of addStudent
	
	
	
	@PutMapping("updateStudent")
	public Response updateStudent(@RequestBody Users user) {
		Response response=new Response();
		if(admin.updateStudent(user)) {
			response.setStatusCode(201);
			response.setMessage("success");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
		}return response;
		
	}//end of updateStudent
	
	
	@DeleteMapping("deleteStudent")
	public Response deleteStudent(String userId) {
		Response response=new Response();
		if(admin.deleteStudent(userId)) {
			response.setStatusCode(201);
			response.setMessage("success");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
		}return response;
		
	}//end of delete Student
	
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
	
	@GetMapping("showAllStudent")
	@ResponseBody
	public List<Users> showAllStd() {
		List<Users> usersList=admin.showAllStudent();
		return usersList;
	}//end of showAllstudent
	
	
	@GetMapping("showLibrarian")
	@ResponseBody
	public List<Users> showLib() {
		List<Users> usersList=admin.showLibrarian();
		return usersList;
	}//end of showLibrarian
	
	
	@GetMapping("searchStudentById")
	@ResponseBody
	public Users searchStudent(String userId) {
		Users users=admin.searchStudentById(userId);
		return users;
	}//end of searchStudentById
	
	
}//end of AdminController
