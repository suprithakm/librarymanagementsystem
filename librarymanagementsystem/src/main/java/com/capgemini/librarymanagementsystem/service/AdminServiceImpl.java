package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;
import com.capgemini.librarymanagementsystem.validation.RegexInfo;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDAO dao;
	
	RegexInfo regex=new RegexInfo();

	@Override
	public boolean addUser(Users user) throws LibraryManagementException {
		if(regex.regexId(user.getUserId()) && regex.regexEmail(user.getEmailId()) && regex.regexName(user.getUserName())) {
			return dao.addUser(user);
		}else {
			return false;
		}
	}//end of addUser

	@Override
	public boolean updateUser(Users user) throws LibraryManagementException {
		if(regex.regexId(user.getUserId()) && regex.regexEmail(user.getEmailId()) && regex.regexName(user.getUserName())) {
			return dao.updateUser(user);
		}else {
			return false;
		}
	}//end of updateUser

	@Override
	public boolean deleteUser(String userId) throws LibraryManagementException {
		if(regex.regexId(userId)) {
			return dao.deleteUser(userId);
		}else {
			return false;
		}
	}//end of deleteUser

	@Override
	public List<Users> showAllUser() throws LibraryManagementException{
		return dao.showAllUser();
	}//end of showAllUser


}//end of AdminServiceImpl
