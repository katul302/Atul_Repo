Feature: Search and Place order for Veggie
@SeleniumTest
Scenario: Search for item and validate result
Given User is on GreenCart landing page
When User search for "Cucumber" Vegetable 
Then "Cucumber" result are displayed

@SeleniumTest
Scenario: Search for item and then move to checkout page
Given User is on GreenCart landing page
When User search for "Brinjal" Vegetable 
And Added item to Cart
And User proceed to Checkout page
Then Verify selected "Brinjal" items are displayed in checkout page

@SeleniumTest
Scenario: Search for item and then move to checkout page
Given User is on GreenCart landing page
When User search for "Beetroot" Vegetable 
And Added item to Cart
And User proceed to Checkout page
Then User should apply the promo code 
And Place the order
And User should choose the county
And Select the radio button
And User should be able Proceed

@ParameterTest
Scenario Outline: Parameterizing 
Given User is on GreenCart landing page
When User search for <Veggie> Vegetables
And Added item to Cart
And User proceed to Checkout page
Then User should apply the promo code 
And Place the order
And User should choose the county
And Select the radio button
And User should be able Proceed

Examples: 
|Veggie|
|Brocolli|
|Carrot|


