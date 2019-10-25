package com.capgemini.librarymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.dao.StudentDAO;
import com.capgemini.librarymanagementsystem.validation.RegexInfo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDAO dao;
	
	
	RegexInfo regex=new RegexInfo();
	
	@Override
	public BooksRegistration requestBook(BooksInventory books, String userId) {
		return dao.requestBook(books,userId);
	}

	@Override
	public boolean cancelRequest(String registrationId, String userId) {
	
			return dao.cancelRequest(registrationId, userId);
		
	}

}
