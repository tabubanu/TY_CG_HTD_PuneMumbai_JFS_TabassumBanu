package com.capgemini.onlinemedicalstorewithjdbc.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.bean.ProductBean;
import com.capgemini.onlinemedicalstorewithjdbc.dao.ProductDAO;
import com.capgemini.onlinemedicalstorewithjdbc.exception.ExceptionMethods;
import com.capgemini.onlinemedicalstorewithjdbc.exception.MedicalStoreExceptions;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;
import com.capgemini.onlinemedicalstorewithjdbc.main.MedicalMainOperation;

public class ProductOperationsOfAdmin {

	Scanner scanner = new Scanner(System.in);
	
	
	public void operationsOnProduct() {
		   
		System.out.println("Press 1 to Add Product");
		System.out.println("Press 2 to Update Product");
		System.out.println("Press 3 to Remove Product");
		System.out.println("Press 4 to see selected category products");
		System.out.println("Press 5 to Show All Products");
		System.out.println("Press 6 to exit");
		while (true) {
			String adminChoice1 = scanner.next();
			int ch = 0;
			try {
				ch = ExceptionMethods.numberValidation(adminChoice1);

			} catch (MedicalStoreExceptions m) {
				m.getMessage();
				
			}
		//char selectedOperation = scanner.next().charAt(0);
		switch (ch) {
		case 1 :// To Add new Product by admin
			productAdd();
			break;
		case 2:// To Update details by admin
			productUpdate();
			break;
		case 3:// To Remove product by admin
			productRemove();
			break;
		case 4://To change again category
			showCategoryProducts();
			break;
		case 5 ://To show all products
			showAllProducts();
			break;
		case 6 : // To exit
		operation();
		default:
			System.out.println("Enter Correct Operation Number");
			break;
		}
		}//
	}//End of productOperationByAdmin()
	
	public void operation() {
		
		while (true) {
			System.out.println("Press 1 to perform operation on user");
			System.out.println("Press 2 to perform operation on product");		
			System.out.println("Press 3 to Logout");
			System.out.println("Enter Your Choice : ");
			while (true) {
				String adminChoice1 = scanner.next();
				int ch = 0;
				try {
					ch = ExceptionMethods.numberValidation(adminChoice1);

				} catch (MedicalStoreExceptions m) {
					m.getMessage();
					
				}

			switch (ch) {
			case 1:// Operations on users by admin
				UserOperationsOfAdmin userOperations = new UserOperationsOfAdmin();
				userOperations.operationsOnUser();
				break;

			case 2:// Operation on products by admin
				ProductOperationsOfAdmin productOperations = new ProductOperationsOfAdmin();
				productOperations.operationsOnProduct();
				break;

			case 3:// Admin Logout
				System.out.println("-----Logged Out Successfully --------");
				MedicalMainOperation.main(null);
				//main(args);
				break;

			default:
				System.out.println("Please Enter Valid Option");
				break;
			} // End of switch
		}
		}
	}
	
	
	
		public void showCategoryProducts() {
			Scanner sc=new Scanner(System.in);
			ProductDAO productDAO = MedicalFactory.getProductImplInstance();
			//System.out.println("Enter the Category \nAyurvedic \nBabyCare");
			System.out.println("Enter the category of your wish from the below : ");
			System.out.println("Ayurvedic");
			System.out.println("BabyCare");
			System.out.println("HairCare");
			List<ProductBean> list = productDAO.categoryProducts(sc.nextLine());
			if (list != null)
			{	
				for (ProductBean productBean : list)
				{
					System.out.println(productBean);
					operationsOnProduct(); //
				}//End of for loop
			}
			else
			{
				System.out.println("Something went wrong");
				operationsOnProduct();
			}
		}
		
		public void productAdd() {
			ProductDAO dao = MedicalFactory.getProductImplInstance();
			ProductBean info = new ProductBean();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter product id");
			info.setProductId(scanner.nextInt());
			System.out.println("Enter Product Name: ");
			info.setProductName(scanner.next());
			scanner.nextLine();
			System.out.println("Enter Product Brand: ");
			info.setProductBrand(scanner.next());
			System.out.println("Enter Product Category: ");
			info.setCategory(scanner.next());
			scanner.nextLine();
			System.out.println("Enter Product Price: ");
			info.setPrice(scanner.nextDouble());
			System.out.println("Enter Product Details: ");
			info.setDetails(scanner.next());
			scanner.nextLine();
			System.out.println("Enter the Product Availability ");
			info.setAvailable(scanner.next());
			if(dao.addProduct(info)) {
				System.out.println(" Product Added ");
				operationsOnProduct();
			} else {
				System.out.println("Something went wrong");
				operationsOnProduct();
			}
		}//End of addProduct()

		public void productUpdate() {
			ProductDAO productDAO = MedicalFactory.getProductImplInstance();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Product Id you  want to update : ");
			int productId = scanner.nextInt();
			System.out.println("Enter the new price for this Item");
			double price = scanner.nextDouble();
			System.out.println("enter whether the product is available or not");
			String available = scanner.next();
			if(productDAO.updateProduct(productId, price, available)) {
				System.out.println("Product Updated");
				operationsOnProduct();
			}
			else {
			 	System.out.println("Something went wrong");
			 	operationsOnProduct();
			}
		}
		

		public void productRemove() {
			ProductDAO productDAO = MedicalFactory.getProductImplInstance();
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Product Id which you want to delete");
			if(productDAO.removeProduct(scanner.nextInt())) {
				System.out.println("Product deleted ");
			} else {
				System.out.println("Something went wrong");
			}
		}
		
		public void showAllProducts() {
			ProductDAO dao = MedicalFactory.getProductImplInstance();
			List<ProductBean> list = dao.showAllProducts();
			if(list!=null) {
				for (ProductBean productBean : list) {
					System.out.println("Product ID: " + productBean.getProductId());
					System.out.println("Product Name: " + productBean.getProductName());
					System.out.println("Product Brand: " + productBean.getProductBrand());
					System.out.println("Product Category: "+productBean.getCategory());
					System.out.println("Product Price: " + productBean.getPrice());
					System.out.println("Product Details: " +productBean.getDetails());
					System.out.println("Product Pack Size: "+productBean.getAvailable());
					System.out.println("-----------------------------------------------------");
					operationsOnProduct();
				
				} // End of for loop
			} else {
				System.out.println("Something went wrong");
			}
			
		}//End of showAllProducts
		

	}//End of class

	

