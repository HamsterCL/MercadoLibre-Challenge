Feature: Persons BFF Endpoints

  Automate BFF endpoints

  Scenario Outline: List of people

    Given I have an endpoint "/bff/persons" of type GET to list all the people type data that is persisted.
    When I create a get request for the endpoint "/bff/persons", to get the list of people.
    Then should return response code 200 for people query
    And list of person with: id <id>, first name <first_name>, last name <last_name>, age <age>, id country <country_id>

    Examples:
      | id | first_name    | last_name        | age | country_id |
      | 1  | Lionel Andres | Messi            | 36  | 1          |
      | 2  | Ronaldo       | de Assis Moreira | 43  | 2          |
      | 3  | Luis Alberto  | Suárez Díaz      | 36  | 3          |
      | 4  | James David   | Rodríguez Rubio  | 32  | 4          |


  Scenario Outline: Persistence of a new person
    Given I have an endpoint "/bff/persons" of type POST to allow or create a new person in the system
    When I create a post request to the "/bff/persons" endpoint to persist the creation of a new person, with a following data: first name <first_name>, last name <last_name>, age <age>, id country <country_id>
    Then should return response code 201 for creation.
    And returns the created person object: id <id>, first name <first_name>, last name <last_name>, age <age>, id country <country_id>

    Examples:
      | id | first_name    | last_name     | age | country_id |
      | 5  | Edson Arantes | do Nascimento | 82  | 2          |

  Scenario Outline: Persistence of a new person, empty data
    Given I have an endpoint "/bff/persons" of type POST to allow or create a new person in the system
    When I create a post request on the "/bff/persons" endpoint to persist the creation of a new person, with all data set to empty: first name <first_name>, last name <last_name>, age <age>, country id <country_id>
    Then should return response code 400 for creation.

    Examples:
      | first_name | last_name | age | country_id |
      | [blank]    | [blank]   | 0   | 0          |

  Scenario Outline: Persistence of a new person, validate country_id
    Given I have an endpoint "/bff/persons" of type POST to allow or create a new person in the system
    When I create a post request on the "/bff/persons" endpoint to persist the creation of a new person, with the country_id attribute that is not persisted: first name <first_name>, last name <last_name>, age <age>, country id <country_id>
    Then should return response code 400 for creation.
    And and an error message that says: "country_id does not exist in our records"

    Examples:
      | first_name       | last_name | age | country_id |
      | Alexis Alejandro | Sánchez   | 36  | 5          |

  Scenario Outline: Persistence of a new person, validate data
    Given I have an endpoint "/bff/persons" of type POST to allow or create a new person in the system
    When I create a post request on the "/bff/persons" endpoint to persist the creation of a new person, with all data set to empty: first name <first_name>, last name <last_name>, age <age>, country id <country_id>
    Then should return response code 400 for creation.
    And and an error message that says: "person with same first name and last name already exists"

    Examples:
      | first_name    | last_name | age | country_id |
      | Lionel Andres | Messi     | 36  | 1          |


  Scenario Outline: Delete a person from the application
    Given I have an endpoint "/bff/persons" of type DELETE to allow deleting a person that is persisted in the database.
    When When I create a delete request for the endpoint "/bff/persons", in which I must provide the id <id> of the person I will delete by query.
    Then should return response code 204 when deleting.
    And returns the following message: <message>

    Examples:
      | id | message                     |
      | 5  | Person deleted successfully |
      | 6  | Person deleted successfully |
      | 7  | Person deleted successfully |

  Scenario Outline: Delete a person from the application, with non-numeric ID
    Given I have an endpoint "/bff/persons" of type DELETE to allow deleting a person that is persisted in the database.
    When When I create a delete request for the endpoint "/bff/persons", in which I must provide the id <id> of the person I will delete by query.
    Then should return response code 400 when deleting.
    And returns the following error message: <message>

    Examples:
      | id | message    |
      | A  | Invalid ID |