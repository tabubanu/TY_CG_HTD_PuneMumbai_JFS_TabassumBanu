package com.capgemini.onlinemedicalstorewithjdbc.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.onlinemedicalstorewithjdbc.bean.CartBean;

public class CartDAOJDBCImpl implements CartDAO {

	
	FileReader reader = null;
	Properties prop = null;
	CartBean cartBean;
	public CartDAOJDBCImpl() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("jdbc.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//End of CartDAOJDBCImpl()
	
	@Override
	public boolean addIntoCart(int productId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query12"))) {
			pstmt.setInt(1, productId);
			
		
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//End of addIntoCart()
	
	
	@Override
	public List<CartBean> showCartProducts() {
		List<CartBean> list = new ArrayList<CartBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query13"))){
			while (rs.next()) {
				cartBean = new CartBean();
				cartBean.setProductId(rs.getInt(1));
				cartBean.setProductName(rs.getString(2));
				cartBean.setProductBrand(rs.getString(3));
				cartBean.setCategory(rs.getString(4));
				cartBean.setPrice(rs.getDouble(5));
				cartBean.setDetails(rs.getString(6));
				cartBean.setAvailable(rs.getString(7));
				list.add(cartBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}//End of showCartProducts()

	@Override
	public boolean removeCartProduct(int productId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query14"))) {
			pstmt.setInt(1, productId);
		
			int count = pstmt.executeUpdate();
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// Deleting Product From Cart
	
	@Override
	public double totalBill() {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query15"))){
			double sum = 0;
			while (rs.next()) {
			      double price = rs.getDouble(1);
			      sum = sum + price;
			    }
			 System.out.println("Total bill is = " + sum);
		
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean deleteCart() {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = conn.createStatement()) {
		
			int count = stmt.executeUpdate(prop.getProperty("query16"));
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//End of deleteCart()
		
}//End of Class
