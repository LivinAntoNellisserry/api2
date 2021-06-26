package com.api2.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api2.model.Product;
import com.api2.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo repo;

	public Product getProductById(String productId) {

		
		if(!(repo.findByProductId(productId).isPresent()))
		{
			Product errorMsg = new Product();
			errorMsg.setId(0);
			errorMsg.setProductId("ERROR");
			errorMsg.setProductName("NOT FOUND");
			errorMsg.setProductExpiryDate(Date.valueOf(LocalDate.now()));
			return errorMsg;
		}
		return repo.findByProductId(productId).get();
	}

	public Product addProduct(Product product) {
		
		if(repo.findByProductId(product.getProductId()).isPresent())
		{
			Product errorMsg = new Product(); 
			errorMsg.setId(0);
			errorMsg.setProductId("ERROR");
			errorMsg.setProductName("EXIST");
			errorMsg.setProductExpiryDate(Date.valueOf(LocalDate.now()));
			return errorMsg;
		}
		repo.save(product);
		return this.getProductById(product.getProductId());
	}

	public Product updateProduct(Product product) {
		
		if(repo.findByProductId(product.getProductId()).isPresent())
		{
			Product updater = repo.findByProductId(product.getProductId()).get();
			updater.setProductExpiryDate(product.getProductExpiryDate());
			updater.setProductName(product.getProductName());
			repo.save(updater);
			return this.getProductById(product.getProductId());
		}
		Product errorMsg = new Product();
		errorMsg.setId(0);
		errorMsg.setProductId("ERROR");
		errorMsg.setProductName("NOT FOUND");
		errorMsg.setProductExpiryDate(Date.valueOf(LocalDate.now()));
		return errorMsg;
		
	}

	public Integer deleteProduct(String productId) {
		
		if(repo.findByProductId(productId).isPresent())
		{
			if((repo.findByProductId(productId).get().getProductExpiryDate())
					.before(Date.valueOf(LocalDate.now())))
			{
				repo.delete(repo.findByProductId(productId).get());
				return 1;  //Product Expired and deleted
			}
			return -1;  //Product not expired
		}
		return 0;  //Product not present
	}

}
