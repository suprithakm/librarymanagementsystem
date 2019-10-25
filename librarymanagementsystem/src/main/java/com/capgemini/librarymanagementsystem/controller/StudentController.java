package com.capgemini.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.service.StudentService;
import com.capgemini.librarymanagementsystem.utility.Response;

@RestController
public class StudentController {

	@Autowired
	StudentService service;

	@PostMapping("requestBook")
	public BooksRegistration request(@RequestBody BooksInventory book, String userId) {
		BooksRegistration reg=service.requestBook(book, userId);
		return reg;
	}//end of addBooks
	
	@PostMapping("cancelRequestBook")
	public boolean cancelRequest(String registrationId, String userId) {
		return service.cancelRequest(registrationId, userId);
	}//end of cancelRequestBook
}
