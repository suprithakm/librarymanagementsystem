package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

public interface StudentService {

	public BooksRegistration requestBook(BooksInventory books,String userId)throws LibraryManagementException;
	public boolean cancelRequest(String registrationId,String userId) throws LibraryManagementException;
}
