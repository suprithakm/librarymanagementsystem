package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.CommonDAO;
import com.capgemini.librarymanagementsystem.validation.RegexInfo;

@Service
public class CommonServiceImpl implements CommonService{

	@Autowired
	private CommonDAO dao;
	
	
	RegexInfo regex=new RegexInfo();
	
	@Override
	public Users login(String user_id, String password) {
		if(regex.regexPassword(password) && regex.regexId(user_id)) {
			return dao.login(user_id, password);
		}else {
			return null;
		}
	}

	@Override
	public List<BooksInventory> searchBooks(String book_name) {
		if(regex.regexName(book_name)) {
			return dao.searchBooks(book_name);
		}else {
			return null;
		}
	}

	@Override
	public List<BooksInventory> showAllBooks() {
		return dao.showAllBooks();
	}

}
