#Author: your.email@your.domain.com
@tag
Feature: Place an order from a menu
  	As a restaurant cashier
			I want to retrieve existing order using orderNumber
			so that I can read back the information to customer

  @tag1
  Scenario Outline: get an existing order record from Order
    Given Order service and database are running  and Order DB has orderNumber, <orderNumber>
    When Order mS receives request for orderNumber, <orderNumber>
    Then Order information should be displayed for orderNumber, <orderNumber>

    Examples: 
      |orderNumber| 
      |ORDER123|  
