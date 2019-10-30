package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

public interface CommonService {

	public Users login(String user_id, String password) throws LibraryManagementException;
	public List<BooksInventory> searchBooks(String book_name) throws LibraryManagementException;
	public List<BooksInventory> showAllBooks() throws LibraryManagementException;
}
