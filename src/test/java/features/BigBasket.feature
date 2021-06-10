@tag
Feature: Search in BigBasket

@tag1
Scenario: Search in BigBasket page
Given BigBasket page URL is given
When User has given "Books" on search box and click on search button
Then User get "Books" in search result
And Test are "Passed"
