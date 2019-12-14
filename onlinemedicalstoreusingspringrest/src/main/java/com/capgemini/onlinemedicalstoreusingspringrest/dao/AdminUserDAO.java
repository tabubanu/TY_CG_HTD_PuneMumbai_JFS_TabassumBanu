package com.capgemini.onlinemedicalstoreusingspringrest.dao;

import java.util.List;

import com.capgemini.onlinemedicalstoreusingspringrest.beans.AdminUserBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.ProductBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.UserBean;



public interface AdminUserDAO {
	public AdminUserBean adminUserLogin(String email, String password, String type);

	public boolean userRegister(AdminUserBean adminUserBean);

	public boolean adminLogout();

	public List<ProductBean> getAllMedicines();

	public List<AdminUserBean> getAllUsers();

	public boolean deleteUser(int id);

	public boolean userLogout(int id);
}
