package com.team4.ordermanagement.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team4.ordermanagement.order.dto.OrderDetailsDTO;
import com.team4.ordermanagement.order.dto.ProductsOrderedDTO;
import com.team4.ordermanagement.order.service.OrderService;

@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class OrderController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public OrderService orderService;
	                                 
	@PostMapping(value = "orders/orderdetails/{orderId}",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createCustomer(@RequestBody OrderDetailsDTO orderDTO) {
		logger.info("Creation request for customer {}", orderDTO);
		orderService.createCustomer(orderDTO);
	}
	
	@GetMapping(value = "/orderdetails",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDetailsDTO> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	
	@GetMapping(value= "/orderdetails/{orderid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDetailsDTO getSpecificOrder(@PathVariable Integer orderid) {
		return orderService.getSpecificOrders(orderid);
		
	}
	@GetMapping(value = "/productsordered",  produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductsOrderedDTO> getAllProducts() {
		return orderService.getAllProduct();
	}
	
}
