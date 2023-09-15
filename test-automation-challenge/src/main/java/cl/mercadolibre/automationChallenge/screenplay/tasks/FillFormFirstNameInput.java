package cl.mercadolibre.automationChallenge.screenplay.tasks;

import cl.mercadolibre.automationChallenge.screenplay.userinterface.ElementPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class FillFormFirstNameInput implements Task {

    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(firstName).into(ElementPage.FIRST_NAME).thenHit(Keys.TAB));
    }
    private final String firstName;

    public FillFormFirstNameInput(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public Performable then(Performable nextPerformable) {
        return Task.super.then(nextPerformable);
    }

    public static FillFormFirstNameInput fillInputFirstName(String firstName) {
        return instrumented(FillFormFirstNameInput.class, firstName);
    }
}
