Feature: HealthCheck BFF Endpoints

  Automate BFF endpoints

  Scenario Outline: Review status of microservices in the environment
    Given There is an endpoint <path> to know the health of the deployed microservices.
    When a get request is made on the endpoint <path>.
    Then You get the code of 200.
    And message that says <messageResponse>.
    Examples:
      | path    | messageResponse |
      | "/ping" | pong            |