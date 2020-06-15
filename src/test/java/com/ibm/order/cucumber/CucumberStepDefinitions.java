package com.ibm.order.cucumber;


import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.springframework.web.client.RestTemplate;

import com.ibm.order.model.Order;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberStepDefinitions {
	
			Order order;
			private RestTemplate restTemplate = new RestTemplate();


		   @Given("^Order service and database are running  and Order DB has orderNumber, (.*?)$")
		   public void orderServiceRunningOrderNumberinOrderDB(String orderNumber) throws Exception {
		   }

		   @When("^Order mS receives request for orderNumber, (.*?)$")
		   public void orderServiceReceivesGetOrderRequest(String orderNumber) throws IOException {
			   String orderServiceRESTRequest = "http://localhost:9743/order/order/" + orderNumber;
			   this.order = this.restTemplate.getForObject(orderServiceRESTRequest, Order.class);
		   }

		   @Then("^Order information should be displayed for orderNumber, (.*?)$")
		   public void orderServiceReturnOrderInformation(String orderNumber) {
			   assertNotNull("order info should not be null", this.order);
		   }
		

}

