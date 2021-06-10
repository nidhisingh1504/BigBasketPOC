#Big Basket Feature Definition Template

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
