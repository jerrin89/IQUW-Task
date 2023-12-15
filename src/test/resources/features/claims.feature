Feature: Windscreen Repairs Booking

  @regression
  @smokeTest
  Scenario: Verify Customer can book online claim for Windscreen repairs with invalid policy details
    Given I am on the ers homepage
    When I click 'Claims' from the main navigation
    And I click on the 'Book online' option for the Windscreen repair
    Then I navigated to the "https://www.nationalwindscreens.co.uk/ers"
    And I fill the online appoint form
      | Field          | Value          |
      | vehicle_vrm    | DA69UHH        |
      | customer_name  | Test123        |
      | customer_phone | 07429023086    |
      | customer_email | john@gmail.com |
    And I select the date and click next button
    Then I should get 'Policy not found' message


