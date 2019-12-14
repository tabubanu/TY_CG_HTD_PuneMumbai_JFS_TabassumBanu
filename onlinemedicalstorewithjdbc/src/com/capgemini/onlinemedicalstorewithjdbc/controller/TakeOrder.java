package com.capgemini.onlinemedicalstorewithjdbc.controller;

import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.bean.ProductBean;
import com.capgemini.onlinemedicalstorewithjdbc.dao.ProductDAO;
import com.capgemini.onlinemedicalstorewithjdbc.factory.MedicalFactory;

public class TakeOrder {
	public double order(double totalbill)
	{
		Scanner scanner = new Scanner(System.in);
		ProductDAO productDAO = MedicalFactory.getProductImplInstance();
		double price = 0;
		int order;
		int loop = 0;
		while(loop == 0)
		{
			System.out.println("Enter Your Order OR Press 0 to print bill");
			order = scanner.nextInt();
			ProductBean productBean = productDAO.getProductInfo(order);

			if(order != 0)
			{
				if(productBean != null)
				{
					System.out.println(productBean.getPrice());
					price = price+productBean.getPrice();
					totalbill = totalbill+productBean.getPrice();
				}
				else
				{
					System.out.println("Enter the right order");
				}
			}
			else
			{
				System.out.println("Your bill is "+price);
				loop++;
				return totalbill;
			}
		}
		return 0;
	}
}//End of Class
