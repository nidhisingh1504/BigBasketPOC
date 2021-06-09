Feature: Search in BigBasket
Scenario: Search Soap in BigBasket page
Given BigBasket page URL is given
When User has given "Soap" on Search button and click on Search button
Then User get search result
And "Soap" Search is there
And Test are "Passed"

Scenario: Search Lux in BigBasket
Given BigBasket page URL is given
When User has given "Lux" on Search button and click on Search button
Then User get search result
And "Lux" Search is there
And Test are "Failed"