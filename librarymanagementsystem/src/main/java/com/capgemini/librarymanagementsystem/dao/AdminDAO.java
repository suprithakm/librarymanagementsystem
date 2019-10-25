package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.Users;

public interface AdminDAO {

	public boolean addUser(Users user);
	public boolean updateUser(Users user);
	public boolean deleteUser(String userId);
	
	public List<Users> showAllUser();
	
	public Users searchUser(String userId);
}//end of AdminDAO
