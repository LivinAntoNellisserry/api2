//package com.api2.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//import java.sql.Date;
//import java.util.Optional;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.api2.model.Product;
//import com.api2.repository.ProductRepo;
//import com.api2.schema.Response;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//class ProductServiceTest {
//
//
//	@Autowired
//	private ProductService service;
//
//	@MockBean
//	private ProductRepo repository;
//
//	@Test
//	public void getProductByIdTest() {
//		Optional<Product> product = Optional.of(new Product(5, "G5", "Noodles", Date.valueOf("2021-12-21")));
//		Response response = new Response("SUCCESS","PRODUCT PRESENT",new Product(5, "G5", "Noodles", Date.valueOf("2021-12-21")));
//		when(repository.findByProductId("G5")).thenReturn(product);
//		assertEquals(response.toString(), service.getProductById("G5").toString());
//	}
//
//	@Test
//	public void addProductTest() {
//		Product product = new Product(5, "G5", "Noodles", Date.valueOf("2021-12-21"));
//		when(repository.save(product)).thenReturn(product);
//		Response response = new Response("SUCCESS","PRODUCT SAVED",new Product(5, "G5", "Noodles", Date.valueOf("2021-12-21")));
//		assertEquals(product.toString(), service.addProduct(product));
//	}
//	
////	@Test
////	public void getUserbyAddressTest() {
////		String address = "Bangalore";
////		when(repository.findByAddress(address))
////				.thenReturn(Stream.of(new User(376, "Danile", 31, "USA")).collect(Collectors.toList()));
////		assertEquals(1, service.getUserbyAddress(address).size());
////	}
////
////	@Test
////	public void saveUserTest() {
////		User user = new User(999, "Pranya", 33, "Pune");
////		when(repository.save(user)).thenReturn(user);
////		assertEquals(user, service.addUser(user));
////	}
////
////	@Test
////	public void deleteUserTest() {
////		User user = new User(999, "Pranya", 33, "Pune");
////		service.deleteUser(user);
////		verify(repository, times(1)).delete(user);
////	}
//
//}
