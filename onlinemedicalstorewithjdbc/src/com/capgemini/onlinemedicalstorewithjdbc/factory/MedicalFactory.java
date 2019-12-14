package com.capgemini.onlinemedicalstorewithjdbc.factory;

import com.capgemini.onlinemedicalstorewithjdbc.dao.CartDAO;
import com.capgemini.onlinemedicalstorewithjdbc.dao.CartDAOJDBCImpl;
import com.capgemini.onlinemedicalstorewithjdbc.dao.MedicalDAO;
import com.capgemini.onlinemedicalstorewithjdbc.dao.MedicalDAOJDBCImpl;
import com.capgemini.onlinemedicalstorewithjdbc.dao.ProductDAO;
import com.capgemini.onlinemedicalstorewithjdbc.dao.ProductDAOJDBCImpl;

public class MedicalFactory {
private MedicalFactory() {
		
	}
	public static MedicalDAO getDAOImplInstance() {
		MedicalDAO medicalDAO=new MedicalDAOJDBCImpl();
		return medicalDAO;
	}
	
	public static ProductDAO getProductImplInstance() {
		ProductDAO productDAO=new ProductDAOJDBCImpl();
		return productDAO;
	}
	
	public static CartDAO getCartImplInstance() {
		CartDAO cartDAO=new CartDAOJDBCImpl();
		return cartDAO;
	}
}
