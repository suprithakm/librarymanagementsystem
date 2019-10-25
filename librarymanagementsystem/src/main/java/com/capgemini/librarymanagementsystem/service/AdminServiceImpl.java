package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.validation.RegexInfo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminDAO dao;
	
	@Autowired
	RegexInfo regex;

	@Override
	public boolean addStudent(Users user) {
		if(regex.regexId(user.getUserId()) && regex.regexEmail(user.getEmailId()) && regex.regexName(user.getUserName())) {
			return dao.addStudent(user);
		}else {
			return false;
		}
	}//end of addStudent

	@Override
	public boolean updateStudent(Users user) {
		if(regex.regexId(user.getUserId()) && regex.regexEmail(user.getEmailId()) && regex.regexName(user.getUserName())) {
			return dao.updateStudent(user);
		}else {
			return false;
		}
	}//end of updateStudent

	@Override
	public boolean deleteStudent(String userId) {
		if(regex.regexId(userId)) {
			return dao.deleteStudent(userId);
		}else {
			return false;
		}
	}//end of deleteStudent

	@Override
	public List<Users> showAllStudent() {
		return dao.showAllStudent();
	}

	@Override
	public List<Users> showLibrarian() {
		return dao.showLibrarian();
	}

	@Override
	public Users searchStudentById(String userId) {
		if(regex.regexId(userId)) {
			return dao.searchStudentById(userId);
		}else {
			return null;
		}
	}
	

}//end of AdminServiceImpl
