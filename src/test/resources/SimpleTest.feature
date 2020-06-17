Feature: New product search and contact us
  Scenario: check whether the new products are available and contact us

    Given I am in home page
    When  I click on New Products from the menu
    Then  I need to go to New products page and see the available products
    When  I click on Contact Us page link from the menu
    Then  Contact Us page should be open
    When  I enter name 'Tester'
    And   I enter email 'user3@testing.com'
    And   I enter the 'I would like to know the upcoming products'
    And   I click on Submit button
    Then  I should see confirmation message "Your enquiry has been successfully sent to the store owner."
