package com.product_management_system.service;

import com.product_management_system.dao.ProductDao;

import com.product_management_system.dto.Product;

public class ProductService {
	
	
     ProductDao productDao=new ProductDao();
	
	public Product saveProduct(Product product) {
		return productDao.saveProduct(product);
	}
	
	public Product getAllProductData(Product product) {
		return productDao.getAllProductData(product);
		
	}
	
	public boolean getProductDataById(int product_id) {
		return productDao.getProductDataById(product_id);
		
	}

	public boolean updateProductById(int product_id) {
		return productDao.updateProductById(product_id);
		
	}
	
	public boolean deleteProductById(int product_id) {
		return productDao.deleteProductById(product_id);
		
	}
}
