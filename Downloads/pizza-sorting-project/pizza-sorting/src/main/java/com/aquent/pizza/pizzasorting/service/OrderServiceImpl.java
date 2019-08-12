package com.aquent.pizza.pizzasorting.service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.aquent.pizza.pizzasorting.model.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderFileService fileService;

	@Value("${file-path}")
	private String filePath;

	@Override
	public void sortOrder() throws IOException {

		List<Order> orders = fileService.readFile(filePath);
		orders = this.sortData(orders);
		fileService.writeFile(orders);

	}

	List<Order> sortData(List<Order> list) {

		Comparator<Order> comp = (o1, o2) -> o1.getDate().compareTo(o2.getDate());
		list.sort(comp);
		return list;

	}

}
