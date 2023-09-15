Feature: Application person page

  Automate WebSite testing

  Scenario: Creation of a person via website
    Given that Administrator visits the Create Person page to register a person
    When You must complete all the information on the form, first fill out the first name Diego,
    And then continue with the last name Maradona field
    And continue with the age 60 field
    And finally, the country Argentina field
    Then you should be able to register a new person

  Scenario: Administrator needs to check if Diego Maradona is in the system
    Given has a list of people in his system and checks it by going to the world view page
    When to add Diego Maradona
    Then 2 people should appear in the Argentina section of the page.

