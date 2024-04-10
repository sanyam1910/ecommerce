@tag
Feature: Purchase the Product from Ecommerce site

Background:
Given I landed on Ecommerce Page

@tag2
  Scenario Outline: Place the Order
    Given I logged in with username <UserName> and Password <Password>
    When I add Product <ProductName> to cart
    And Checkout and Submit the Order <ProductName>
    Then "Thankyou for the Order." message is displayed on the confirmation page 

    Examples: 
      | UserName  							| Password 	| ProductName  	|
      | shamjijinjala@gmail.com | Showit@12 | ZARA COAT 3		 |
      |	Showit@gmail.com 				|	Showit@12 | ADIDAS ORIGINAL|
      
