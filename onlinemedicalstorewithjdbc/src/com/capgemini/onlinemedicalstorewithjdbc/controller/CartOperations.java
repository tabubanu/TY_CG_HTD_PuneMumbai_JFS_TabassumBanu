package com.capgemini.onlinemedicalstorewithjdbc.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.onlinemedicalstorewithjdbc.bean.CartBean;
import com.capgemini.onlinemedicalstorewithjdbc.dao.CartDAO;
import com.capgemini.onlinemedicalstorewithjdbc.exception.ExceptionMethods;
import com.capgemini.onlinemedicalstorewithjdbc.exception.MedicalStoreExceptions;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;
import com.capgemini.onlinemedicalstorewithjdbc.main.MedicalMainOperation;

public class CartOperations {

	Scanner scanner = new Scanner(System.in);
	char selectedOperation;

	public void userLogin() {
	while (true) {
		System.out.println("Press a to Reset Password");
		System.out.println("Press b to Place Order");	
		System.out.println("Press c to perform operation on Products present in your cart");
		System.out.println("Press d to show total bill ");
		System.out.println("Press e For doing Payment using the card");
		System.out.println("Press f for Logout");
		selectedOperation = scanner.next().charAt(0);
		switch (selectedOperation) {
		case 'a':// For resetting the Password
			UpdateUserPassword updateUserPassword = new UpdateUserPassword();
			updateUserPassword.updatePassword();
			break;
		case 'b':// Placing an order
			addIntoCart();
			break;
		case 'c':// Cartoperations
			cartProductOperation();
			break;
		case 'd':// for totalbill
			CartDAO cartDAO = MedicalFactory.getCartImplInstance();
			cartDAO.totalBill();
			break;
		case 'e':
			payment();
			break;
		case 'f':// Logout
			System.out.println("-------Logged Out--------");
			MedicalMainOperation medicalMain = new MedicalMainOperation();
			medicalMain.main(null);
			break;
		default:
			break;
		}}
	}// End of while

	public void cartProductOperation() {
		
		System.out.println(
				"Press 1 to show all products from  cart\nPress 2 to add Product in  Cart\nPress 3 to remove Product\nPress 4 exit");
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String operation = scanner.nextLine();
			int ch = 0;
			try {
				ch = ExceptionMethods.numberValidation(operation);

			} catch (MedicalStoreExceptions m) {
				m.getMessage();
				System.out.println("Enter Your Choice : ");
			}
		
		//int operation = sc.nextInt();
		switch (ch) {
		case 1:
			showAllCartProduct();
			break;
		case 2:
			addIntoCart();
			break;
		case 3:
			cartProductRemove();
			break;
		case 4:
			userLogin();
			break;
		default:
			System.out.println("Enter Valid Option");
			break;
		}
		}
	}// End of cartProductOperation()

	public void addIntoCart() {
		CartDAO cartDAO = MedicalFactory.getCartImplInstance();
		System.out.println("Enter Product id: ");
		int productId = scanner.nextInt();
		if (cartDAO.addIntoCart(productId)) {
			System.out.println("Product Added");

			System.out.println("add one more product /npress 1 to add more /npress 2 to exit");
			String oneMore = "1";
			if (oneMore.contentEquals(scanner.next())) {
				addIntoCart();
			} else {
				cartProductOperation();
			}
		} else {
			System.out.println("Something went wrong");
			addIntoCart();
		}
	}// End of addIntoCart()

	public void showAllCartProduct() {
		CartDAO cartDAO = MedicalFactory.getCartImplInstance();
		List<CartBean> list = cartDAO.showCartProducts();
		if (list != null) {
			for (CartBean cartBean : list) {
				System.out.println("Product ID: " + cartBean.getProductId());
				System.out.println("Product Name: " + cartBean.getProductName());
				System.out.println("Product Brand: " + cartBean.getProductBrand());
				System.out.println("Product Category: " + cartBean.getCategory());
				System.out.println("Product Price: " + cartBean.getPrice());
				System.out.println("Product Details: " + cartBean.getDetails());
				System.out.println("Product Available: " + cartBean.getAvailable());
				cartProductOperation();
			} // End of for loop
		} else {
			System.out.println("Something went wrong");
			cartProductOperation();
		}

	}// End of method

	public void cartProductRemove() {
		CartDAO cartDAO = MedicalFactory.getCartImplInstance();
		System.out.println("Enter product id to delete");
		if (cartDAO.removeCartProduct(scanner.nextInt())) {
			System.out.println("Product deleted");
			cartProductOperation();
		} else {
			System.out.println("Enter Correct Product id");
			cartProductOperation();
		}
	}

	public void payment() {

		System.out.println("Enter Card Name: ");
		scanner.nextLine();
	
		System.out.println("Enter Card Number: ");

		Pattern pat = Pattern.compile("\\d{16}");
		long number = scanner.nextLong();

		String cardNumber = Long.toString(number);
		Matcher mat = pat.matcher(cardNumber);
		if (mat.matches()) {
			System.out.println("month: ");
			scanner.next();
			System.out.print("year: ");
			scanner.next();
			System.out.println("cvv number : ");
			Pattern patt = Pattern.compile("\\d{3}");
			int num = scanner.nextInt();
			String cvv = Integer.toString(num);
			Matcher matt = patt.matcher(cvv);
			if (matt.matches()) {
				System.out.println("Transaction Done Completely");

				CartDAO cartDAO = MedicalFactory.getCartImplInstance();
				cartDAO.deleteCart();

			} else {
				System.out.println("enter correct cvv");
			}
		} else {
			System.out.println("Transaction not Completed");
			System.out.println("Please Enter valid Card Detail");
			payment();
		}
	}// End of payment()
}// End of class
