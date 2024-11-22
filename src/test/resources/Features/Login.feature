Feature: Vaidation of login

  @TC2
  Scenario: Valid login Credentials
    Given user is on homepage to login
    Then user login with valid credentials
    Then verify user should land on homepage
    And close the Browser
