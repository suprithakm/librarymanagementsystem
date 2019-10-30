package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

public interface CommonDAO {

	public Users login(String userId, String password) throws LibraryManagementException;
	public List<BooksInventory> searchBooks(String bookName) throws LibraryManagementException;
	public List<BooksInventory> showAllBooks() throws LibraryManagementException;
}
