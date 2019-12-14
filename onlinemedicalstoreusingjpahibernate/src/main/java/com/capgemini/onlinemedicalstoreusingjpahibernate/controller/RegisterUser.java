package com.capgemini.onlinemedicalstoreusingjpahibernate.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MedicalDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.UserBean;
import com.capgemini.onlinemedicalstoreusingjpahibernate.factory.MedicalFactory;

public class RegisterUser {
	public void userRegister() {
		MedicalDAO dao = MedicalFactory.getDAOImplInstance();
		UserBean data = new UserBean();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your Name: ");
		data.setUserName(scanner.nextLine());
		System.out.println("Enter your Email: ");
		Pattern pat = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		String email = scanner.next();
		Matcher mat = pat.matcher(email);
		if(mat.matches()) {
			data.setEmail(email);
			System.out.println("Enter your Mobile Number: ");
			data.setMobileNumber(scanner.nextLong());
			System.out.println("Enter Password: ");
			data.setPassword(scanner.next());
		} else {
			System.err.println("Enter valid Email...");
			userRegister();
		}
		
		boolean user = dao.registerUser(data);
		if(user == true) {
			System.out.println("Registered Successfully");
		} else {
			System.out.println("Unable To Registered");
		}
	}//End of userRegister()
}//End of Class
