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

import com.capgemini.onlinemedicalstorewithjdbc.bean.AdminBean;
import com.capgemini.onlinemedicalstorewithjdbc.bean.ProductBean;
import com.capgemini.onlinemedicalstorewithjdbc.bean.UserBean;
import com.capgemini.onlinemedicalstorewithjdbc.controller.AdminLogin;

public class MedicalDAOJDBCImpl implements MedicalDAO {

	FileReader reader = null;
	Properties prop = null;
	UserBean user;
	AdminBean admin;
	ProductBean product;

	public MedicalDAOJDBCImpl() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			reader = new FileReader("jdbc.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//End of MedicalDAOJDBCImpl()

	@Override
	public AdminBean adminLogin(String email, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query1"))) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("*****Successfully login******");
					admin = new AdminBean();
					admin.setAdmin_id(rs.getInt(1));
					admin.setAdmin_name(rs.getString(2));
					admin.setMobile_number(rs.getLong(4));
				}
				return admin;

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}// End of adminlogin

	@Override
	public UserBean userLogin(String email, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query2"))) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					System.out.println("*****Successfully login******");
					user = new UserBean();
					user.setUser_id(rs.getInt(1));
					user.setUser_name(rs.getString(2));
					user.setMobile_number(rs.getLong(4));
				}
				return user;

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}// End of userlogin()

	@Override
	public boolean registerUser(UserBean userBean) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query3"))) {
			pstmt.setInt(1, userBean.getUser_id());
			pstmt.setString(2, userBean.getUser_name());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setLong(4, userBean.getMobile_number());
			pstmt.setString(5, userBean.getPassword());
		
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
	}//End of registerUser()

	@Override
	public List<UserBean> showUsers() {
		List<UserBean> list = new ArrayList<UserBean>();
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query4"))){
			while (rs.next()) {
				user = new UserBean();
				user.setUser_id(rs.getInt(1));
				user.setUser_name(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setMobile_number(rs.getLong(4));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}//End of showUsers()

	@Override
	public boolean removeUser(int userId) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query5"))) {
			pstmt.setInt(1, userId);
		
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
	}//End of removeUser()

	@Override
	public boolean updateUserPassword(long mobile, String password) {
		try (Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"), prop.getProperty("user"),
				prop.getProperty("password"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("query6"))) {
			
			pstmt.setString(1, password);
			pstmt.setLong(2, mobile);
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
	}//End of updateUserPassword()
}// End of class
