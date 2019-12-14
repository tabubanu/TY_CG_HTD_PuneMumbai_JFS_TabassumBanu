package com.capgemini.onlinemedicalstoreusingjpahibernate.factory;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.CartDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.CartDAOImpl;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MedicalDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MedicalDAOImpl;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MessageDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MessageDAOImpl;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.OrderDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.OrderDAOimpl;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.ProductDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.ProductDAOImpl;

public class MedicalFactory {

private MedicalFactory() {
		
	}
	public static MedicalDAO getDAOImplInstance() {
		MedicalDAO medicalDAO=new MedicalDAOImpl();
		return medicalDAO;
	}
	
	public static ProductDAO getDAOProductImplInstance() {
		ProductDAO productDAO = new ProductDAOImpl();
		return productDAO;
	}
	
	public static CartDAO getDAOCartImplInstance() {
		CartDAO cartDAO = new CartDAOImpl();
		return cartDAO;
	}
	
	public static MessageDAO getDAOMessageImplInstance() {
		MessageDAO messageDAO = new MessageDAOImpl();
		return messageDAO;
	}
	public static OrderDAO getInstance() {
		OrderDAO orderDAO= new OrderDAOimpl();
		return orderDAO;
	}
}// End class
