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
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.aquent.pizza.pizzasorting.model.Order;

@Service
public class OrderFileServiceImpl implements OrderFileService {
	
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(OrderFileServiceImpl.class);

	@Override
	public List<Order> readFile(String filePath) throws IOException, FileNotFoundException {

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
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			LOG.info(e.toString());
			throw e;
		} catch (IOException e) {
			LOG.info(e.toString());
			throw e;
		}
		return orders;

	}

	@Override
	public void writeFile(List<Order> orders) throws FileNotFoundException, UnsupportedEncodingException{

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
			LOG.info(e.toString());
			throw e;
		} catch (UnsupportedEncodingException e) {
			LOG.info(e.toString());
			throw e;
		}

	}

}
