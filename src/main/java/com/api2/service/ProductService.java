package com.api2.service;

import com.api2.model.Product;

public interface ProductService {
	public Product getProductById(String productId);
	public Product addProduct(Product product);
	
}