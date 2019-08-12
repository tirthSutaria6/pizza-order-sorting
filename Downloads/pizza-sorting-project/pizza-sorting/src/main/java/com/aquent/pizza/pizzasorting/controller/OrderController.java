package com.aquent.pizza.pizzasorting.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aquent.pizza.pizzasorting.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping("/sort")
	public String sort() {
		try {
			orderService.sortOrder();
		} catch (IOException e) {
			return "something went wrong.";
		}
		return "success.";

	}

}
