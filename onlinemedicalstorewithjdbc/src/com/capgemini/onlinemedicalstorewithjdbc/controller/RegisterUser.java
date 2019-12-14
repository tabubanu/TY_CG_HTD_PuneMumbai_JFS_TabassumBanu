package com.capgemini.onlinemedicalstorewithjdbc.controller;

import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.bean.UserBean;
import com.capgemini.onlinemedicalstorewithjdbc.dao.MedicalDAO;
import com.capgemini.onlinemedicalstorewithjdbc.exception.ExceptionMethods;
import com.capgemini.onlinemedicalstorewithjdbc.exception.MedicalStoreExceptions;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;
import com.capgemini.onlinemedicalstorewithjdbc.main.MedicalMainOperation;

public class RegisterUser {

	static ExceptionMethods exception = new ExceptionMethods();
	static boolean valid = false;
	static String emailValid;
	static String passwordValid;
	static int idValid;
	static String nameValid;
	static long numberValid;
	
	public void userRegister() {
		MedicalDAO dao = MedicalFactory.getDAOImplInstance();
		UserBean info = new UserBean();
		Scanner scanner = new Scanner(System.in);
		
		valid = true;
		while (valid) {
			System.out.println("Enter your id: ");
			String id = scanner.nextLine();
			try {
				idValid = ExceptionMethods.numberValidation(id);
				info.setUser_id(idValid);
				valid = false;
			} catch (MedicalStoreExceptions m) {
				m.getMessage();
			}
		}
	
		valid = true;
		while (valid) {
			System.out.println("Enter your Name: ");
			String name = scanner.nextLine();
			try {
				nameValid = ExceptionMethods.nameValidator(name);
				info.setUser_name(nameValid);
				valid = false;
			} catch (MedicalStoreExceptions m) {
				m.getMessage();
			}
		}
		
		valid = true;
		while (valid) {
			System.out.println("Enter your email: ");
			String email = scanner.nextLine();
			try {
				emailValid = ExceptionMethods.emailValidator(email);
				info.setEmail(emailValid);
				valid = false;
			} catch (MedicalStoreExceptions m) {
				m.getMessage();
			}
		}
		
		valid = true;
		while (valid) {
			System.out.println("Enter your Mobile Number: ");
			String number = scanner.nextLine();
			try {
				numberValid = ExceptionMethods.numberValidation(number);
				info.setMobile_number(numberValid);
				valid = false;
			} catch (MedicalStoreExceptions m) {
				m.getMessage();
			}
		}
		
		valid = true;
		while (valid) {
			System.out.println("Enter your Password : ");
			String password = scanner.nextLine();
			try {
				passwordValid = ExceptionMethods.passwordValidator(password);
				info.setPassword(passwordValid);
				valid = false;
			} catch (MedicalStoreExceptions m) {
				m.getMessage();
			}
		}
		
		if (dao.registerUser(info)) {
			System.out.println("Registered Successfully");
			UserLogin userLogin = new UserLogin();
			userLogin.loginUser();
			
			CartOperations allCartOperations = new CartOperations();
			allCartOperations.userLogin();
		} else {
			System.out.println("Somthing went wrong");
			MedicalMainOperation.main(null);
		}
	}// End of userRegister()
}// End of class
