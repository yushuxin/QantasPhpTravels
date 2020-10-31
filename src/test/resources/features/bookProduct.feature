Feature:  User are able to book hotels, flights or tours

  Scenario: Successful book a hotel
    Given I have logged in
    And I am on home page
    When I searched hotels
    And I booked a "One-Bedroom Apartment" in "Grand Plaza Apartments"
    Then The hotel booking should be in my account page