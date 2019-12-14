package com.capgemini.onlinemedicalstorewithjdbc.controller;

import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.dao.MedicalDAO;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;

public class RemoveUser {
	public void userRemove() {
		MedicalDAO medicalDAO = MedicalFactory.getDAOImplInstance();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the UserId which you want to delete");
		if(medicalDAO.removeUser(Integer.parseInt(scanner.nextLine())))
		{
			System.out.println("User deleted Sucessfully");
		}
		else
		{
			System.out.println("Something went wrong");
		}
	}//End of userRemove()

}//End of class
