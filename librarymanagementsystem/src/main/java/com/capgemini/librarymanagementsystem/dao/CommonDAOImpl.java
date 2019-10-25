package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;

@Repository
public class CommonDAOImpl implements CommonDAO{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public Users login(String userId, String password) {

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String selectQry="from Users where userId =: userId and password =: password";

		Query query=entityManager.createQuery(selectQry);
		query.setParameter("userId", userId);
		query.setParameter("password", password);
		Users users=null;
		try {
			users = (Users) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return users;
	}//end of login

	@Override
	public List<BooksInventory> searchBooks(String bookName) {
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String selectQry="from BooksInventory where bookName=:bookName";

		Query query=entityManager.createQuery(selectQry);
		query.setParameter("bookName",bookName);
		
		List<BooksInventory> bookList=null;
		try {
			bookList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return bookList;
	}//end of searchBooks

	@Override
	public List<BooksInventory> showAllBooks() {
		
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String selectQry="from BooksInventory";

		Query query=entityManager.createQuery(selectQry);
		List<BooksInventory> bookList=null;
		try {
			bookList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return bookList;
	}//end of showAllBooks

}//end of CommonDAO
