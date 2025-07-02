@ContactForm
Feature: Contact Us Form
    @contactPage @smoke
  Scenario: Submitting the Contact Us form with valid inputs
    Given I am on the Contact Us page
    When I enter "John Doe" into the name field
    And I enter "john.doe@example.com" into the email field
    And I enter "07788889999" into the phone field
    And I enter "Xaxa's Wedding" into the enquiry field
    And I enter "Hello, this is a test message." into the message field
    And I submit the contact form
    Then I should see a confirmation message
