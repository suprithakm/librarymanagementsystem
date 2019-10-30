package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

public interface AdminDAO {

	public boolean addUser(Users user) throws LibraryManagementException;
	public boolean updateUser(Users user) throws LibraryManagementException;
	public boolean deleteUser(String userId) throws LibraryManagementException;
	public List<Users> showAllUser() throws LibraryManagementException;
}//end of AdminDAO
