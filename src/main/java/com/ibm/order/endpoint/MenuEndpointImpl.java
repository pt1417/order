package com.ibm.order.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ibm.order.model.MenuItem;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class MenuEndpointImpl implements MenuEndpoint {
	
	private RestTemplate restTemplate;
	@Value("${menuservice.endpoint}")
	private String menuServiceEndpoint;
	private final Logger logger = LoggerFactory.getLogger(MenuEndpointImpl.class);

	public MenuEndpointImpl() {
		this.restTemplate = new RestTemplate();
	}
	
	@Override
	   @HystrixCommand(fallbackMethod = "getMenuItem_fallBack", commandKey = "endpointGetMenuItem", commandProperties = {
	      @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
	      @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
	      @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
	      @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "75") })
	public MenuItem getMenuItem(String menuItemNumber) {
		
		MenuItem menuItem = null;
		
		String menuServiceURL = "http://" + menuServiceEndpoint + "/menu/menu/" + menuItemNumber;
		logger.info("********** Entered MenuEndpointImpl.getMenuItem(). menuItemNumber=["+ menuItemNumber + "]");
		menuItem = this.restTemplate.getForObject(menuServiceURL, MenuItem.class);
		
		return menuItem;
	}
	public MenuItem getMenuItem_fallBack(String menuItemNumber) {
		MenuItem menuItem = null;
		logger.warn("!!!!!!!!!! IN FALLBACK.  getMenuItem_fallBack menuItemNumber=" + menuItemNumber);
		menuItem = new MenuItem("M123", "Entree", "Salmon Dinner", "CACHED Menu Item", 8, 12.95);
		
		return menuItem;
	}
}