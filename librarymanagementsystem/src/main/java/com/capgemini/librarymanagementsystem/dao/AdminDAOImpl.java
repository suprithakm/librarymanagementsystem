package com.capgemini.librarymanagementsystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exception.LibraryManagementException;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;


	@Override
	public boolean addUser(Users users) throws LibraryManagementException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		boolean isadded=false;
		try {
			transaction.begin();
			entityManager.persist(users);
			transaction.commit();
			isadded=true;
		} catch (Exception e) {
			throw new LibraryManagementException("Failed to add");
		}
		entityManager.close();
		return isadded;
	}//end of add User


	@Override
	public boolean updateUser(Users users) throws LibraryManagementException{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		boolean isUpdate=false;
		try {
			transaction.begin();
			entityManager.merge(users);
			transaction.commit();
			isUpdate=true;
		}catch(Exception e) {
			throw new LibraryManagementException("Failed to update");
		}
		entityManager.close();
		return isUpdate;
	}//end of update User

	@Override
	public boolean deleteUser(String userId) throws LibraryManagementException {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		boolean isDelete=false;
		try {
			Users user=null;
			user=entityManager.find(Users.class, userId);
			transaction.begin();
			entityManager.remove(user);
			transaction.commit();
			isDelete=true;
		}catch(Exception e) {
			throw new LibraryManagementException("Failed to delete");
		}
		entityManager.close();
		return isDelete;
	}//end of deleteUser



	@Override
	public List<Users> showAllUser() throws LibraryManagementException{
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();

		String jpql="from Users where type != 'admin'";
		Query query=entityManager.createQuery(jpql);
		List<Users> allUser=null;
		try {
			allUser=query.getResultList();
		} catch (Exception e) {
			throw new LibraryManagementException("Failed to add");
		}
		entityManager.close();
		return allUser;

	}//end of showAllUser




}//end of AdminDAOImpl
