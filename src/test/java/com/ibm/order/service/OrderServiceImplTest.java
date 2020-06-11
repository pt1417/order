package com.ibm.order.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ibm.order.model.Order;
import com.ibm.order.model.OrderMenuItem;
import com.ibm.order.repo.OrderRepo;

class OrderServiceImplTest {

	@Mock
	//private MenuEndpoint menuEndpoint;
	private OrderRepo orderRepo;
	
	@InjectMocks
	private OrderServiceImpl menuService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@DisplayName("Test getOrder with valid orderNumber")
	@Test
	public void testGetOrderExistingOrderNumber() {
		//Given
		String orderNumber = "ORDER123";
		String customerNumber = "CUST456";
		Order mockedOrder = null;
		List<OrderMenuItem> orderMenuItems = new ArrayList<OrderMenuItem>();
		//public OrderMenuItem(String menuItemNumber, int quantityOfMenuItem, String menuName, double price) {
		orderMenuItems.add(new OrderMenuItem("MENU-112",2,"Salmon",12.95));
		//public Order(String customerNumber, String orderNumber, List<OrderMenuItem> orderMenuItems, double orderPrice) {
		mockedOrder = new Order(customerNumber,orderNumber,orderMenuItems,31.85);

		//when
		when(orderRepo.findByOrderNumber(orderNumber)).thenReturn(mockedOrder);
	
		Order order = menuService.getOrder(orderNumber);
		
		//Then
		assertNotNull(order, "order should not be null");
		assertEquals(order, mockedOrder, "order should be the same as: " + mockedOrder);
		
		verify(orderRepo).findByOrderNumber(orderNumber);
	}
	
	
	@AfterEach
	void afterEach() {
		System.out.println("**--- Executed after each test method in this class --**");
	}
}
