package com.aquent.pizza.pizzasorting.service;

import java.util.List;

import com.aquent.pizza.pizzasorting.model.Order;

public interface OrderFileService {

	public List<Order> readFile(String filePath) throws Exception;

	public List<Order> sortData(List<Order> orders);

	public void writeFile(List<Order> orders) throws Exception;

}
