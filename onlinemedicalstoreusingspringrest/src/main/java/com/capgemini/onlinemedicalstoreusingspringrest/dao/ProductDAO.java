package com.capgemini.onlinemedicalstoreusingspringrest.dao;

import java.util.List;

import com.capgemini.onlinemedicalstoreusingspringrest.beans.ProductBean;


public interface ProductDAO {
	// Abstract methods to perform operations on products
	public boolean addProduct(ProductBean productBean);

	public boolean updateProduct(ProductBean productBean);

	public boolean removeProduct(int productId);

	public List<ProductBean> showAllProducts();

	public List<ProductBean> showProduct(int productId);
}// End of Interface
