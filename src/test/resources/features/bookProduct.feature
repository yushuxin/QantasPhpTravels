Feature:  User are able to book hotels, flights or tours

  Scenario Outline: Successful book a hotel
    Given I have logged in
    And I am on home page
    When I searched hotels in <city>
    And I booked a <roomName> in <hotelName>
    Then The hotel booking should be in my account page

    Examples:
      | city     | roomName                | hotelName                |
      | "London" | "One-Bedroom Apartment" | "Grand Plaza Apartments" |
      | "London" | "One-Bedroom Apartment" | "AAAAA hotel"            |