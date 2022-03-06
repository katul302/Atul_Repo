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

Feature: Portal Login

Background: 
Given Validate the Browser
When Browser is triggred
Then Check if Browser is started

@PortalTest
Scenario: Case One
Given User is on NetBanking landing page
When User login with username and password
Then Home page is populated
And Cards are displayed

#Example of regular expression
@PortalTest
Scenario: Case Two
Given User is on NetBanking landing page
When User login with "john" and "12345"
Then Home page is populated
And Cards displayed are "true"

@PortalTest
Scenario: Case Three
Given User is on NetBanking landing page
When User login with "john" and "12345"
Then Home page is populated
And Cards displayed are "false"


#Example of datatable for Datadriving test
@PortalTest
Scenario: Case Four
Given User is on NetBanking landing page
When User sign up with following details
| jenny | abcd | john@abcd.com | India| 7689499 |
| JERRY | TEST | john@abcd.com | India| 7689499 |
Then Home page is populated
And Cards displayed are "false"

#Example of Parametrization
#Instead of Scenario we havt to use Scenario outline.

@PortalTest
Scenario Outline: Case 5
Given User is on NetBanking landing page
When User log with <UserName> and <Password>
Then Home page is populated
And Cards displayed are "true"

Examples: 
|UserName|Password|
|User1|Pass1			|
|User2|Pass2			|
|User3|Pass3			|



