Feature: End to end scenario Checkout

  Scenario: create an order as an existing customer

    Given I am in home page
    When  I add an item into the cart
    And   I go to cart page
    And   I checkout from cart
    And   I Login as an existing customer
    And   I set billing address
    And   I set shipping address
    And   I set shipping method
    And   I set  payment method
    And   I continue in payment information
    And   I confirm the order
    Then  the order confirmation screen with message is shown "Your order has been successfully processed!"