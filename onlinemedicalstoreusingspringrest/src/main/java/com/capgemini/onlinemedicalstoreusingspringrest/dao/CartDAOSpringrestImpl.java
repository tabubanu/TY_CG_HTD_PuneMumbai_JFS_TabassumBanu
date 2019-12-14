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
import com.capgemini.onlinemedicalstoreusingspringrest.beans.CartBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.ProductBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.UserBean;


@Repository
public class CartDAOSpringrestImpl implements CartDAO {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addIntoCart(int id, int productId) {
		String getUserName = null;
		String getProductName = null;
		double getPrice = 0;
		boolean isAdded = false;

		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner scanner = new Scanner(System.in);

		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();

			// Get User Name
		//	String jpql = "from UserBean where userId =:userId";
			String jpql = "from AdminUserBean where id =:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			//UserBean userBean = (UserBean) query.getSingleResult();
			AdminUserBean userBean = (AdminUserBean) query.getSingleResult();
			getUserName = userBean.getName();

			// Get Product Name
			String jpql1 = "from ProductBean where productId =:productId";
			Query query1 = entityManager.createQuery(jpql1);
			query1.setParameter("productId", productId);
			ProductBean productBean = (ProductBean) query1.getSingleResult();
			getProductName = productBean.getProductName();
			getPrice = productBean.getPrice();

			// Inser Into Cart
			CartBean cartBean = new CartBean();
			cartBean.setUserId(id);
			cartBean.setUserName(getUserName);
			cartBean.setProductId(productId);
			cartBean.setProductName(getProductName);
			cartBean.setPrice(getPrice);

			transaction.begin();
			entityManager.persist(cartBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}// End of addIntoCart()

	@Override
	public boolean removeFromCart(int id, int cartId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean isDeleted = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();

			String jpql = "FROM CartBean where id =:id AND cartId =:cartId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			query.setParameter("cartId", cartId);
			CartBean cartBean = (CartBean) query.getSingleResult();
			transaction.begin();
			entityManager.remove(cartBean);
			transaction.commit();
			entityManager.close();

			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}// End of removeFromCart()

	@Override
	public List<CartBean> showAllProducts(int id) {
		EntityManager entityManager = null;
		List<CartBean> data = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();

			String jpql = "FROM CartBean WHERE id =: id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			data = query.getResultList();
			entityManager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}// End of showAllProducts()

	@Override
	public double totalBill(int id) {
		EntityManager entityManager = null;
		double totalBill = 0.0;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			String jpql = "SELECT sum(price) FROM CartBean WHERE id= :id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			totalBill = (double) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalBill;
	}// End of totalBill()

	@Override
	public boolean deleteCart(int userId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean isDeleted = false;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();

			String jpql = "DELETE FROM CartBean WHERE userId =:userId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("userId", userId);
			transaction.begin();
			query.executeUpdate();
			transaction.commit();
			entityManager.close();

			isDeleted = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}// End of deleteCart()

}// End of Class
