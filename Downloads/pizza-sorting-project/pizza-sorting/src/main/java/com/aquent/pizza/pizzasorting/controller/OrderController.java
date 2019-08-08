package com.aquent.pizza.pizzasorting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquent.pizza.pizzasorting.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	
	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}


	@RequestMapping("/sort")
	public String sort() {
		try {
		orderService.sortOrder();
		}
		catch(Exception e) {
			return "something went wrong.";
		}
		return "success.";
		
	}

}
