package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;

public interface StudentService {

	public BooksRegistration requestBook(BooksInventory books,String userId);
	public boolean cancelRequest(String registrationId,String userId);
}
