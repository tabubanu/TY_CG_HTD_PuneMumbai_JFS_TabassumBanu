package com.capgemini.onlinemedicalstoreusingjpahibernate.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.onlinemedicalstoreusingjpahibernate.MedicalMain;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MedicalDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.MessageDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dao.ProductDAO;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.MessageBean;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.ProductBean;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.UserBean;
import com.capgemini.onlinemedicalstoreusingjpahibernate.exception.ExceptionMethods;
import com.capgemini.onlinemedicalstoreusingjpahibernate.exception.MedicalStoreExceptions;
import com.capgemini.onlinemedicalstoreusingjpahibernate.factory.MedicalFactory;

public class AllAdminOperations {

	Scanner scanner = new Scanner(System.in);
	MedicalDAO medicalDAO = MedicalFactory.getDAOImplInstance();
	MessageDAO messageDAO = MedicalFactory.getDAOMessageImplInstance();

	ExceptionMethods exception = new ExceptionMethods();
	boolean correct = false;
	public void adminOperation() {
		System.out.println("Press 1 for Operatins on User");
		System.out.println("Press 2 for Operation on Product");
		System.out.println("Press 3 for Query Section");
		System.out.println("Press 4 to Logout");
		int adminChoice = 0;
		correct = true;
		while (correct) {
			try {
				String choice1 = scanner.next();
				adminChoice = exception.numberValidation(choice1);
				correct = false;
			} catch (MedicalStoreExceptions e) {
				e.getMessage();
			}
		
		}
		 //int adminChoice = scanner.nextInt();
		if (adminChoice == 1) {
			while (true) {
				System.out.println("Press a Display Users \nPress b Delete User \nPress c to exit");
				char selectedOperation = scanner.next().charAt(0);
				switch (selectedOperation) {
				case 'a':
					// To show all users to admin
					List<UserBean> userList = medicalDAO.showAllUsers();
					for (UserBean userBean : userList) {
						System.out.println("UserId = " + userBean.getUserId());
						System.out.println("UserName = " + userBean.getUserName());
						System.out.println("Email = " + userBean.getEmail());
						System.out.println("Mobile Number = " + userBean.getMobileNumber());
						System.out.println("###################################################");
					}
					break;
				case 'b':
					// To remove selected user by admin
					Scanner scanner = new Scanner(System.in);
					System.out.println("Enter the UserId to delete");
					int userId = scanner.nextInt();
					boolean state = medicalDAO.deleteUser(userId);
					if (state = true) {
						System.out.println("User deleted Successfully");
					} else {
						System.err.println("UserId not Available");
					}
					break;

				case 'c':// Go back to menu
					adminOperation();
					break;

				default:
					System.out.println("Please Enter Valid Option");
					break;
				}// End of switch case 1
			}
		} else if (adminChoice == 2) {
			ProductDAO productDAO = MedicalFactory.getDAOProductImplInstance();
			while (true) {
				System.out.println(
						"\nPress a to Add Product\nPress b to Update Product\nPress c to delete Product\nPress d to show Products\nPress e to return");
				char selectedOperation = scanner.next().charAt(0);
				switch (selectedOperation) {

				case 'a':// To Add new Product by admin
					ProductBean productBean = new ProductBean();
					System.out.println("Enter the Product Id: ");
					productBean.setProductId(scanner.nextInt());
					scanner.nextLine();
					System.out.println("Enter Product Name: ");
					productBean.setProductName(scanner.nextLine());
					System.out.println("Enter Product Brand: ");
					productBean.setProductBrand(scanner.nextLine());
					System.out.println("Enter Product Category: ");
					productBean.setCategory(scanner.nextLine());
					System.out.println("Enter Product Price: ");
					productBean.setPrice(scanner.nextDouble());
					scanner.nextLine();
					System.out.println("Enter Product Details: ");
					productBean.setDetails(scanner.nextLine());
					System.out.println("Enter Product Available or not");
					productBean.setAvailable(scanner.nextLine());
					boolean addProduct = productDAO.addProduct(productBean);

					if (addProduct == true) {
						System.out.println("New Product Added Successfully!!!");
					} else {
						System.err.println("Unable To Add Product");
					}
					break;

				case 'b':// To Update details by admin
					System.out.println("Enter the Product Id to update : ");
					int productId = scanner.nextInt();
					System.out.println("Enter price to update : ");
					double price = scanner.nextDouble();
					System.out.println("enter the products are present or not");
					String available = scanner.next();
					boolean updateState = productDAO.updateProduct(productId, price, available);
					if (updateState == true) {
						System.out.println("Product Updated Successfully");
					} else {
						System.out.println("Unable To Update Product");
					}
					break;

				case 'c':// To Remove product by admin
					System.out.println("Enter Product Id Which You Want To Delete");
					int removeProductId = scanner.nextInt();
					boolean removeState = productDAO.removeProduct(removeProductId);
					if (removeState == true) {
						System.out.println("Product Deleted Successfully");
					} else {
						System.err.println("Unable To delete Selected Product");
					}
					break;

				case 'd':// To show products
					
					List<ProductBean> productList = null;
				
						productList = productDAO.showAllProducts();
						for (ProductBean productBean1 : productList) {
							System.out.println("---------------------------------------------------------");
							System.out.println("Product ID = " + productBean1.getProductId());
							System.out.println("Product Name = " + productBean1.getProductName());
							System.out.println("Product Brand = " + productBean1.getProductBrand());
							System.out.println("Category = " + productBean1.getCategory());
							System.out.println("Price = " + productBean1.getPrice());
							System.out.println("Details = " + productBean1.getDetails());
							System.out.println("Available = " + productBean1.getAvailable());
							System.out.println("---------------------------------------------------------");
						}
				case 'e':// to exit
					adminOperation();
					break;

				default:
					System.out.println("Enter valid option");
					break;
				}

			} // End of while()

		} else if (adminChoice == 3) {
			List<MessageBean> messageBean = messageDAO.getMessage();
			for (MessageBean bean : messageBean) {
				System.out.println("User Id is "+bean.getUserId());
				System.out.println("Message is "+bean.getMessage());
			}
			System.out.println("enter userId");
			int userId = scanner.nextInt();
			scanner.nextLine();
			if (userId != 0) {
				String type = "Answer";
				System.out.println("Enter reply");
				String message = scanner.nextLine();
				boolean state = messageDAO.sendResponse(userId, message, type);
				if (state) {
					System.out.println("Reply Done");
					adminOperation();
				} else {
					System.err.println("Unable To Sent Response");
				}
			}

		} else if (adminChoice == 4) {
			System.out.println("******Logged Out Successfully********");
			System.out.println("-------------------------------------------------------------");
			MedicalMain.main(null);
			
		} else {
			System.err.println("Enter the valid input");
		}
		

	}// End of afterAdminLogin()
}
