Feature: Login test
  As a common user
  I want to login into system
  So that I input my credentials

  Background: I set up my env
    Given I open the Login page

@run
  Scenario: Login test positive scenario
    When I enter 'anton.makovetskyi@gmail.com' my email on the Login page
    And I enter 'Art123456!' my password on the Login page
    And I click on submit button on the Login page
    Then The main page is displayed


