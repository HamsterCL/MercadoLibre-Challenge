package challenge.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PingPongSteps {

        private RequestSpecification request;
        private Response response;
        private final Properties prop = new Properties();

        public PingPongSteps() {
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

        @Given("There is an endpoint {string} to know the health of the deployed microservices.")
        public void thereIsAnEndpointToKnowTheHealthOfTheDeployedMicroservices(String path) {
                RestAssured.baseURI  = prop.getProperty("BASE_URL").concat(path);
                request = RestAssured.given();
                System.out.println("Add URL :"+prop.getProperty("BASE_URL").concat(path));
        }

        @When("a get request is made on the endpoint {string}.")
        public void aGetRequestIsMadeOnTheEndpoint(String path) {
                response = request.get();
                System.out.println("Sending request made: " + prop.getProperty("BASE_URL").concat(path));
        }

        @Then("You get the code of {int}.")
        public void youGetTheCodeOf(int codeResponse) {
                int statusCode = response.getStatusCode();
                Assert.assertEquals(codeResponse, statusCode);
        }

        @And("message that says {}.")
        public void messageThatSays(String messageResponse) {
                String message= response.jsonPath().getString("message");
                System.out.println("Response: " + message );
                Assert.assertEquals(messageResponse, message);
        }
}
