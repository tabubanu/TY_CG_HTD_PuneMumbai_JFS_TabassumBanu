package com.capgemini.onlinemedicalstorewithjdbc.controller;

import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.bean.UserBean;
import com.capgemini.onlinemedicalstorewithjdbc.dao.MedicalDAO;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;

public class UserLogin {
	public void loginUser() {
		Scanner scanner=new Scanner(System.in);
		MedicalDAO dao=MedicalFactory.getDAOImplInstance();
		System.out.println("Enter your email: ");
		String r=scanner.next();
		scanner.nextLine();
		System.out.println("Enter the user password: ");
		String p=scanner.next();
		UserBean user=dao.userLogin(r,p);
		if(user!=null) {
			System.out.println(user);	
		} else {
			System.out.println("Something went wrong...");
			loginUser();
		}
	}//End of loginUser()
}//End of class
