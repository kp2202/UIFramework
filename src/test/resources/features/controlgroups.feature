@jqueryui @controlpagegroup
Feature: verify Control groups

  Background: : Verify that user can move to Demos page
    Given User is on jQueryUI Home Page
    When User clicks on controlgroup link
    Then User is redirected to Jquery UI controlgroup page

  Scenario Outline: Check if control group is working properly or not
    Given User selects rental car as "<CarType>"
    And User selects car transmission as "<CarTransmission>"
    And User selects car insurance
    And User selects <NumberOfCars> as number of cars
    Then User clicks on book now.

    Examples: 
      | CarType | CarTransmission | NumberOfCars |
      | SUV     | Automatic       |            2 |
