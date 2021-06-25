package com.api2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api2.model.Product;
import com.api2.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepo repo;
	
	public Product getProductById(String productId) {
		if(repo.findById(productId).isPresent())
		{
			return repo.findById(productId).get();
		}
		return null;
	}

	public Product addProduct(Product product) {
		repo.save(product);
		return this.getProductById(product.getProductId());
	}

}
