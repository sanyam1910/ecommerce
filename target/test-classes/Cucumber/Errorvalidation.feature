@tag3
Feature: Login Validation

Background:
Given I landed on Ecommerce Page

@Errorvalidation
  Scenario Outline: Error Validation
    Given I logged in with username <UserName> and Password <Password>
   

    Examples: 
      | UserName  							| Password 	| 
      | shamjijinjala@gmail.com | Showit@123|