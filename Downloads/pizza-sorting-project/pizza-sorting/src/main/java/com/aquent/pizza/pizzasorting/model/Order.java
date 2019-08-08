package com.aquent.pizza.pizzasorting.model;

import java.util.Date;

public class Order implements Comparable<Order> {

	private String name;
	private Date date;

	public Order(String name, Date date) {
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Order o) {
		if (o.getDate() == null || o.getDate() == null) {
			return 0;
		}
		return getDate().compareTo(o.getDate());
	}

}
