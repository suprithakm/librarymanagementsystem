package com.capgemini.librarymanagementsystem.utility;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.beans.Users;

public class Response {

	private int statusCode;
	private String message;
	
	private Users users;
	private List<Users> usersList;
	
	private BooksRegistration booksRegistration;
	private List<BooksRegistration> bRegistrations;
	
	private BooksInventory booksInventory;
	private List<BooksInventory> bInventories;
	
	private BooksTransaction booksTransaction;
	private List<BooksTransaction> booksTransactions;
	
	//getters and setters
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public List<Users> getUsersList() {
		return usersList;
	}
	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}
	public BooksRegistration getBooksRegistration() {
		return booksRegistration;
	}
	public void setBooksRegistration(BooksRegistration booksRegistration) {
		this.booksRegistration = booksRegistration;
	}
	public List<BooksRegistration> getbRegistrations() {
		return bRegistrations;
	}
	public void setbRegistrations(List<BooksRegistration> bRegistrations) {
		this.bRegistrations = bRegistrations;
	}
	public BooksInventory getBooksInventory() {
		return booksInventory;
	}
	public void setBooksInventory(BooksInventory booksInventory) {
		this.booksInventory = booksInventory;
	}
	public List<BooksInventory> getbInventories() {
		return bInventories;
	}
	public void setbInventories(List<BooksInventory> bInventories) {
		this.bInventories = bInventories;
	}
	public BooksTransaction getBooksTransaction() {
		return booksTransaction;
	}
	public void setBooksTransaction(BooksTransaction booksTransaction) {
		this.booksTransaction = booksTransaction;
	}
	public List<BooksTransaction> getBooksTransactions() {
		return booksTransactions;
	}
	public void setBooksTransactions(List<BooksTransaction> booksTransactions) {
		this.booksTransactions = booksTransactions;
	}
	
	
	}
