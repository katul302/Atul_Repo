#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Search and Place order for Veggie
@End2End
Scenario: Click and Add to Cart
Given User is on GreenCart landing page
When User click on add to cart 
And Added item to Cart
And User proceed to Checkout page
Then User should apply the promo code 
And Place the order
And User should choose the county
And Select the radio button
And User should be able Proceed