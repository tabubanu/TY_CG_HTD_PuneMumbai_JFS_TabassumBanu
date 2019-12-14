package com.capgemini.onlinemedicalstorewithjdbc.dao;

import java.util.List;

import com.capgemini.onlinemedicalstorewithjdbc.bean.CartBean;

public interface CartDAO {

	public boolean addIntoCart(int productId);
	List<CartBean> showCartProducts();
	public boolean removeCartProduct(int productId);
	public double totalBill();
	public boolean deleteCart();
}
