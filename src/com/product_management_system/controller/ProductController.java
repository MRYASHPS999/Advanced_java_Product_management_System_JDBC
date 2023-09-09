package com.product_management_system.controller;

import com.product_management_system.dto.Product;
import com.product_management_system.service.ProductService;


public class ProductController {
	
	public static void main(String[] args) {
		
		Product product=new Product();
		
		product.setProduct_id(1);
		product.setProduct_name("Buscuit");
		product.setPrice(23.80);
		product.setStock(10);
		
		ProductService productService=new ProductService();
		
		Product p= productService.saveProduct(product);
		
		if(p!=null) {
			System.out.println(p.getProduct_id()+" saved successfully");
		}
		
		boolean p1 = productService.getProductDataById(3);
		System.out.println(p1);

		Product p2 = productService.getAllProductData(product);
		System.out.println(p2);

		boolean res1 = productService.updateProductById(4);
		System.out.println(res1);

		boolean res = productService.deleteProductById(2);
		System.out.println(res);
	}

}
