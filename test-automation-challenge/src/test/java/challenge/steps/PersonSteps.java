package challenge.steps;

import cl.mercadolibre.automationChallenge.model.Person;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PersonSteps {
    private RequestSpecification request;
    private Response response;

    private final Properties prop = new Properties();

    public PersonSteps() {
        try (InputStream input = PersonSteps.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find config.properties");
                return;
            }
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //

    @Given("I have an endpoint {string} of type GET to list all the people type data that is persisted.")
    public void iHaveAnEndpointToListAllThePeopleTypeDataThatIsPersisted(String path) {
        try {
            RestAssured.baseURI = prop.getProperty("BASE_URL").concat(path);
            request = RestAssured.given();
            System.out.println("Add URL :" + prop.getProperty("BASE_URL").concat(path));
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    @When("I create a get request for the endpoint {string}, to get the list of people.")
    public void iCreateAGetRequestForTheEndpointToGetTheListOfPeople(String path) {
        try {
            response = request.given()
                    .when()
                    .get()
                    .then()
                    .contentType(ContentType.JSON)
                    .extract()
                    .response();
            System.out.println("Sending request made: " + path);
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    @Then("should return response code {int} for people query")
    public void youShouldGetAResponseCode(int codeResponse) {
        try {
            Assert.assertEquals(codeResponse, response.getStatusCode());
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    @And("list of person with: id {}, first name {}, last name {}, age {}, id country {}")
    public void idFirstNameLastNameAgeIdCountry(Integer id, String first_name, String last_name, Integer age, Integer country_id) {
        try {
            Person personTest = new Person(id, first_name, last_name, age, country_id);
            System.out.println("Current person: " + personTest);
            Gson gson = new Gson();
            Person[] people = gson.fromJson(response.getBody().asString().trim(), Person[].class);
            for (Person person : people) {
                if (person.getId().equals(id)) {
                    System.out.println("Expected person: " + person);
                    Assert.assertEquals(person, personTest);
                }
            }
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    //

    @Given("I have an endpoint {string} of type POST to allow or create a new person in the system")
    public void iHaveAnEndpointOfTypePOSTToAllowOrCreateANewPersonInTheSystem(String path) {
        try {
            RestAssured.baseURI = prop.getProperty("BASE_URL").concat(path);
            request = RestAssured.given();
            System.out.println("Add URL :" + prop.getProperty("BASE_URL").concat(path));
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    @When("I create a post request to the {string} endpoint to persist the creation of a new person, with a following data: first name {}, last name {}, age {}, id country {}")
    public void iCreateAPostRequestToTheEndpointToPersistTheCreationOfANewPerson(String path, String first_name, String last_name, Integer age, Integer country_id) {
        try {
            String newPerson = "{\"first_name\":\"" + first_name + "\",\"last_name\":\"" + last_name + "\",\"age\":" + age + ",\"country_id\":" + country_id + "}";
            response = request.given()
                    .body(newPerson)
                    .contentType(ContentType.JSON)
                    .when()
                    .post()
                    .then()
                    .extract()
                    .response();
            System.out.println("Sending request made: " + path);

        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @Then("should return response code {int} for creation.")
    public void shouldReturnResponseCodeForCreation(int codeResponse) {
        try {
            if(response.getStatusCode() != codeResponse) System.out.println("Response: " + response.getBody().asString());
            Assert.assertEquals(codeResponse, response.getStatusCode());
        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @And("returns the created person object: id {}, first name {}, last name {}, age {}, id country {}")
    public void returnsTheCreatedPersonObjectIdFirstNameLastNameAgeIdCountry(Integer id, String first_name, String last_name, Integer age, Integer country_id) {
        try {
            Person personTest = new Person(id, first_name, last_name, age, country_id);
            System.out.println("Current person: " + personTest);
            Gson gson = new Gson();
            Person person = gson.fromJson(response.getBody().asString().trim(), Person.class);
            System.out.println("Expected person: " + person);
            Assert.assertEquals(person, personTest);
        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @When("I create a post request on the {string} endpoint to persist the creation of a new person, with all data set to empty: first name {}, last name {}, age {}, country id {}")
    public void iCreateAPostRequestOnTheEndpointToPersistTheCreationOfANewPersonWithAllDataSetToEmptyFirstNameLastNameAgeCountryId(String path, String first_name, String last_name, Integer age, Integer country_id) {
        try {
            String newPerson = "{\"first_name\":\"" + first_name + "\",\"last_name\":\"" + last_name + "\",\"age\":" + age + ",\"country_id\":" + country_id + "}";
            response = request.given()
                    .body(newPerson)
                    .contentType(ContentType.JSON)
                    .when()
                    .post()
                    .then()
                    .extract()
                    .response();
            System.out.println("Sending request made: " + path);

        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @When("I create a post request on the {string} endpoint to persist the creation of a new person, with the country_id attribute that is not persisted: first name {}, last name {}, age {}, country id {}")
    public void iCreateAPostRequestOnTheEndpointToPersistTheCreationOfANewPersonWithTheCountry_idAttributeThatIsNotPersistedFirstNameLastNameAgeCountryId(String path, String first_name, String last_name, Integer age, Integer country_id) {
        try {
            String newPerson = "{\"first_name\":\"" + first_name + "\",\"last_name\":\"" + last_name + "\",\"age\":" + age + ",\"country_id\":" + country_id + "}";
            response = request.given()
                    .body(newPerson)
                    .contentType(ContentType.JSON)
                    .when()
                    .post()
                    .then()
                    .extract()
                    .response();
            System.out.println("Sending request made: " + path);

        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    //

    @And("and an error message that says: {string}")
    public void andAnErrorMessageThatSays(String messageResponse) {
        try {
            String message = response.jsonPath().getString("error");
            System.out.println("Response: " + message);
            if (!message.isEmpty()) {
                Assert.assertEquals(messageResponse, message);
            } else {
                Assert.fail();
            }
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    //

    @Given("I have an endpoint {string} of type DELETE to allow deleting a person that is persisted in the database.")
    public void iHaveAnEndpointOfTypeDELETEToAllowDeletingAPersonThatIsPersistedInTheDatabase(String path) {
        try {
            RestAssured.baseURI = prop.getProperty("BASE_URL").concat(path);
            request = RestAssured.given();
            System.out.println("Add URL :" + prop.getProperty("BASE_URL").concat(path));
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    @When("When I create a delete request for the endpoint {string}, in which I must provide the id {} of the person I will delete by query.")
    public void whenICreateADeleteRequestForTheEndpointInWhichIMustProvideTheIdOfThePersonIWillDeleteByQuery(String path, String id) {
        try {
            response = request.given()
                    .when()
                    .delete(prop.getProperty("BASE_URL").concat(path) + "/" + id)
                    .then()
                    .extract()
                    .response();
            System.out.println("Sending request made: " + path + "/" + id);
        }
        catch (Exception e) {
            Assert.fail();
        }
    }

    @Then("should return response code {int} when deleting.")
    public void shouldReturnResponseCodeWhenDeleting(int codeResponse) {
        Assert.assertEquals(codeResponse, response.getStatusCode());
    }

    @And("returns the following message: {}")
    public void returnsTheFollowingMessage(String messageResponse) {
        try {
            String message = response.jsonPath().getString("message");
            System.out.println("Response: " + message);
            if (!message.isEmpty()) {
                Assert.assertEquals(messageResponse, message);
            } else {
                Assert.fail();
            }
        }
        catch(Exception e) {
            Assert.fail();
        }

    }

    @And("returns the following error message: {}")
    public void returnsTheFollowingErrorMessage(String messageResponse) {
        try {
            String message = response.jsonPath().getString("error");
            System.out.println("Response: " + message);
            if (!message.isEmpty()) {
                Assert.assertEquals(messageResponse, message);
            } else {
                Assert.fail();
            }
        }
        catch(Exception e) {
            Assert.fail();
        }
    }
}
