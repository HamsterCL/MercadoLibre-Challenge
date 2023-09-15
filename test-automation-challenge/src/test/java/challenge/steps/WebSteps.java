package challenge.steps;

import cl.mercadolibre.automationChallenge.screenplay.tasks.*;
import cl.mercadolibre.automationChallenge.screenplay.userinterface.ElementPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class WebSteps {

    @Managed(driver = "remote")

    private Actor administrador = Actor.named("Administrador");

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that Administrator visits the Create Person page to register a person")
    public void thatVisitsThePageToRegisterAPerson() {
        theActorCalled(administrador.getName()).attemptsTo(OpenCreatePageBrowser.on());
    }

    @When("You must complete all the information on the form, first fill out the first name {},")
    public void youMustCompleteAllTheInformationOnTheFormFirstFillOutTheFirstName(String firsName) {
        theActorCalled(administrador.getName()).attemptsTo(FillFormFirstNameInput.fillInputFirstName(firsName));
    }

    @And("then continue with the last name {} field")
    public void thenContinueWithTheLastName(String lastName) {
        theActorCalled(administrador.getName()).attemptsTo(FillFormLastNameInput.fillInputLastName(lastName));
    }

    @And("continue with the age {} field")
    public void continueWithTheAgeField(Integer age) {
        theActorCalled(administrador.getName()).attemptsTo(FillFormAgeInput.fillInputAge(age));
    }

    @And("finally, the country {} field")
    public void finallyTheCountryField(String country) {
        theActorCalled(administrador.getName()).attemptsTo(SelectedComboCountry.withValue(country));
    }

    @Then("you should be able to register a new person")
    public void youShouldBeAbleToRegisterANewPerson() {
        theActorCalled(administrador.getName()).attemptsTo(ClickSubmitButton.called(ElementPage.CREATE_BUTTON));
    }

    @Given("has a list of people in his system and checks it by going to the world view page")
    public void hasAListOfPeopleInHisSystemAndChecksItByGoingToTheWorldViewPage() {
        theActorCalled(administrador.getName()).attemptsTo(OpenWorldViewPageBrowser.on());
        
    }

    @When("to add Diego Maradona")
    public void toAddDiegoMaradona() {
        
    }

    @Then("2 people should appear in the Argentina section of the page.")
    public void peopleShouldAppearInTheArgentinaSectionOfThePage() {
    }
}
