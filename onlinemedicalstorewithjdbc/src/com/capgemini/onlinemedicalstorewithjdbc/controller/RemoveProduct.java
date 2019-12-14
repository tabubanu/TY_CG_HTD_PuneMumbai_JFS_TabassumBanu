package com.capgemini.onlinemedicalstorewithjdbc.controller;

import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.dao.ProductDAO;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;

public class RemoveProduct {
	public void productRemove() {
		ProductDAO productDAO = MedicalFactory.getProductImplInstance();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Product Id which you want to delete");
		if(productDAO.removeProduct(scanner.nextInt())) {
			System.out.println("Product deleted Sucessfully");
		} else {
			System.out.println("Something went wrong");
			productRemove();
		}
	}
}
