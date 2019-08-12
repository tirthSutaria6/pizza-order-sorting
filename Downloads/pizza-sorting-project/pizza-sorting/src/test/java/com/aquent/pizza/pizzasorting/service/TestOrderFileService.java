package com.aquent.pizza.pizzasorting.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.aquent.pizza.pizzasorting.model.Order;

public class TestOrderFileService {

	@Autowired
	private OrderFileService sut = new OrderFileServiceImpl();
	private String filePath = "src/test/resources/sample_data_ordered.txt";

	@Test
	public void test() throws Exception {
		List<Order> list = new ArrayList<Order>();
		List<String> name = new ArrayList<String>();
		List<String> date = new ArrayList<String>();
		name = this.getName();
		date = this.getDate();
		list = sut.readFile(filePath);
		for (int i = 0; i < list.size(); i++) {
			assertEquals(name.get(i), list.get(i).getName());
			assertEquals(date.get(i), list.get(i).getDate().toString());
		}
	}

	private List<String> getName() {
		List<String> name = new ArrayList<String>();
		name.add("Meat");
		name.add("pizza");
		name.add("p1zza");
		name.add("Bread");
		name.add("Pizza");
		name.add("bread");
		name.add("bread");
		name.add("meatMeaT");
		name.add("VegVeg");
		return name;
	}

	private List<String> getDate() {
		List<String> date = new ArrayList<String>();
		date.add("Sat Sep 23 09:24:47 CDT 2017");
		date.add("Thu Oct 27 09:24:47 CDT 2016");
		date.add("Wed Oct 26 09:24:47 CDT 2016");
		date.add("Tue Oct 25 09:24:47 CDT 2016");
		date.add("Mon Oct 24 09:24:47 CDT 2016");
		date.add("Sun Oct 23 09:24:47 CDT 2016");
		date.add("Fri Sep 23 09:24:47 CDT 2016");
		date.add("Mon Sep 19 09:24:47 CDT 2016");
		date.add("Mon Sep 19 09:24:47 CDT 2016");
		return date;
	}
}
