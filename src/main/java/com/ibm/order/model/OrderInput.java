package com.ibm.order.model;

import java.util.List;

public class OrderInput {

	private String customerNumber;
	private List<OrderInputMenuItem> orderInputMenuItems;
	
	
	public OrderInput() {
		super();
	}
	
	public OrderInput(String customerNumber, List<OrderInputMenuItem> orderInputMenuItems) {
		super();
		this.customerNumber = customerNumber;
		this.orderInputMenuItems = orderInputMenuItems;
	}
	
	public String getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}
	public List<OrderInputMenuItem> getOrderInputMenuItems() {
		return orderInputMenuItems;
	}
	public void setOrderInputMenuItems(List<OrderInputMenuItem> orderInputMenuItems) {
		this.orderInputMenuItems = orderInputMenuItems;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerNumber == null) ? 0 : customerNumber.hashCode());
		result = prime * result + ((orderInputMenuItems == null) ? 0 : orderInputMenuItems.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderInput other = (OrderInput) obj;
		if (customerNumber == null) {
			if (other.customerNumber != null)
				return false;
		} else if (!customerNumber.equals(other.customerNumber))
			return false;
		if (orderInputMenuItems == null) {
			if (other.orderInputMenuItems != null)
				return false;
		} else if (!orderInputMenuItems.equals(other.orderInputMenuItems))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderInput [customerNumber=" + customerNumber + ", orderInputMenuItems=" + orderInputMenuItems + "]";
	}
}
