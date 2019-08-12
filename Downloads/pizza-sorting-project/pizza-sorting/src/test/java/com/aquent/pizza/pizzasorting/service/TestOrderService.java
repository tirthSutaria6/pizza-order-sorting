package com.aquent.pizza.pizzasorting.service;

import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.aquent.pizza.pizzasorting.model.Order;

public class TestOrderService {

	@InjectMocks
	private OrderService sut = new OrderServiceImpl();
	@Mock
	private OrderFileService fileService;
	@Captor
	ArgumentCaptor<List<Order>> ac;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Mockito.doReturn(this.getList()).when(fileService).readFile("src/main/resources/sample_data_ordered.txt");

	}

	@Test
	public void test() throws IOException {

		sut.sortOrder();
		verify(fileService).writeFile(ac.capture());

	}

	@SuppressWarnings("deprecation")
	public List<Order> getList() {
		List<Order> list = new ArrayList<Order>();
		Order o1 = new Order("p1", new Date(2019 - 1900, 8, 23, 20, 25, 25));
		Order o2 = new Order("p2", new Date(2019 - 1900, 8, 24, 20, 25, 33));
		Order o3 = new Order("p3", new Date(2019 - 1900, 8, 23, 20, 30, 40));
		list.add(o1);
		list.add(o2);
		list.add(o3);
		return list;
	}

	@SuppressWarnings("deprecation")
	public List<Order> getSortedList() {
		List<Order> list = new ArrayList<Order>();
		Order o1 = new Order("p1", new Date(2019 - 1900, 8, 23, 20, 25, 25));
		Order o3 = new Order("p2", new Date(2019 - 1900, 8, 24, 20, 25, 33));
		Order o2 = new Order("p3", new Date(2019 - 1900, 8, 23, 20, 30, 40));
		list.add(o1);
		list.add(o2);
		list.add(o3);
		return list;
	}
}
