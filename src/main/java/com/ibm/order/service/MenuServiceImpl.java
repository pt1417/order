package com.ibm.order.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.order.model.OrderInput;
import com.ibm.order.model.Order;
import com.ibm.order.model.OrderInputMenuItem;

import com.ibm.order.model.MenuItem;
import com.ibm.order.model.OrderMenuItem;

import com.ibm.order.repo.OrderRepo;
import com.ibm.order.endpoint.MenuEndpoint;
import com.ibm.order.util.GenerateUniqueID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class MenuServiceImpl implements OrderService {
	
	private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private OrderRepo orderRepo;
	
	
	@Autowired
	private MenuEndpoint menuEndpoint;
	
	@Override
	public Order getOrder(String orderNumber) {
		
		logger.info("Entered OrderServiceImpl.getOrder().  orderNumber=" + orderNumber);
		
		Order order = null;
		
		order = this.orderRepo.findByOrderNumber(orderNumber);
		
		logger.info("Leaving OrderServiceImpl.getOrder().  order=" + order);
		
		return order;
	}
	
	@Override
	public List<Order> getOrders() {
		
		List<Order> orders = null;
		
		orders = this.orderRepo.findAll();
		
		return orders;
	}
	
	@Override
	public Order addOrder(OrderInput orderInput) {
		
		Order order = new Order();
		
		List<OrderMenuItem> orderMenuItems = new ArrayList<OrderMenuItem>();
		order.setOrderMenuItems(orderMenuItems);
		
		order.setCustomerNumber(orderInput.getCustomerNumber());
		OrderInputMenuItem orderInputMenuItem = null;
		OrderMenuItem orderMenuItem = null;
		
		// Data returned from menu service
		MenuItem menuItem = null;
		
		double orderPrice = 0.0;
		//int remainingNumAvailable = 0;
		// Iterate through each of the OrderInputMenuItems and get the data
		// from Menu service.
		// FOR DISCUSSION ONLY: Performance can be improved if we add an API method to menu service
		// to retrieve a list of menu items given a list of menu item numbers
		Iterator<OrderInputMenuItem> iter = orderInput.getOrderInputMenuItems().iterator();
		while (iter.hasNext()) {
			
			orderInputMenuItem = iter.next();
			
			// Order doesn't have the menu data (price, num available, description) - menu service has it
			menuItem = this.menuEndpoint.getMenuItem(orderInputMenuItem.getMenuItemNumber());

			// ADD FOR LAB: Check if there are num available first
			//System.out.println("NumAvailable: " + menuItem.getNumAvailable());
			logger.info("!!!! NumAvailable: " + menuItem.getNumAvailable());
			if (orderInputMenuItem.getQuantityOfMenuItem() <= menuItem.getNumAvailable()) {
			orderMenuItem = new OrderMenuItem();
			orderMenuItem.setMenuItemNumber(orderInputMenuItem.getMenuItemNumber());
			orderMenuItem.setMenuName(menuItem.getName());
			orderMenuItem.setQuantityOfMenuItem(orderInputMenuItem.getQuantityOfMenuItem());
			orderMenuItem.setPrice(menuItem.getPrice());
			
			// Order object's private orderMenuItems variable has a reference to this orderMenuItems
			orderMenuItems.add(orderMenuItem);
			
			orderPrice = orderPrice + menuItem.getPrice() * (orderInputMenuItem.getQuantityOfMenuItem());
			//remainingNumAvailable = menuItem.getNumAvailable() - orderInputMenuItem.getQuantityOfMenuItem();
			//logger.info("!!!! remainingNumAvailable: " + remainingNumAvailable);
			
			} else {
				return null;
			}
			// We do not have to tell menu service to update the number available
		}
		//menuItem.setNumAvailable(remainingNumAvailable);
		//this.menuRepo.update({menuItemNumber: orderInputMenuItem.getMenuItemNumber()},{$set: { numAvailable : remainingNumAvailable} });
		order.setOrderPrice(orderPrice);
		
		// When we insert the Order into MongoDB's Order database's Order collection,
		// MongoDB will generate a unique ID field.  We could use that for the unique
		// Order number ... this makes us dependent on using a db and the repo layer for
		// generating the unique order number.  We're going to do this but ... discussion 
		// on this is helpful.
		
		// See following for why using UUIDs may not be a good idea:
		// https://www.callicoder.com/distributed-unique-id-sequence-number-generator/
		String orderNumber = GenerateUniqueID.GenerateID("ORDER");
		order.setOrderNumber(orderNumber);
		
		order = this.orderRepo.insert(order);
		
		return order;
	}
}
