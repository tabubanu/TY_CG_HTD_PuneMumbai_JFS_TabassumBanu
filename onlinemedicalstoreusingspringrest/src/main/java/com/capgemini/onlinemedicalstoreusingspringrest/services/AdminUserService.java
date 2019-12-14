package com.capgemini.onlinemedicalstoreusingspringrest.services;

import java.util.List;

import com.capgemini.onlinemedicalstoreusingspringrest.beans.AdminUserBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.ProductBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.UserBean;


public interface AdminUserService {
	public AdminUserBean adminUserLogin(String email, String password, String type);

	public boolean userRegister(AdminUserBean adminUserBean);

	public boolean adminLogout();

	public List<ProductBean> getAllMedicines();

	public List<AdminUserBean> getAllUsers();

	public boolean deleteUser(int userid);
	
	public boolean userLogout(int userid);
}
