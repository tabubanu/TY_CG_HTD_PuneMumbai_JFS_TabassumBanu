package com.capgemini.onlinemedicalstoreusingjpahibernate.dao;

import java.util.List;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.AdminBean;
import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.UserBean;

public interface MedicalDAO {

	public AdminBean loginAdmin(String email, String password);
	public UserBean userLogin(String email, String password);
	public boolean registerUser(UserBean userBean);
	public List<UserBean> showAllUsers();
	public UserBean getUser(int userId);
	public boolean deleteUser(int userId);
	boolean updateUserPassword(long mobile, String password);
}
