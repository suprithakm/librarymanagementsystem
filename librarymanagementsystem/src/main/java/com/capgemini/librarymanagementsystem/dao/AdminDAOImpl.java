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

@Repository
public class AdminDAOImpl implements AdminDAO{

	@PersistenceUnit
	EntityManagerFactory entityManagerFactory;


	@Override
	public boolean addUser(Users users) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		boolean isadded=false;
		try {
			transaction.begin();
			entityManager.persist(users);
			transaction.commit();
			isadded=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return isadded;
	}//end of add User


	@Override
	public boolean updateUser(Users users) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		boolean isadded=false;
		try {
			transaction.begin();
			entityManager.merge(users);
			transaction.commit();
			isadded=true;
		}catch(Exception e) {
			transaction.rollback();
			return isadded;
		}
		entityManager.close();
		return isadded;
	}//end of update User

	@Override
	public boolean deleteUser(String userId) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();
		try {
			Users user=null;
			user=entityManager.find(Users.class, userId);

			transaction.begin();
			entityManager.remove(user);
			transaction.commit();

		}catch(Exception e) {
			transaction.rollback();
			return false;
		}
		entityManager.close();
		return true;
	}//end of deleteUser



	@Override
	public List<Users> showAllUser() {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction transaction=entityManager.getTransaction();

		String jpql="from Users where type='student'";
		Query query=entityManager.createQuery(jpql);
		List<Users> arraylist=new ArrayList<Users>();
		List<Users> allUser=null;
		try {
			allUser=query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return allUser;

	}//end of showAllUser




	@Override
	public Users searchUser(String userId) {
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		Users user=null;
		user=entityManager.find(Users.class, userId);
		if(user!=null && user.getType()!="student") {
		}else {
			return user;
		}
		entityManager.close();
		return user;
	}//end of search User



}//end of AdminDAOImpl
