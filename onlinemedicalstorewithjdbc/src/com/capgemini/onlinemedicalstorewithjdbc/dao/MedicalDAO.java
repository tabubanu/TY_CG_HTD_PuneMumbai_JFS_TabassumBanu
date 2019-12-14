package com.capgemini.onlinemedicalstorewithjdbc.dao;

import java.util.List;

import com.capgemini.onlinemedicalstorewithjdbc.bean.AdminBean;
import com.capgemini.onlinemedicalstorewithjdbc.bean.ProductBean;
import com.capgemini.onlinemedicalstorewithjdbc.bean.UserBean;

public interface MedicalDAO {
	public AdminBean adminLogin(String email, String password);
	public UserBean userLogin(String email,String password);
	boolean registerUser(UserBean userBean);
	List<UserBean> showUsers();
	boolean removeUser(int userId);
	boolean updateUserPassword(long mobile, String password);
}
