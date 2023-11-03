Feature: Proceed to checkout

  @PlaceOrder
  Scenario: Add items to the cart and proceed to the checkout
    Given User is on GreenCart landing page
    And User searched with shortname Tom and extracted actual name of product
    When User Adds 4 items to the cart
    Then Validate product name in Checkout Page matches with Landing Page
    And verify user has the ability to enter promo code and place the order
