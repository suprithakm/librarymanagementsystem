package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

@Repository
public class LibrarianDAOImpl implements LibrarianDAO{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addBooks(BooksInventory books) throws LibraryManagementException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		boolean isAdded=false;
		try {
			entityManager.persist(books);
			transaction.commit();
			isAdded=true;
		} catch(Exception e) {
			throw new LibraryManagementException("Failed to add book");
		}
		entityManager.close();
		return isAdded;
	}//end of addBooks

	@Override
	public boolean updateBooks(BooksInventory books) throws LibraryManagementException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		boolean isUpdate=false;
		
		BooksInventory bookPresent=entityManager.find(BooksInventory.class,books.getBookId());
		try {
			bookPresent.setBookName(books.getBookName());
			bookPresent.setAuthor1(books.getAuthor1());
			bookPresent.setAuthor2(books.getAuthor2());
			bookPresent.setBookId(books.getBookId());
			bookPresent.setPublisher(books.getPublisher());
			bookPresent.setYearOfPublication(books.getYearOfPublication());
			bookPresent.setImage(books.getImage());
			transaction.commit();
			return isUpdate;

		}catch (Exception e) {
			throw new LibraryManagementException("Failed to update book ");
		}
		
	}//end of updateBooks

	@Override
	public boolean deleteBooks(String bookId) throws LibraryManagementException{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();
		boolean isDelete=false;
		BooksInventory book=entityManager.find(BooksInventory.class, bookId);
		try {
			entityManager.remove(book);
			transaction.commit();
			entityManager.close();
			return isDelete;			
		} catch (Exception e) {
			throw new LibraryManagementException("Failed to delete book");
		}
	}//end of deleteBooks

	@Override
	public List<BooksTransaction> showAllIssuedBooks(String userId) throws LibraryManagementException{

		EntityManager entityManager=entityManagerFactory.createEntityManager();

		String viewRegistrationDetails="from BooksRegistration where userId =: userId";
		Query query=entityManager.createQuery(viewRegistrationDetails);
		query.setParameter("userId", userId);
		try {
		List<BooksRegistration> bookDetails=query.getResultList();

		String viewTransaction="from BooksTransaction where registrationId =: registrationId";
		query=entityManager.createQuery(viewTransaction);
		List<BooksTransaction> bookTransactions;

		List<BooksTransaction> resultSet=new ArrayList<BooksTransaction>();

		if(bookDetails.size()>0) {
			for(BooksRegistration registration:bookDetails) {
				query.setParameter("registrationId", registration.getRegistrationId());
				bookTransactions=query.getResultList();
				resultSet.addAll(bookTransactions);
			}
		}
		return resultSet;
		}catch(Exception e) {
			throw new LibraryManagementException("Failed to get all issued books");
		}
		
	}//end of showIssuedBooks

	@Override
	public List<BooksTransaction> showAllIssuedBooks() throws LibraryManagementException {

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		String viewTransaction="from BooksTransaction";

		List<BooksTransaction> resultSet=new ArrayList<BooksTransaction>();
		Query query=null;
		try {

			query=entityManager.createQuery(viewTransaction);
			resultSet=query.getResultList();
		}
		catch(Exception e) {
			throw new LibraryManagementException("Failed to get all issued books");
		}
		return resultSet;
	}//end of showIssuedBooks

	@Override
	public List<BooksRegistration> showAllRequests() throws LibraryManagementException{
		EntityManager entityManager=entityManagerFactory.createEntityManager();

		String viewRegistrationDetails="from BooksRegistration";
		Query query=entityManager.createQuery(viewRegistrationDetails);

		List<BooksRegistration> bookDetails=new ArrayList<BooksRegistration>();
		try {
		bookDetails=query.getResultList();
		return bookDetails;
		}catch(Exception e) {
			throw new LibraryManagementException("Failed to get all requests");
		}
	}//end of showAllRequests

	@Override
	public BooksTransaction acceptRequest(String registrationId) {

		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();

		String viewRegistrationDetails="from BooksRegistration where registrationId=:registrationId";
		Query query=entityManager.createQuery(viewRegistrationDetails);
		query.setParameter("registrationId",registrationId);
		BooksTransaction trans=null;

		BooksRegistration bookDetails=(BooksRegistration)query.getSingleResult();

		Random random=new Random();
		int transactionId=random.nextInt();
		if(transactionId<0) {
			transactionId=transactionId*(-1);
		}

		String viewTransactionDetails="from BooksTransaction where registrationId =: registrationId";
		Query query1=entityManager.createQuery(viewTransactionDetails);
		query1.setParameter("registrationId", registrationId);

		try {
			BooksTransaction book=(BooksTransaction) query1.getSingleResult();
			if(book!=null) {
				return null;
			}
		}catch(Exception e) {

			trans=new BooksTransaction();
			trans.setRegistrationId(bookDetails.getRegistrationId());
			trans.setTransactionId(Integer.toString(transactionId));
			trans.setIssueDate(bookDetails.getRegistrationDate());
			trans.setFine(0.0);

			Calendar cal=Calendar.getInstance();
			cal.setTime(bookDetails.getRegistrationDate());
			cal.add(Calendar.DATE, 14);
			trans.setReturnDate(cal.getTime());

			entityManager.persist(trans);
			transaction.commit();
			return trans;
		}

		return trans;
	}//end of acceptRequest


	@Override
	public BooksTransaction returnBook(String registrationId,Date returnDate) throws LibraryManagementException{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		transaction.begin();

		String viewTransactionDetails="from BooksTransaction where registrationId=:registrationId";
		Query query=entityManager.createQuery(viewTransactionDetails);
		query.setParameter("registrationId",registrationId);
		BooksTransaction book=null;

		book=(BooksTransaction)query.getSingleResult();
		Date rtn=book.getReturnDate();

		BooksTransaction bookPresent=entityManager.find(BooksTransaction.class,book.getTransactionId());

		int days=(int)((returnDate.getTime()-rtn.getTime())/(1000*60*60*24));
		if(days>0) {
			bookPresent.setFine((days)*1.0);
		}else {
			bookPresent.setFine(book.getFine());
		}
		bookPresent.setIssueDate(book.getIssueDate());
		bookPresent.setRegistrationId(book.getRegistrationId());
		bookPresent.setReturnDate(returnDate);
		bookPresent.setTransactionId(book.getTransactionId());
		transaction.commit();
		transaction.begin();

		String select="from BooksRegistration where registrationId=:registrationId";
		Query query1=entityManager.createQuery(select);

		query1.setParameter("registrationId", bookPresent.getRegistrationId());
		BooksRegistration bookDelete=null;

		try {
			bookDelete=(BooksRegistration)query1.getSingleResult();
			entityManager.remove(bookDelete);
			transaction.commit();

		}catch(Exception e) {
			throw new LibraryManagementException("Failed to perform return book operation");
		}

		entityManager.close();

		return book;
	}//end of returnBook



}
