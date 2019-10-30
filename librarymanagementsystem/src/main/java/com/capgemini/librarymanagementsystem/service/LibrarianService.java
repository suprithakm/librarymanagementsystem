package com.capgemini.librarymanagementsystem.service;

import java.util.Date;
import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

public interface LibrarianService {

	public boolean addBooks(BooksInventory books) throws LibraryManagementException;
	public boolean updateBooks(BooksInventory books) throws LibraryManagementException;
	public boolean deleteBooks(String book_id) throws LibraryManagementException;
	
	public List<BooksTransaction> showAllIssuedBooks(String user_id) throws LibraryManagementException;
	public List<BooksTransaction> showAllIssuedBooks() throws LibraryManagementException;
	public List<BooksRegistration> showAllRequests() throws LibraryManagementException;
	
	public BooksTransaction acceptRequest(String registrationId) throws LibraryManagementException;

	public BooksTransaction returnBook(String registrationId, Date returnDate) throws LibraryManagementException;
}
