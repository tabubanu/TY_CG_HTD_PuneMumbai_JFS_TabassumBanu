package com.capgemini.onlinemedicalstorewithjdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.bean.UserBean;
import com.capgemini.onlinemedicalstorewithjdbc.dao.MedicalDAO;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;

public class UserOperationsOfAdmin {

	Scanner sc = new Scanner(System.in);
	
		public void showAllUser() {
			MedicalDAO dao = MedicalFactory.getDAOImplInstance();
			List<UserBean> list = dao.showUsers();
			if (list != null)
			{	
				for (UserBean userBean : list)
				{
					System.out.println("User ID: "+userBean.getUser_id());
					System.out.println("User Name: "+userBean.getUser_name());
					System.out.println("User Email: "+userBean.getEmail());
					System.out.println("User Mobile Number"+userBean.getMobile_number());
					System.out.println("-----------------------------------------------------");
				}//End of for loop
			}
			else
			{
				System.out.println("Something went wrong");
			}
		}//End of showAllUser()
		
		//To remove user by admin
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
		
		
		public void operationsOnUser() {
			System.out.println("Press a to Show All Users");
			System.out.println("Press b to Remove User");
			System.out.println("Press c exit");
			char selectedOperation = sc.next().charAt(0);
			switch (selectedOperation) {
			case 'a':
				// To show all users to admin
			    showAllUser();
			    operationsOnUser();
				break;
			case 'b':
				// To remove selected user by admin
				userRemove();
				operationsOnUser();
				break;
			case 'c':
				ProductOperationsOfAdmin adminProduct = new ProductOperationsOfAdmin();
				adminProduct.operation();
				//Go back to menu
				break;
			default:
				System.out.println("Enter correct input");
				break;
			}
		}//End of userOperationByAdmin()

	}//End of class

	

