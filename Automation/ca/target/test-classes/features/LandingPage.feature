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


Feature: Landing Page Verification

@FunctionalTest
Scenario: Verify Logo of Landing Page
Given User launch the URL
When User is on landing page
Then Get the logo
And Verify logo title

@FunctionalTest
Scenario: Verify sing link functionality
Given User launch the URL
When User click on sign link
Then User should land on AUTHENTICATION screen

@FunctionalTest
Scenario: Count link on the landing page
Given User launch the URL
When User is on landing page
Then Get link count on the landing page
  