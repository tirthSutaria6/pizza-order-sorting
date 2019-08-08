package com.aquent.pizza.pizzasorting.service;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aquent.pizza.pizzasorting.model.Order;

@Service
public class OrderFileServiceImpl implements OrderFileService {

	// @Autowired
	// private FileInputStream fileInputStream;
	// @Autowired
	// private DataInputStream dataInputStream;
	// @Autowired
	// private BufferedReader bufferedReader;

	@SuppressWarnings("resource")
	@Override
	public List<Order> readFile(String filePath) throws Exception {

		String data;
		List<Order> orders = new ArrayList<Order>();
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			DataInputStream dataInputStream = new DataInputStream(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));
			while ((data = bufferedReader.readLine()) != null) {

				String[] fileData = data.split("\\s+");
				Order order = new Order(fileData[0], new Date(Long.parseLong(fileData[1]) * 1000));
				orders.add(order);
			}
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		return orders;

	}

	@Override
	public List<Order> sortData(List<Order> list) {

		Collections.sort(list);
		return list;

	}

	@Override
	public void writeFile(List<Order> orders) throws Exception {

		PrintWriter writer;
		try {
			writer = new PrintWriter("sorted_order.txt", "UTF-8");
			String formater = "%-30.30s  %-30.30s%n";
			StringBuffer data = new StringBuffer();

			data.append(String.format(formater, "Order", "Time"));
			for (Order order : orders) {

				data.append(String.format(formater, order.getName(), order.getDate().toString()));

			}
			writer.println(data.toString());
			writer.close();
		} catch (FileNotFoundException e) {
			throw e;
		} catch (UnsupportedEncodingException e) {
			throw e;
		}

	}

}
