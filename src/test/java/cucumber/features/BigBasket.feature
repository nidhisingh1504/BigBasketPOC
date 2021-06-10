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

@tag
Feature: Search in BigBasket

@tag1
Scenario: Search Books BigBasket page
Given BigBasket page URL is given
When User has given "Books" on search box and click on search button
Then User get "Books" in search result
And Test are "Passed"

@tag2
Scenario: Search Soap in BigBasket page
Given BigBasket page URL is given
When User has given "Soap" on search box and click on search button
Then User get "Soap" in search result
And Test are "Passed"
