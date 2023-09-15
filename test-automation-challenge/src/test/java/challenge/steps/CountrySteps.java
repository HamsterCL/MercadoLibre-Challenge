package challenge.steps;

import cl.mercadolibre.automationChallenge.model.Country;
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

public class CountrySteps {

    private RequestSpecification request;
    private Response response;
    private final Properties prop = new Properties();

    public CountrySteps() {
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


    @Given("I have an endpoint {string} of type GET to list all the countries type data that is persisted.")
    public void iHaveAnEndpointOfTypeGETToListAllTheCountriesTypeDataThatIsPersisted(String path) {
        try {
            RestAssured.baseURI = prop.getProperty("BASE_URL").concat(path);
            request = RestAssured.given();
            System.out.println("Add URL :" + prop.getProperty("BASE_URL").concat(path));
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    @When("I create a get request for the endpoint {string}, to get the list of countries.")
    public void iCreateAGetRequestForTheEndpointToGetTheListOfCountries(String path) {
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

    @Then("should return response code {int} for country query")
    public void shouldReturnResponseCodeForCountryQuery(int codeResponse) {
        try {
            Assert.assertEquals(codeResponse, response.getStatusCode());
        }
        catch(Exception e) {
            Assert.fail();
        }
    }

    @And("list of country with: id {}, name {}")
    public void listOfCountryWithIdName(Integer id, String name) {
        try {
            Country countryTest = new Country(id, name);
            System.out.println("Current country: " + countryTest);
            Gson gson = new Gson();
            Country[] countries = gson.fromJson(response.getBody().asString().trim(), Country[].class);
            for (Country country : countries) {
                if (country.getId().equals(id)) {
                    System.out.println("Expected country: " + country);
                    Assert.assertEquals(country, countryTest);
                }
            }
        }
        catch(Exception e) {
            Assert.fail();
        }
    }
}
