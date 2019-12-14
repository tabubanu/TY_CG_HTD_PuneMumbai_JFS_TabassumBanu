package com.capgemini.onlinemedicalstoreusingjpahibernate.dao;

import java.util.List;

import com.capgemini.onlinemedicalstoreusingjpahibernate.dto.ProductBean;

public interface ProductDAO {

	public boolean addProduct(ProductBean productBean);
	public boolean updateProduct(int productId, double price, String available);
	public boolean removeProduct(int productId);
	public List<ProductBean> showAllProducts();
	List<ProductBean> categoryProducts(String category);
}
