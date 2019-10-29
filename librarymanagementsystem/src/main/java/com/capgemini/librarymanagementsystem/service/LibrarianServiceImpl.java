package com.capgemini.librarymanagementsystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;
import com.capgemini.librarymanagementsystem.validation.RegexInfo;

@Service
public class LibrarianServiceImpl implements LibrarianService{

	@Autowired
	private LibrarianDAO dao;
	
	
	RegexInfo regex=new RegexInfo();
	
	@Override
	public boolean addBooks(BooksInventory books) {
		return dao.addBooks(books);
	}

	@Override
	public boolean updateBooks(BooksInventory books) {
		return dao.updateBooks(books);
	}

	@Override
	public boolean deleteBooks(String bookId) {
		if(regex.regexId(bookId)) {
			return dao.deleteBooks(bookId);
		}else {
			return false;
		}
	}

	@Override
	public List<BooksTransaction> showAllIssuedBooks(String userId) {
		if(regex.regexId(userId)) {
			return dao.showAllIssuedBooks(userId);
		}else {
			return null;
		}
	}

	@Override
	public List<BooksRegistration> showAllRequests() {
		return dao.showAllRequests();
	}

	@Override
	public BooksTransaction acceptRequest(String registrationId) {
		if(regex.regexId(registrationId)) {
			return dao.acceptRequest(registrationId);
		}else {
			return null;
		}
	}

	@Override
	public BooksTransaction returnBook(String registrationId,Date returnDate) {
		return dao.returnBook(registrationId, returnDate);
	}

	@Override
	public List<BooksTransaction> showAllIssuedBooks() {
		return dao.showAllIssuedBooks();
	}

	

}
