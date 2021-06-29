//package com.api2.controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.sql.Date;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.api2.model.Product;
//import com.api2.service.ProductService;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//public class Api2ControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ProductService productService;
//
//
//    @InjectMocks
//    private Api2Controller controller;
//
//
////    @Before
////    public void setUp() throws Exception {
////
////        MockitoAnnotations.initMocks(this);
////        mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();
////
////        user = new User();
////        user.setUserId("Jhon123");
////        user.setFirstName("Jhon");
////        user.setLastName("Smith");
////        user.setUserPassword("123456");
////        user.setUserRole("Admin");
////        user.setUserAddedDate(new Date());
////
////
////    }
//    
//    public static Product getProduct()
//    {
//    	return new Product("G6","Noodles",Date.valueOf("2021-12-21"));
//    }
//    
////	@Test
////	public void getProductByIdTest()
////	{	
////		 List<Employee> employee = null;
////			when(service.getallEmployee()).thenReturn(employee);
////			mock.perform(MockMvcRequestBuilders.get("/employee/Employee/1").contentType(MediaType.APPLICATION_JSON)
////					.content(new Gson().toJson(getEmployee()))).andExpect(MockMvcResultMatchers.status().isOk())
////					.andDo(MockMvcResultHandlers.print());
////	}
//	@Test
//	public void getProductByIdTest() {
//	String product = "pr1";
//	when(repository.findByProductId(product))
//	.thenReturn(Stream.of(new Product("pr1", "Rice", Date.valueOf("2021-12-20") ))));
//	assertEquals(1, service.getProductById(product).size());
//	}
//
//}
