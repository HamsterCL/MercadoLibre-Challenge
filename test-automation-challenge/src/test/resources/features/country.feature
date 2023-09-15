Feature: Country BFF Endpoints

  Automate BFF endpoints

  Scenario Outline: List of countries

    Given I have an endpoint "/bff/countries" of type GET to list all the countries type data that is persisted.
    When I create a get request for the endpoint "/bff/countries", to get the list of countries.
    Then should return response code 200 for country query
    And list of country with: id <id>, name <name>

    Examples:
      | id | name      |
      | 1  | Argentina |
      | 2  | Brazil    |
      | 3  | Colombia  |
      | 4  | Uruguay   |