Feature: Home Page Verification

  Scenario: Verify homepage loads correctly
    Given I am on the home page
    Then the site logo should be visible
    And the hero image should be visible
    And the footer should be visible

  Scenario: Navigate to Contact page from home
    Given I am on the home page
    When I click on the Contact menu
    Then I should be on the Contact page
