package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.Users;

public interface AdminDAO {

	public boolean addStudent(Users user);
	public boolean updateStudent(Users user);
	public boolean deleteStudent(String userId);
	
	public List<Users> showAllStudent();
	public List<Users> showLibrarian();
	
	public Users searchStudentById(String userId);
}//end of AdminDAO
