@tag
Feature: Search in BigBasket

@tag1
Scenario: Search in BigBasket page
Given BigBasket page URL is given
When User has given <search> on search box and click on search button
Then User get <search> in search result

Examples: 
      | search |
      | Books | 
      | Soap | 
