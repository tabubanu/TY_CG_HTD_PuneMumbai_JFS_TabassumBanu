package com.capgemini.onlinemedicalstoreusingspringrest.services;

import java.util.List;

import com.capgemini.onlinemedicalstoreusingspringrest.beans.ProductBean;


public interface ProductServices {
	public boolean addProduct(ProductBean productBean);

	public boolean updateProduct(ProductBean productBean);

	public boolean removeProduct(int productId);

	public List<ProductBean> showAllProducts();

	List<ProductBean> showProduct(int productId);
}// End of Interface
