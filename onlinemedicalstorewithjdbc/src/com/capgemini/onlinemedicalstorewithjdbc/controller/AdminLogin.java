package com.capgemini.onlinemedicalstorewithjdbc.controller;

import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.bean.AdminBean;
import com.capgemini.onlinemedicalstorewithjdbc.dao.MedicalDAO;
import com.capgemini.onlinemedicalstorewithjdbc.exception.ExceptionMethods;
import com.capgemini.onlinemedicalstorewithjdbc.exception.MedicalStoreExceptions;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;

public class AdminLogin {
	static ExceptionMethods exception = new ExceptionMethods();
	static boolean valid = false;
	static String emailvalid;
	static String passwordValid;

	public void loginAdmin() {
		Scanner scanner = new Scanner(System.in);
		MedicalDAO dao = MedicalFactory.getDAOImplInstance();
		valid = true;
		while (valid) {
			System.out.println("Enter your email: ");
			String r = scanner.nextLine();
			try {
				emailvalid = ExceptionMethods.emailValidator(r);
				valid = false;
			} catch (MedicalStoreExceptions m) {
				m.getMessage();
			}
		}

		valid = true;
		while (valid) {
			System.out.println("Enter the admin password: ");
			String p = scanner.next();
			try {
				passwordValid = ExceptionMethods.passwordValidator(p);
				valid = false;
			} catch (MedicalStoreExceptions m) {
				m.getMessage();
			}
		}

		AdminBean admin = dao.adminLogin(emailvalid, passwordValid);
		if (admin != null) {
			System.out.println(admin);

		} else {
			System.out.println("Something went wrong...");
			loginAdmin();
		}
	}// End of loginAdmin()
}// End of class
