package com.capgemini.onlinemedicalstoreusingjpahibernate.controller;

import java.util.Scanner;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MedicalDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.AdminBean;
import com.capgemini.onlinemedicalstoreusingjpahibernate.factory.MedicalFactory;

public class AdminLogin {
	public void loginAdmin() {
		Scanner scanner = new Scanner(System.in);
		MedicalDAO dao = MedicalFactory.getDAOImplInstance();

		System.out.println("Enter your email: ");
		String email = scanner.nextLine();
		System.out.println("Enter your password: ");
		String password = scanner.next();
		AdminBean adminBean = dao.loginAdmin(email, password);
		if (adminBean != null) {
			System.out.println("--------------WELCOME " + adminBean.getAdminName() + "---------------");
			System.out.println("Admin Id = " + adminBean.getAdminId());
			System.out.println("Email = " + adminBean.getEmail());
			System.out.println("Mobile Number = " + adminBean.getMobileNumber());
			AllAdminOperations adminOperations = new AllAdminOperations();
			adminOperations.adminOperation();
		} else {
			System.err.println("Enter valid Id and Password ");
			loginAdmin();
		}
	}// End of loginAdmin()

}// End of Class
