package com.aquent.pizza.pizzasorting.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.aquent.pizza.pizzasorting.model.Order;

public interface OrderFileService {

	public List<Order> readFile(String filePath) throws IOException, FileNotFoundException;

	public void writeFile(List<Order> orders) throws FileNotFoundException, UnsupportedEncodingException;

}
