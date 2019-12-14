package com.capgemini.onlinemedicalstoreusingjpahibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.OrderHistory;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.ProductBean;


public class OrderDAOimpl implements OrderDAO {

	@Override
	public boolean getHistory(OrderHistory orderHistory) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		boolean isAdded = false;
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("medicinePersistenceUnit");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			// UserBean userBean=new UserBean();
			ProductBean productBean = new ProductBean();
			OrderHistory orderHistory2 = new OrderHistory();
			String jpql = "select into OrderHistory from MedicineBean";
			Query query = entityManager.createQuery(jpql);
			// String jpql1="from MedicineBean where medicine_id=:medicine_id AND name=:name
			// AND price=:price AND category=:category";
			// Query query1 = entityManager.createQuery(jpql1);
			int medicineid = productBean.getProductId();
			orderHistory2.setMedicineid(medicineid);
			String name = productBean.getProductName();
			orderHistory2.setName(name);
			double price = productBean.getPrice();
			orderHistory2.setPrice(price);
			String Category = productBean.getCategory();
			orderHistory2.setCategory(Category);
			String availibililty = productBean.getAvailable();
			orderHistory2.setAvailibility(availibililty);
//			CartBean cartBean = new CartBean();
//			MedicineBean medicineBean = new MedicineBean();
//			transaction.begin();
//			String jpql = "from CartBean";
//			query.setParameter("medicine_id", medicine_id);
//			medicineBean = (MedicineBean) query.getSingleResult();
//			cartBean.setMedicineid(medicine_id);
//			cartBean.setCategory(Category);
//			String Name = medicineBean.getName();
//			cartBean.setName(Name);
//			String Availability = medicineBean.getAvailability();
//			cartBean.setAvailability(Availability);
//			cartBean.setPrice(price);
			entityManager.persist(orderHistory);
			transaction.commit();
			System.out.println("Medicine Added Successfully");
			entityManager.close();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable To Add Medicine!!");
		}
		return isAdded;
	}

	

}
