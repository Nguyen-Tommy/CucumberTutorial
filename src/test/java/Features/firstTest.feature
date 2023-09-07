Feature: Web Login

  Scenario: User should be able to login with valid credentials
    Given the user is on the login page
    When the user enter valid credentials
      | username | password      |
      | admin    | adminpassword |
    And hits the enter key
    Then the user should be logged in successfully
