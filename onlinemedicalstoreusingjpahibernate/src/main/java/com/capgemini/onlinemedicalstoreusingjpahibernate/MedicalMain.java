package com.capgemini.onlinemedicalstoreusingjpahibernate;

import java.util.Scanner;

import com.capgemini.onlinemedicalstoreusingjpahibernate.controller.AdminLogin;
import com.capgemini.onlinemedicalstoreusingjpahibernate.controller.AllUserOperations;
import com.capgemini.onlinemedicalstoreusingjpahibernate.controller.RegisterUser;
import com.capgemini.onlinemedicalstoreusingjpahibernate.controller.UserLogin;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MedicalDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.ProductDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.ProductDAOImpl;
import com.capgemini.onlinemedicalstoreusingjpahibernate.exception.ExceptionMethods;
import com.capgemini.onlinemedicalstoreusingjpahibernate.exception.MedicalStoreExceptions;
import com.capgemini.onlinemedicalstoreusingjpahibernate.factory.MedicalFactory;

public class MedicalMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//int choice;
		int adminChoice;
		char selectedOperation;
		
		ExceptionMethods exception = new ExceptionMethods();
		boolean correct = false;
		ProductDAO productDAO = MedicalFactory.getDAOProductImplInstance();
		MedicalDAO medicalDAO = MedicalFactory.getDAOImplInstance();
		
		while(true) {
			System.out.println("\n---------WELCOME TO THE ONLINE MEDICAL STORE-----------");
			System.out.println("Press 1 to Login as Admin");
			System.out.println("Press 2 to Login as User");
			System.out.println("Press 3 to User Registration");
			System.out.println("Press 4 to visit as visitor");
			int choice = 0;
			correct = true;
			while (correct) {
				try {
					String choice1 = scanner.nextLine();
					choice = exception.numberValidation(choice1);
					correct = false;
				} catch (MedicalStoreExceptions e) {
					e.getMessage();
				}
			}
			
			switch (choice) {
			case 1://Login as Admin
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.loginAdmin();
				while (true) {
					
				} // End of while()
				
			case 2://Login as User
				UserLogin userLogin = new UserLogin();
				userLogin.loginUser();
				break;
			case 3://New User registration
				RegisterUser registerUser = new RegisterUser();
				registerUser.userRegister();
				break;
			case 4://Visit as Visitors
				
				ProductDAOImpl impl = new ProductDAOImpl();
				impl.showAllProducts();
				break;
			default:
				System.out.println("Please Enter Valid Choice!!!");
			}
		}//End of while(true)
		
	}//End of main method

}//End of class
