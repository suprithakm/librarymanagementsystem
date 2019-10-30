package com.capgemini.librarymanagementsystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;
import com.capgemini.librarymanagementsystem.validation.RegexInfo;

@Service
public class LibrarianServiceImpl implements LibrarianService{

	@Autowired
	private LibrarianDAO dao;
	
	
	RegexInfo regex=new RegexInfo();
	
	@Override
	public boolean addBooks(BooksInventory books) throws LibraryManagementException{
		return dao.addBooks(books);
	}

	@Override
	public boolean updateBooks(BooksInventory books) throws LibraryManagementException {
		return dao.updateBooks(books);
	}

	@Override
	public boolean deleteBooks(String bookId) throws LibraryManagementException {
		if(regex.regexId(bookId)) {
			return dao.deleteBooks(bookId);
		}else {
			return false;
		}
	}

	@Override
	public List<BooksTransaction> showAllIssuedBooks(String userId) throws LibraryManagementException{
		if(regex.regexId(userId)) {
			return dao.showAllIssuedBooks(userId);
		}else {
			return null;
		}
	}

	@Override
	public List<BooksRegistration> showAllRequests() throws LibraryManagementException {
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
	public BooksTransaction returnBook(String registrationId,Date returnDate) throws LibraryManagementException {
		return dao.returnBook(registrationId, returnDate);
	}

	@Override
	public List<BooksTransaction> showAllIssuedBooks() throws LibraryManagementException{
		return dao.showAllIssuedBooks();
	}

	

}
