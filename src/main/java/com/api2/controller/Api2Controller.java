package com.api2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api2.model.Product;
import com.api2.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping("/api2")
public class Api2Controller {

	@Autowired
	ProductService serv;

	@GetMapping("/search/{productId}")
	@ApiOperation(value = "Search by Product ID")
	public ResponseEntity<?> getProductById(@PathVariable String productId) {
		return new ResponseEntity<Product>(serv.getProductById(productId), HttpStatus.OK);
	}

	@PostMapping("/add")
	@ApiOperation(value = "Add Product")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		return new ResponseEntity<Product>(serv.addProduct(product), HttpStatus.ACCEPTED);
	}

}
