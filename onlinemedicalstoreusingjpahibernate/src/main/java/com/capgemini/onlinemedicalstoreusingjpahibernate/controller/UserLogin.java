package com.capgemini.onlinemedicalstoreusingjpahibernate.controller;

import java.util.Scanner;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MedicalDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.UserBean;
import com.capgemini.onlinemedicalstoreusingjpahibernate.factory.MedicalFactory;

public class UserLogin {
	public void loginUser() {
		Scanner scanner = new Scanner(System.in);
		MedicalDAO dao = MedicalFactory.getDAOImplInstance();
		System.out.println("Enter your email: ");
		String email = scanner.next();
		scanner.nextLine();
		System.out.println("Enter your password: ");
		String password = scanner.next();
		UserBean userBean = dao.userLogin(email, password);
		if (userBean != null) {
			System.out.println("Successfully Login!!!");
			System.out.println("||||||***********WELCOME " + userBean.getUserName() + "***********||||||");
			AllUserOperations alluserOperations = new AllUserOperations();
			alluserOperations.userOperations(userBean.getUserId());

		} else {
			System.err.println("You have entered wrong Credentials!!!");
			System.out.println("Press 1 to Again Login\nPress 2 to Forgot Password");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				loginUser();
				break;
				
			case 2:
				System.out.println("Enter Your Phone Number");
				long number = scanner.nextLong();
				scanner.nextLine();
				System.out.println("Enter Your New Password");
				String password1 = scanner.nextLine();
				MedicalDAO medicalDAO = MedicalFactory.getDAOImplInstance();
				boolean state = medicalDAO.updateUserPassword(number, password1);
				if(state == true) {
					System.out.println("Password Updated Successfully....Now Login!!!");
					loginUser();
				} else {
					System.err.println("Unable To Update Password");
					
				}
				break;
				
			default:
				System.err.println("Please Enter Valid Choice!!!");
				break;
			}// End of switch
		}
	}// End of loginUser()
}// End of class
