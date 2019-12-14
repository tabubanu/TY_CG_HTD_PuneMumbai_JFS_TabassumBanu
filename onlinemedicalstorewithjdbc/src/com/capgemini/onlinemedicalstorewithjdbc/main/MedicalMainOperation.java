package com.capgemini.onlinemedicalstorewithjdbc.main;

import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.controller.AdminLogin;
import com.capgemini.onlinemedicalstorewithjdbc.controller.CartOperations;
import com.capgemini.onlinemedicalstorewithjdbc.controller.ProductOperationsOfAdmin;
import com.capgemini.onlinemedicalstorewithjdbc.controller.RegisterUser;
import com.capgemini.onlinemedicalstorewithjdbc.controller.UpdateUserPassword;
import com.capgemini.onlinemedicalstorewithjdbc.controller.UserLogin;
import com.capgemini.onlinemedicalstorewithjdbc.controller.UserOperationsOfAdmin;
import com.capgemini.onlinemedicalstorewithjdbc.dao.CartDAO;
import com.capgemini.onlinemedicalstorewithjdbc.exception.ExceptionMethods;
import com.capgemini.onlinemedicalstorewithjdbc.exception.MedicalStoreExceptions;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;

public class MedicalMainOperation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int choice;
		int adminChoice;
		char selectedOperation;
		

		while (true) {
			System.out.println("\n---------WELCOME TO ONLINE MEDICAL STORE--------");
			RegisterUser registerUser = new RegisterUser();
			System.out.println("Press 1 to Login as Admin");
			System.out.println("Press 2 to Login as User");
			System.out.println("Press 3 to User Registration");
			
			while (true) {
				String choice1 = sc.next();
				int choice = 0;
				try {
					choice = ExceptionMethods.numberValidation(choice1);

				} catch (MedicalStoreExceptions m) {
					m.getMessage();
					
				}

			//choice = sc.nextInt();
			switch (choice) {
			case 1:// Login as admin
				AdminLogin adminLogin = new AdminLogin();
				adminLogin.loginAdmin();
				
				ProductOperationsOfAdmin operationAdmin = new ProductOperationsOfAdmin();
				operationAdmin.operation();
				
			case 2:// Login as user
				UserLogin Login = new UserLogin();
			    Login.loginUser();
				
				CartOperations allCartOperations = new CartOperations();
				allCartOperations.userLogin();

			case 3:// Registering the user
				registerUser.userRegister();
				break;

			default:
				System.out.println("enter valid option");
				break;
			}// End of switch
			}// End of while 2 case
			
		} // End of while 1 case
	}// End of main()
}// End of class

