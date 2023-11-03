Feature: Search and Place the Order for Products

  @Offers
  Scenario Outline: Search Experience for Product Search in both Home and Offers page
    Given User is on GreenCart landing page
    When User searched with shortname <Name> and extracted actual name of product
    Then User searched for <Name> shortname in offers page
    And Validate product name in Offers Page matches with Landing Page

    Examples:
      | Name |
      | Tom  |
      | Beet |