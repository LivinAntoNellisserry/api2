package com.api2.service;

import com.api2.model.Product;
import com.api2.schema.Response;

/**
 * 
 * ProductService Interface
 *
 */
public interface ProductService {
	/**
	 * Returns a response containing the product by Id if present.
	 * 
	 * @param productId
	 * @return response
	 */
	public Response getProductById(String productId);

	/**
	 * Saves the product and returns a response containing the saved product.
	 * 
	 * @param product
	 * @return response
	 */
	public Response addProduct(Product product);

	/**
	 * Updates the product and returns the response containing the updated product.
	 * 
	 * @param product
	 * @return response
	 */
	public Response updateProduct(Product product);

	/**
	 * Deletes the product and returns a response containing the status of deletion.
	 * 
	 * @param productId
	 * @return response
	 */
	public Response deleteProduct(String productId);

}
