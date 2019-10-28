package com.capgemini.librarymanagementsystem.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem.dao.AdminDAO;

import junit.framework.TestCase;

public class AdminTestCases extends TestCase{

@Autowired
AdminDAO admin;
	
@Test
void deleteCase1() {
	boolean result=admin.deleteStudent("101");
	assertEquals(true, result);
}
	
}
