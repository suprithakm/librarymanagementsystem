package com.capgemini.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;
import com.capgemini.librarymanagementsystem.service.StudentService;

@RestController
@CrossOrigin(origins="*", allowedHeaders="*",allowCredentials="true")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("requestBook/{userId}")
	public BooksRegistration request(@PathVariable(name="userId") String userId,@RequestBody BooksInventory book) {
		BooksRegistration reg=null;
		try {
			reg=service.requestBook(book, userId);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return reg;
	}//end of addBooks
	
	@DeleteMapping("cancelRequestBook/{registrationId}/{userId}")
	public boolean cancelRequest(@PathVariable(name="registrationId") String registrationId,@PathVariable(name="userId") String userId) {
		boolean check= false;
		try {
			check=service.cancelRequest(registrationId, userId);
		} catch (LibraryManagementException e) {
			e.printStackTrace();
		}
		return check;
	}//end of cancelRequestBook
}