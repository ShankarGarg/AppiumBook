Feature: iOS Test App
    In order to test sample ios app
    As a product owner
    I want to specify generic scenarios
 
Scenario: Calculate Sum
    Given user is on Application Home Page
    When user enters "4" in first field
    And user enters "5" in second field
    And clicks on Compute Sum
    Then user sees computed sum as "9"