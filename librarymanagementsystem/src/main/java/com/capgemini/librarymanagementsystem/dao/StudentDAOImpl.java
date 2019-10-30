package com.capgemini.librarymanagementsystem.dao;

import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

@Repository
public class StudentDAOImpl implements StudentDAO{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public BooksRegistration requestBook(BooksInventory books, String userId){

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();

		String viewBookDetails="from BooksInventory where bookId =: bookId";
		Query query=entityManager.createQuery(viewBookDetails);
		query.setParameter("bookId", books.getBookId());

		BooksInventory book=(BooksInventory) query.getSingleResult();

		String select="from BooksRegistration where bookId=:bookId";
		Query query1=entityManager.createQuery(select);

		query1.setParameter("bookId", book.getBookId());
		BooksRegistration reg=null;
		BooksRegistration bookPresent=null;
		try {
			bookPresent=(BooksRegistration)query1.getSingleResult();
			System.out.println("Book is not available");

		}catch(Exception e) {
			reg = new BooksRegistration();
			reg.setBookId(book.getBookId());
			Date date = new Date();
			reg.setRegistrationDate(date);
			Random random = new Random();
			int registrationId = random.nextInt(500);
			reg.setRegistrationId(Integer.toString(registrationId));
			reg.setUserId(userId);
			entityManager.persist(reg);
			transaction.commit();
		}
		return reg;
	}//end of requestBook

	@Override
	public boolean cancelRequest(String registrationId, String userId) throws LibraryManagementException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		String select="from BooksRegistration where registrationId=:registrationId and userId=:userId";
		Query query=entityManager.createQuery(select);

		query.setParameter("registrationId", registrationId);
		query.setParameter("userId", userId);
		BooksRegistration book=null;
		try {
			book=(BooksRegistration)query.getSingleResult();
			entityManager.remove(book);
			transaction.commit();

		}catch(Exception e) {
			throw new LibraryManagementException("Failed to cancel request");
		}
		entityManager.close();
		return true;
	}//end of cancelRequest



}//end of StudentDAOImpl
