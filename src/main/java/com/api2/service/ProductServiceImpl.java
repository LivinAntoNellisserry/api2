package com.api2.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api2.model.Product;
import com.api2.repository.ProductRepo;
import com.api2.schema.ProductClone;
import com.api2.schema.Response;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

	private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
	private static final String SUCCESS = "SUCCESS";
	private static final String FAILED = "FAILED";
	@Autowired
	ProductRepo repo;

	public Response getProductById(String productId) {
		log.info("Called getProductById Service");
		log.debug(productId);

		Optional<Product> product = repo.findByProductId(productId);
		if (product.isPresent()) {
			log.info("Product was found");
			ProductClone productClone = this.getProductClone(product.get());
			if (log.isDebugEnabled()) {
				log.debug(productClone.toString());
			}
			String status;
			if (product.get().getProductExpiryDate().before(Date.valueOf(LocalDate.now()))) {
				status = "EXPIRED";
			} else {
				status = "NOT EXPIRED";
			}
			log.info("Exited getProductById Service");
			return this.getResponse(SUCCESS, status, productClone);
		}
		log.info("Product is absent");
		log.info("Exited getProductById Service");
		return this.getResponse(FAILED, "PRODUCT ABSENT", null);
	}

	public Response addProduct(Product product) {

		log.info("Called addProduct Service");
		if (repo.findByProductId(product.getProductId()).isPresent()) {
			log.info("Product was not added because it was already present");
			log.info("Exited addProduct Service");
			return this.getResponse(FAILED, "PRODUCT ALREADY PRESENT", null);
		}
		ProductClone productClone = this.getProductClone(repo.save(product));
		log.info("Product was added");
		if (log.isDebugEnabled()) {
			log.debug(productClone.toString());
		}
		log.info("Exited addProduct Service");
		return this.getResponse(SUCCESS, "PRODUCT SAVED", productClone);
	}

	public Response updateProduct(Product product) {
		log.info("Called updateProduct Service");
		Optional<Product> tempProduct = repo.findByProductId(product.getProductId());
		if (tempProduct.isPresent()) {
			Product updater = tempProduct.get();
			updater.setProductExpiryDate(product.getProductExpiryDate());
			updater.setProductName(product.getProductName());
			ProductClone productClone = this.getProductClone(repo.save(updater));
			log.info("Product was updated");
			if (log.isDebugEnabled()) {
				log.debug(productClone.toString());
			}
			log.info("Exited updateProduct Service");
			return this.getResponse(SUCCESS, "PRODUCT UPDATED", productClone);
		}
		log.info("Update failed because product was not present");
		log.info("Exited updateProduct Service");
		return this.getResponse(FAILED, "PRODUCT NOT PRESENT", null);
	}

	public Response deleteProduct(String productId) {
		log.info("Called deleteProduct Service");
		Optional<Product> product = repo.findByProductId(productId);

		if (product.isPresent()) {
			if ((product.get().getProductExpiryDate()).before(Date.valueOf(LocalDate.now()))) {
				repo.delete(product.get());
				log.info("Product was Expired and Deleted");
				return this.getResponse(SUCCESS, "PRODUCT EXPIRED AND DELETED", null);
			}
			log.info("Product was Not Deleted because product was Not Expired");
			return this.getResponse(FAILED, "PRODUCT NOT EXPIRED", null);
		}
		log.info("Product was Not Deleted because product was Not Present");
		return this.getResponse(FAILED, "PRODUCT NOT PRESENT", null);
	}

	/**
	 * Create and returns the response.
	 * 
	 * @param responseType
	 * @param responseMessage
	 * @param productClone
	 * @return response
	 */
	private Response getResponse(String responseType, String responseMessage, ProductClone productClone) {
		Response response = new Response();
		response.setResponseType(responseType);
		response.setResponseMessage(responseMessage);
		response.setProductClone(productClone);
		return response;
	}

	/**
	 * Create and returns the productResponse.
	 * 
	 * @param product
	 * @return productClone
	 */
	private ProductClone getProductClone(Product product) {
		ProductClone productClone = new ProductClone();
		productClone.setCloneId(product.getId());
		productClone.setCloneProductExpiryDate(product.getProductExpiryDate().toString());
		productClone.setCloneProductId(product.getProductId());
		productClone.setCloneProductName(product.getProductName());
		return productClone;

	}

}
