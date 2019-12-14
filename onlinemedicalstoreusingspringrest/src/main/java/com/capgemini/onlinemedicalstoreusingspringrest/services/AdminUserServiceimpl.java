package com.capgemini.onlinemedicalstoreusingspringrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinemedicalstoreusingspringrest.beans.AdminUserBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.ProductBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.UserBean;
import com.capgemini.onlinemedicalstoreusingspringrest.dao.AdminUserDAO;



@Service
public class AdminUserServiceimpl implements AdminUserService {
	@Autowired
	private AdminUserDAO dao;

	@Override
	public AdminUserBean adminUserLogin(String email, String password, String type) {
		return dao.adminUserLogin(email, password, type);
	}

	@Override
	public boolean adminLogout() {
		return dao.adminLogout();
	}

	@Override
	public List<ProductBean> getAllMedicines() {
		return dao.getAllMedicines();
	}

	@Override
	public List<AdminUserBean> getAllUsers() {
		return dao.getAllUsers();
	}

	@Override
	public boolean deleteUser(int userid) {
		return dao.deleteUser(userid);
	}

	@Override
	public boolean userRegister(AdminUserBean adminUserBean) {
		return dao.userRegister(adminUserBean);
	}

	@Override
	public boolean userLogout(int userid) {
		return dao.userLogout(userid);
	}

}
