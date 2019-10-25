package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;

public interface CommonService {

	public Users login(String user_id, String password);
	public List<BooksInventory> searchBooks(String book_name);
	public List<BooksInventory> showAllBooks();
}
