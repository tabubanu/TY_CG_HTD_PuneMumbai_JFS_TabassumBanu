package com.capgemini.onlinemedicalstoreusingjpahibernate.controller;

import java.util.Scanner;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.OrderDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.OrderHistory;
import com.capgemini.onlinemedicalstoreusingjpahibernate.factory.MedicalFactory;


public class MedicineHistory {
	public static void orderHistory() {
		Scanner sc = new Scanner(System.in);
		OrderHistory orderHistory = new OrderHistory();
		OrderDAO orderDAO = MedicalFactory.getInstance();
		boolean rs = orderDAO.getHistory(orderHistory);
		if (rs == true) {
			System.out.println("Medicine Added Successfully");
		} else {
			System.out.println("Something Went Wrong");
		}
	}
}
