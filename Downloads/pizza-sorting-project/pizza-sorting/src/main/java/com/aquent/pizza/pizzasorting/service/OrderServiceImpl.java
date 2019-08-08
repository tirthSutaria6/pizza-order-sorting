package com.aquent.pizza.pizzasorting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aquent.pizza.pizzasorting.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	private OrderFileService fileService;
	
	@Value("${file-path}")
	private String filePath;
	
	@Autowired
	public OrderServiceImpl(OrderFileService fileService) {
		this.fileService = fileService;
	}

	@Override
	public void sortOrder() throws Exception {

		List<Order> orders=fileService.readFile(filePath);
		orders=fileService.sortData(orders);
		fileService.writeFile(orders);

	}
	
	

}
