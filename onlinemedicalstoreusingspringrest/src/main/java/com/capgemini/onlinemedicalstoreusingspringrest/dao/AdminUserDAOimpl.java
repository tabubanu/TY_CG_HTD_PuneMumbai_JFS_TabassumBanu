package com.capgemini.onlinemedicalstoreusingspringrest.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.onlinemedicalstoreusingspringrest.beans.AdminUserBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.ProductBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.UserBean;


@Repository
public class AdminUserDAOimpl implements AdminUserDAO {

	Scanner scanner = new Scanner(System.in);
	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	EntityManager entityManager = null;
	EntityTransaction transaction = null;

	@Override
	public AdminUserBean adminUserLogin(String email, String password, String type) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from AdminUserBean where email = :email and password = :password  and type=: type";
		Query query = manager.createQuery(jpql);

		query.setParameter("email", email);
		query.setParameter("password", password);
		query.setParameter("type", type);

		AdminUserBean adminUserBean = null;
		try {
			adminUserBean = (AdminUserBean) query.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return adminUserBean;
	}// End of adminLogin()

	@Override
	public List<ProductBean> getAllMedicines() {
		
		EntityManager manager = null;
		
		List<ProductBean> productList = null;
		try {
			 manager = entityManagerFactory.createEntityManager();
			
			
			String jpql = "from ProductBean";
			Query query = manager.createQuery(jpql);
			productList = query.getResultList();
			manager.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<AdminUserBean> getAllUsers() {
		EntityManager entityManager = null;
		List<AdminUserBean> userList = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();

			String jpql = "FROM AdminUserBean";
			Query query = entityManager.createQuery(jpql);
			userList = query.getResultList();
			entityManager.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable To Fetch All Users");
		}
		return userList;
		// End of showAllUsers()
	}

	@Override
	public boolean deleteUser(int id) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean isRemove = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "delete AdminUserBean where id =: id ";
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			query.executeUpdate();
			transaction.commit();
			System.out.println("User Delete Successfully");
			entityManager.close();
			isRemove = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable To Delete User!!!");
		}
		return isRemove;
	}

	@Override
	public boolean adminLogout() {
		return false;
	}

	@Override
	public boolean userRegister(AdminUserBean adminUserBean) {
		boolean isRegister = false;

		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(adminUserBean);
			System.out.println("Register Successfully!!!");
			System.out.println("***Now Login To Use Our Online Facilities***");
			transaction.commit();
			entityManager.close();
			isRegister = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Something Went Wrong!!");
			return false;
		}
		return isRegister;
	}

	@Override
	public boolean userLogout(int id) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean isLogout = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("test");
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "delete from CartBean where id=:id";
			transaction = entityManager.getTransaction();
			transaction.begin();
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			query.executeUpdate();
			transaction.commit();
			System.out.println("user Logout Successfully");
			entityManager.close();
			isLogout = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable To Logout!!");
		}
		return isLogout;
	}
}