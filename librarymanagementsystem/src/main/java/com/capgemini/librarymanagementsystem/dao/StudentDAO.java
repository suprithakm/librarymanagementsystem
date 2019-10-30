package com.capgemini.librarymanagementsystem.dao;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

public interface StudentDAO {

	public BooksRegistration requestBook(BooksInventory books,String userId) ;
	public boolean cancelRequest(String registrationId,String userId) throws LibraryManagementException;
}
