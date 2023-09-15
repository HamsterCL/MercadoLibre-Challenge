package challenge.steps;

import cl.mercadolibre.automationChallenge.screenplay.tasks.OpenBrowser;
import io.cucumber.java.Before;
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
        theActorCalled(administrador.getName()).attemptsTo(OpenBrowser.on());
    }

    @When("he must fill out all the data on the form: {}")
    public <T extends Actor> void heMustFillOutAllTheDataOnTheForm(T actor, String first_name) {
    }

    @Then("you should be able to register a new person")
    public void youShouldBeAbleToRegisterANewPerson() {
    }

}
