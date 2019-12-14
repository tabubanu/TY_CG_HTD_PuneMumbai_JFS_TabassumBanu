package com.capgemini.onlinemedicalstoreusingspringrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinemedicalstoreusingspringrest.beans.ProductBean;
import com.capgemini.onlinemedicalstoreusingspringrest.dao.ProductDAO;



@Service
public class ProductServiceImpl implements ProductServices {
	
	@Autowired
	private ProductDAO productDAO;

	@Override
	public boolean addProduct(ProductBean productBean) {
		return productDAO.addProduct(productBean);
	}

	@Override
	public boolean updateProduct(ProductBean productBean) {
		return productDAO.updateProduct(productBean);
	}

	@Override
	public boolean removeProduct(int productId) {
		return productDAO.removeProduct(productId);
	}

	@Override
	public List<ProductBean> showAllProducts() {
		return productDAO.showAllProducts();
	}

	@Override
	public List<ProductBean> showProduct(int productId) {
		return productDAO.showProduct(productId);
	}
	

}//End of Class
