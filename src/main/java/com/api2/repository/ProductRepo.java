package com.api2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api2.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, String>{

	public Product findByProductId(String productId);
}
