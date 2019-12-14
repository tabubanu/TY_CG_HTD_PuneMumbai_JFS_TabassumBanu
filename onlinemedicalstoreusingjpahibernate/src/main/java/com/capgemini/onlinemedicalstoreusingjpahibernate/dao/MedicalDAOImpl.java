package com.capgemini.onlinemedicalstoreusingjpahibernate.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.AdminBean;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.UserBean;

public class MedicalDAOImpl implements MedicalDAO {

	@Override
	public boolean registerUser(UserBean userBean) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean isRegister = false;

		try {

			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(userBean);
			transaction.commit();
			entityManager.close();
			
			isRegister = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isRegister;
	}// End of registerUser()

	@Override
	public UserBean userLogin(String email, String password) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		UserBean userBean = null;
		int userId = 0;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "FROM UserBean WHERE email =:email AND password =:password";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			userBean = (UserBean) query.getSingleResult();
			userId = userBean.getUserId();

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return userBean;
	}// End of userLogin()

	@Override
	public List<UserBean> showAllUsers() {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		List<UserBean> data = null;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();

			String jpql = "FROM UserBean";
			Query query = entityManager.createQuery(jpql);
			data = query.getResultList();

			entityManager.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable To Fetch All Users");
		}
		return data;

	}// showAllUsers()

	@Override
	public boolean updateUserPassword(long mobile, String password) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean isUpdated = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();

			String jpql = "Update UserBean Set password =:password where mobileNumber =:mobile";
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("password", password);
			query.setParameter("mobile", mobile);
			int result = query.executeUpdate();
			transaction.commit();
			entityManager.close();
			isUpdated = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}// End of updateUserPassword()

	@Override
	public UserBean getUser(int userId) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;

		UserBean userBean = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();

			String jpql = "from UserBean where userId= :userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			userBean = (UserBean) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userBean;
	}// End of getUser()

	@Override
	public AdminBean loginAdmin(String email, String password) {
		Scanner scanner = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		AdminBean adminBean = null;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "FROM AdminBean WHERE email =:email AND password =:password";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			adminBean = (AdminBean) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adminBean;
	}// End of adminLogin()
	

	@Override
	public boolean deleteUser(int userId) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean isDeleted = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();

			String jpql = "DELETE UserBean WHERE userId =:userId";
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			int result = query.executeUpdate();
			transaction.commit();
			entityManager.close();

			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}
}// End of class
