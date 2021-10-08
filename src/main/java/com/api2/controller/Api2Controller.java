package com.api2.controller;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.api2.schema.ProductClone;
import com.api2.schema.Response;
import com.api2.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * Api2Controller Class. Contains all the Handler Methods.
 *
 */
@RestController
@Slf4j
@Api
@RequestMapping("/api2")
public class Api2Controller {

	private final Logger log = LoggerFactory.getLogger(Api2Controller.class);
	private static final String hitApi2 = "Hit Api2Controller";

	@Autowired
	ProductService serv;

	/**
	 * Returns a response for the productId.
	 * 
	 * @param productId
	 * @return response
	 */
	@GetMapping("/search/{productId}")
	@ApiOperation(value = "Search by Product ID")
	public ResponseEntity<Response> getProductById(@PathVariable String productId) {
		log.info(hitApi2);
		log.info("Called getProductById");
		log.debug(productId);
		return new ResponseEntity<Response>(serv.getProductById(productId), HttpStatus.OK);
	}

	/**
	 * Saves the product and returns the response containing the added product if it
	 * was added.
	 * 
	 * @param productClone
	 * @return response
	 */
	@PostMapping("/add")
	@ApiOperation(value = "Add Product")
	public ResponseEntity<Response> addProduct(@RequestBody ProductClone productClone) {
		log.info(hitApi2);
		log.info("Called addProduct");
		if (log.isDebugEnabled()) {
			log.debug(productClone.toString());
		}
		return new ResponseEntity<Response>(serv.addProduct(this.ProductCloneToProduct(productClone)), HttpStatus.OK);
	}

	/**
	 * Updates the product if the product was present and returns the response
	 * containing updated product.
	 * 
	 * @param productClone
	 * @return response
	 */
	@PostMapping("/update")
	@ApiOperation(value = "Update Product")
	public ResponseEntity<Response> updateProduct(@RequestBody ProductClone productClone) {
		log.info(hitApi2);
		log.info("Called updateProduct");
		if (log.isDebugEnabled()) {
			log.debug(productClone.toString());
		}
		return new ResponseEntity<Response>(serv.updateProduct(this.ProductCloneToProduct(productClone)),
				HttpStatus.OK);
	}

	/**
	 * Delete the product by Id and returns the response containing the status.
	 * 
	 * @param productId
	 * @return response
	 */
	@GetMapping("/delete/{productId}")
	@ApiOperation(value = "Delete Product")
	public ResponseEntity<Response> deleteProduct(@PathVariable String productId) {
		log.info(hitApi2);
		log.info("Called deleteProduct");
		log.debug(productId);
		return new ResponseEntity<Response>(serv.deleteProduct(productId), HttpStatus.OK);
	}

	/**
	 * Convert ProductClone to Product
	 * 
	 * @param productClone
	 * @return product
	 */
	private Product ProductCloneToProduct(ProductClone productClone) {
		Product product = new Product();
		product.setId(productClone.getCloneId());
		product.setProductId(productClone.getCloneProductId());
		product.setProductName(productClone.getCloneProductName());
		product.setProductExpiryDate(Date.valueOf(productClone.getCloneProductExpiryDate()));
		return product;
	}

}
